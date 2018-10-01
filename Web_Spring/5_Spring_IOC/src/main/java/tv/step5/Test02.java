package tv.step5;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tv.step3.UserVO;

public class Test02 {
	public static void main(String[] args) {

		// 환경설정 파일은 여러개일 수 있기때문에 String배열로 만들어 놓음
		String[] config = { "applicationContext6.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		
		System.out.println(context.getMessage("hello", null, Locale.ENGLISH)); //키, {}, 나라정보
		System.out.println(context.getMessage("hello", null, Locale.KOREA)); 
		
		//locale은 시스템에서가져오는 정보
		Locale locale = Locale.getDefault(); //한국
		Object[] msg = {"admin","user"};
		System.out.println(context.getMessage("login.success", msg, locale)); //{0}은 배열의 0번째! 그러므로 바인딩시켜줘야함
		
		
	}
}
