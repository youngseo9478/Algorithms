package user;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.my.biz.user.dao.UserDAO;
import com.my.biz.user.dao.UserDAO_JDBC;
import com.my.biz.user.service.UserService;
import com.my.biz.user.service.UserServiceImpl;
import com.my.biz.user.vo.UserVO;

public class UserDAO_JDBC_Test{

	UserService service;
	UserDAO dao = new UserDAO_JDBC();
	@Before
	public void setUp() throws Exception {
		service = new UserServiceImpl(dao);
	}

	@After
	public void tearDown() throws Exception {
		service = null;
	}

	@Test
	public void list() {
		System.out.println("===get User List test===");
		for(UserVO data : service.getUserList()) {
			System.out.println(data);
		}
	}
	@Test
	public void getUser() {
		System.out.println("===get User test===");
		System.out.println(service.getUser("java01"));
	}
	//@Test
	public void add() {
		System.out.println("===add User test===");
		UserVO vo = new UserVO();
		vo.setId("java07");
		vo.setName("ko");
		vo.setPw("1234");
		vo.setRole("admin");
		int row = service.addUser(vo);
		if(row==0) {
			System.out.println("insert 실패");
		}else {
			System.out.println(row+"행 추가되었습니다.");
		}
	}
	@Test
	public void update() {
		System.out.println("===user Update test===");
		UserVO vo = new UserVO();
		vo.setId("java01");
		vo.setName("영떠");
		vo.setPw("1111");
		vo.setRole("user");
		int row = service.updateUser(vo);
		if(row==0) {
			System.out.println("update에 실패하였습니다.");
		}else {
			System.out.println("update에 성공했습니다.");
		}
	}
	@Test
	public void search() {
		System.out.println("===search User test===");
		List<UserVO> list = service.searchUser("role", "User");
//		for(int i =0; i<list.size(); i++) {
//			System.out.println(list.get(i).getId());
//		}
		for(UserVO vo : list) {
			System.out.println(vo.toString());
		}
	}
	@Test
	public void delete() {
		System.out.println("===delete User test===");
		int row = service.removeUser("java03");
		if(row==0) {
			System.out.println("remove에 실패하였습니다.");
		}else {
			System.out.println("remove에 성공하였습니다.");
		}
	}

}
