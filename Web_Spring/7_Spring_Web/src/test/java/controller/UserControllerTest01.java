package controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration	//controller는 webapp
@ContextConfiguration(locations= {	//환경설정 파일들을 string으로 넘긴다
		"file:src/main/resources/applicationContext4.xml",
		"file:src/main/webapp/WEB-INF/action-servlet.xml"
})
public class UserControllerTest01 {	//라이브러리 추가 필요
	
	//@Inject
	@Autowired
	WebApplicationContext context;
	
	MockMvc mvc;	//mvc기반에서 controller를 테스트할 수 있는 mock 객체(가상으로 테스트할 수 있는 객체)
					
	@Before
	public void setUp() throws Exception {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();	//mvc 생성
		
	}

	@After
	public void tearDown() throws Exception {
	}

	//@Test
	public void hellodo() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello.do")).andDo(print());
		//hello.do로 요청이 들어오면 andDo(콜백메소드)수행 

	}
	
	@Test
	public void listdo() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/listuser.do")).andDo(print());
	}

}
