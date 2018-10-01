package tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.biz.user.vo.UserVO;

public class TxTest {
	public static void main(String[] args) {
		String[] config = { "tx.xml" }; // tx.xml에서 import안해줬었다면 여기서 ,하고 applicationContext.xml해도 됨
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		// context가 곧 spring객체인 것
		UserService service = (UserService) context.getBean("txservice");

		UserVO user = new UserVO();
		user.setId("test03");
		user.setName("테스터");
		user.setPw("1111");
		user.setRole("admin");

		service.addUser(user, false);
		//service.userList();
	}
}
