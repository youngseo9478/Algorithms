package spring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.my.biz.user.dao.UserDAO;
import com.my.biz.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class) //spring환경구축해서 여기서 테스트해보려는 것! 원래는 setup에서 주석한것과같이 해줘야함
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class Test01_DAO { //이제 스프링환경의 테스트 클래스가 된다.

	@Autowired
	@Qualifier("userMybatis1") //jdbc, mybatis등 여러종류니까 이름을 줘야함
	UserDAO dao;
	
	@Before
	public void setUp() throws Exception {
		// String[] config = {"applicationContext.xml"};
		// ApplicationContext context = new ClassPathXmlApplicationContext(config);
		// service = (UserService) context.getBean("userService");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println("***********UserList***********");
		for(UserVO vo : dao.getUserList()) {
			System.out.println(vo);
		}
		
	}

}
