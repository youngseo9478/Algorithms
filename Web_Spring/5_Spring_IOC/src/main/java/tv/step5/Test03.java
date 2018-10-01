package tv.step5;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tv.step3.UserVO;

public class Test03 {
	public static void main(String[] args) {

		// 환경설정 파일은 여러개일 수 있기때문에 String배열로 만들어 놓음
		String[] config = { "applicationContext6.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		
		UserService service =(UserService) context.getBean("userService");
		service.login("java01", "1234");//로그인성공
		//service.login("java02", "1234");//로그인실패
		
		
	}
}
