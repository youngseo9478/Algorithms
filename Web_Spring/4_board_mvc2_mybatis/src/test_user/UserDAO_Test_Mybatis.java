package test_user;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.my.biz.user.dao.UserDAO;
import com.my.biz.user.dao.UserDAO_MyBatis;
import com.my.biz.user.service.UserService;
import com.my.biz.user.service.UserServiceImpl;
import com.my.biz.user.vo.UserVO;

public class UserDAO_Test_Mybatis {
	UserService service;

	@Before
	public void setUp() throws Exception {
		UserDAO dao = new UserDAO_MyBatis();
		service = new UserServiceImpl(dao);
	}

	@After
	public void tearDown() throws Exception {
		service = null;
	}

	@Test
	public void getUserListTest() {
		System.out.println("====getUserList Test====");
		for (UserVO data : service.getUserList()) {
			System.out.println(data);
		}
		System.out.println();
	}

	//@Test
	public void add() {
		UserVO vo = new UserVO();
		vo.setId("java10");
		vo.setName("라라");
		vo.setPw("1234");
		vo.setRole("User");
		int row = service.addUser(vo);
		if (row == 0) {
			System.out.println("인서트 실패");
		}
	}

	//@Test
	public void login() {
		UserVO vo = service.login("java10", "1234");
		System.out.println(vo);
		if (vo == null) {
			System.out.println("로그인 실패");
		}

	}

	//@Test
	public void update() {
		UserVO vo = service.getUser("java10");
		vo.setPw("1111");
		service.updateUser(vo);
	}

	//@Test
	public void getUser() {
		System.out.println(service.getUser("java10"));
	}

	//@Test
	public void search() {
		List<UserVO> list = service.searchUser("id", "1");
		System.out.println("===== 검색 =====");
		for (UserVO data : list) {
			System.out.println(data);
		}
	}

	//@Test
	public void delete() {
		int row = service.removeUser("java04");
		if (row == 0) {
			System.out.println("java04 삭제 X");
		}
	}
}
