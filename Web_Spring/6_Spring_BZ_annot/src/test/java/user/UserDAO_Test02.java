package user;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.my.biz.user.service.UserService;
import com.my.biz.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class) //spring환경구축해서 여기서 테스트해보려는 것! 원래는 setup에서 주석한것과같이 해줘야함
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class UserDAO_Test02 {
	
	@Autowired
	UserService service;

	@Before
	public void setUp() throws Exception {
		//UserDAO dao = new UserDAO_JDBC();
		//UserDAO dao = new UserDAO_Spring();
		//UserDAO dao = new UserDAO_MyBatis();
		//UserDAO dao = new UserDAO_MyBatis_Interface();
		//service = new UserServiceImpl(dao);
		// String[] config = {"applicationContext.xml"};
		// ApplicationContext context = new ClassPathXmlApplicationContext(config);
		// service = (UserService) context.getBean("userService");
		
	}

	@After
	public void tearDown() throws Exception {
		service = null;
	}

	//@Test
	public void list() {
		System.out.println("==== User List ====");
		for(UserVO data  :service.getUserList()) {
			System.out.println(data);
		}
	}
	//@Test
	public void add() {
	    UserVO vo = new UserVO();
	    vo.setId("java09");
	    vo.setName("ko");
	    vo.setPw("1234");
	    vo.setRole("admin");
	    int row = service.addUser(vo);
	    if(row == 0) {
	    	System.out.println("인서트 실패");
	    }
	}
	@Test
	public void login() {
		UserVO vo = service.login("java11", "1234");
		//UserVO vo = service.login("", "1234"); //runtimeException
		//UserVO vo = service.login(null, "1234");//nullpointerException
		System.out.println(vo);
		if(vo == null) {
			System.out.println("로그인 실패");
		}
		    
	}
	//@Test
	public void update() {
	   UserVO vo = service.getUser("java09");
	   vo.setPw("9999");
	   service.updateUser(vo);
	}
	//@Test
	public void getUser() {
	   System.out.println(service.getUser("java09"));
	}
	//@Test
	public void search() {
		List<UserVO> list = service.searchUser("id", "09");
		System.out.println("===== 검색 =====");
		for(UserVO data :list) {
			System.out.println(data);
		}
	}
	//@Test
	public void delete() {
	     int row =service.removeUser("java09");
	     if(row == 0) {
	    	 System.out.println("java09 삭제 X");
	     }
	}
}









