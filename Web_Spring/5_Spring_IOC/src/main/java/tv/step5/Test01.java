package tv.step5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tv.step3.UserVO;

public class Test01 {
	public static void main(String[] args) {

		// 환경설정 파일은 여러개일 수 있기때문에 String배열로 만들어 놓음
		String[] config = { "applicationContext6.xml" };

		ApplicationContext context = new ClassPathXmlApplicationContext(config);

		TV user1 = (TV) context.getBean("lgTV"); // @기반으로하면 클래스명 첫글자만 소문자로 바뀐이름으로 바인딩 됨~

		user1.powerOn();
		user1.volumnUp(); //speaker가 없어서 널포인터예외
		user1.volumnDown();
		user1.powerOff();

		TV user2 = (TV) context.getBean("samsung");
		user2.powerOn();
		user2.volumnUp();
		user2.volumnDown();
		user2.powerOff();

	}
}
