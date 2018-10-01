package tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.my.biz.user.dao.UserDAO;
import com.my.biz.user.vo.UserVO;

@Service("txservice") //spring한테 알아서 해달라고 맡기는 것..ㅎ
public class UserService {
	
	@Autowired //spring이 dao여러개 관리하고 있으므로 알아서 해달라고..
	@Qualifier("userMybatis1")
	UserDAO dao;
	
	public void addUser(UserVO vo, boolean flag) {
		dao.addUser(vo);
		System.out.println(vo.getId()+" insert 수행 OK");
		if(flag) {
			throw new RuntimeException("문제 발생");
		}
		
		//백업레코드 저장하는 것 ->레코드 하나가 입력된다면 백업레코드 삽입 과정까지 완벽히 수행하는게 하나의 트랜잭션
		//원본 레코드 인서트 실패 시 롤백해서 삽입 전 상태로 돌아가야함.
		vo.setId(vo.getId()+" *");
		dao.addUser(vo);
		System.out.println(vo.getId()+" insert 수행 OK");
	}
	
	public void userList() {
		System.out.println("**** User List ****");
		for(UserVO user : dao.getUserList()) {
			System.out.println(user);
		}
	}
}









