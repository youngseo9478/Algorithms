package user;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.biz.user.dao.UserDAO;
import com.my.biz.user.dao.UserDAO_JDBC;
import com.my.biz.user.dao.UserDAO_Spring;
import com.my.biz.user.service.UserService;
import com.my.biz.user.service.UserServiceImpl;
import com.my.biz.user.vo.UserVO;

public class UserDAO_Test2_Spring {
	UserService service;

	@Before
	public void setUp() throws Exception {
		// UserDAO dao = new UserDAO_Spring();
		// service = new UserServiceImpl(dao);
		String[] config = { "applicationContext.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		service = (UserService) context.getBean("userService");
	}

	@After
	public void tearDown() throws Exception {
		service = null;
	}

	@Test
	public void list() {
		System.out.println("==== User List ====");
		for(UserVO data  :service.getUserList()) {
			System.out.println(data);
		}
	}
	//@Test
	public void add() {
	    UserVO vo = new UserVO();
	    vo.setId("java14");
	    vo.setName("고구마");
	    vo.setPw("1234");
	    vo.setRole("admin");
	    int row = service.addUser(vo);
	    if(row == 0) {
	    	System.out.println("인서트 실패");
	    }
	}
	//@Test
	public void login() {
		UserVO vo = service.login("java01", "1111");
		System.out.println(vo);
		if(vo == null) {
			System.out.println("로그인 실패");
		}
		    
	}
	//@Test
	public void update() {
	   UserVO vo = service.getUser("java06");
	   vo.setPw("9999");
	   service.updateUser(vo);
	}
	//@Test
	public void getUser() {
	   System.out.println(service.getUser("java14"));
	}
	//@Test
	public void search() {
		List<UserVO> list = service.searchUser("id", "1");
		System.out.println("===== 검색 =====");
		for(UserVO data :list) {
			System.out.println(data);
		}
	}
	//@Test
	public void delete() {
	     int row =service.removeUser("java14");
	     if(row == 0) {
	    	 System.out.println("java09 삭제 X");
	     }
	}
}









