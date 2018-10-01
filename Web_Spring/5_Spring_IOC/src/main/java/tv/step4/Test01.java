package tv.step4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tv.step3.UserVO;

public class Test01 {
	public static void main(String[] args) {

		// 환경설정 파일은 여러개일 수 있기때문에 String배열로 만들어 놓음
		String[] config = { "applicationContext4.xml" };

		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		TV user1 = (TV) context.getBean("lg");
		user1.powerOn();
		user1.volumnUp();
		user1.volumnDown();
		user1.powerOff();

		TV user2 = (TV) context.getBean("samsung");
		user2.powerOn();
		user2.volumnUp();
		user2.volumnDown();
		user2.powerOff();


	}
}
