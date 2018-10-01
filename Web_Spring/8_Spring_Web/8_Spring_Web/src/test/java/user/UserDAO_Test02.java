package user;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.biz.user.dao.UserDAO;
import com.my.biz.user.dao.UserDAO_JDBC;
import com.my.biz.user.dao.UserDAO_MyBatis;
import com.my.biz.user.dao.UserDAO_MyBatis_Interface;
import com.my.biz.user.dao.UserDAO_Spring;
import com.my.biz.user.service.UserService;
import com.my.biz.user.service.UserServiceImpl;
import com.my.biz.user.vo.UserVO;

public class UserDAO_Test02{
	UserService service;

	@Before
	public void setUp() throws Exception {
		//UserDAO dao= new UserDAO_JDBC();
		//UserDAO dao= new UserDAO_Spring();
		//UserDAO dao= new UserDAO_MyBatis();
		//UserDAO dao = new UserDAO_MyBatis_Interface();
		//service = new UserServiceImpl(dao);
		String[] config = {"applicationContext.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		service = (UserService) context.getBean("userService");
	}

	@After
	public void tearDown() throws Exception {
		service = null;
	}

	
	@Test
	public void list() {
		System.out.println("==== List ====");
		for(UserVO data: service.getUserList()) {
		System.out.println(data);
		
		}
	}
	
	//@Test
	public void add() {
		UserVO vo = new UserVO();
		vo.setId("java13");
		vo.setName("ko");
		vo.setPw("1234");
		vo.setRole("user");
		int row = service.addUser(vo);
		System.out.println("addUser : "+row);
		if(row==0) {
			System.out.println("인서트 실패");
		}
	}

	
	
	//@Test
	public void getUser() {
		System.out.println("getUser(): "+service.getUser("java13"));
				
	}
	
	//@Test
	public void update() {
		UserVO vo = service.getUser("java13");
		vo.setPw("9999");
		
		int row = service.updateUser(vo);
		System.out.println(" update() row : "+row);
		System.out.println(" update(): "+service.getUser("java13"));
	}
	

	
	//@Test
	public void serach() {
		System.out.println("search()"+service.searchUser("id", "java"));
	}
	
	//@Test	
	public void remove() {
		int row = service.removeUser("java13");
		System.out.println("remove() row : "+row);
	}
	
	
	
	@Test
	public void login() {
		UserVO vo = service.login("java02", "1234");
		if(vo==null) {
			System.out.println("로그인 실패");
		}		
		System.out.println("vo : "+vo);
	}
}
