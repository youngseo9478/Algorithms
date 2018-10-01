package tv.step2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
	public static void main(String[] args) {

		String[] config = { "applicationContext.xml" };

		// 2. 팩토리를 상속받은 applicationContext인터페이스를 이용해서 객체 생성
		ApplicationContext context = new ClassPathXmlApplicationContext(config);// spring
		System.out.println("_________________________________________");
		TV user1 = (TV)context.getBean("samsung"); //lazy-init설정이 true라서 필요할때 객체생성함
		TV user2 = (TV)context.getBean("samsung"); //lazy-init설정이 true라서 필요할때 객체생성함
		System.out.println("user1==user2? "+(user1==user2));
	}
}
