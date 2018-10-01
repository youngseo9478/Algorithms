package user;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.my.biz.user.dao.UserDAO;
import com.my.biz.user.dao.UserDAO_MyBatis;
import com.my.biz.user.service.UserService;
import com.my.biz.user.service.UserServiceImpl;
import com.my.biz.user.vo.UserVO;

public class UserDAO_MyBatis_Test{
	UserService service;

	@Before
	public void setUp() throws Exception {
		UserDAO dao= new UserDAO_MyBatis();
		service = new UserServiceImpl(dao);
	}

	@After
	public void tearDown() throws Exception {
		service = null;
	}

	
	//@Test
	public void list() {
		System.out.println("==== List ====");
		for(UserVO data: service.getUserList()) {
		System.out.println(data);
		
		}
	}
	
	@Test
	public void add() {
		UserVO vo = new UserVO();
		vo.setId("java10");
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
		System.out.println("getUser(): "+service.getUser("java09"));
				
	}
	
	//@Test
	public void update() {
		UserVO vo = service.getUser("java09");
		vo.setPw("9999");
		
		int row = service.updateUser(vo);
		System.out.println(" update() row : "+row);
		System.out.println(" update(): "+service.getUser("java09"));
	}
	

	
	//@Test
	public void serach() {
		System.out.println("search()"+service.searchUser("id", "09"));
	}
	
	//@Test	
	public void remove() {
		int row = service.removeUser("java09");
		System.out.println("remove() row : "+row);
	}
	
	
	//@Test
	public void login() {
		UserVO vo = service.login("java08", "1234");
		if(vo==null) {
			System.out.println("로그인 실패");
		}
		System.out.println("vo : "+vo);
		
	}
}
