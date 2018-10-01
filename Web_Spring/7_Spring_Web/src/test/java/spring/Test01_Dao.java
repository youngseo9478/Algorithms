package spring;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.my.biz.board.dao.BoardDAO;
import com.my.biz.user.dao.UserDAO;
import com.my.biz.user.service.UserService;
import com.my.biz.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class Test01_Dao {
	
	@Autowired
	UserService service;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void list() {
		System.out.println("********* UserList *********");
		for(UserVO vo : service.getUserList()) {
			System.out.println(vo);
		}
	}

}
