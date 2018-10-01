package tv.step2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
	public static void main(String[] args) {
		
		//환경설정 파일은 여러개일 수 있기때문에 String배열로 만들어 놓음
		String[] config = {"applicationContext.xml"};
		
		// LgTV user1 = new LgTV();
		// SamsungTV user2 = new SamsungTV();
		// user1=user2; 강력한 커플링 : 서로 바꿔서는 절대 사용 할 수 없음(호환불가)ㄴ
		// 클래스 디자인 할 때에는 low 커플링 high 응집력이 좋은것!
		
		// 1. 가장 기본으로는 beanFactory로 객체를 생성함
		// TV user1 = (TV) TVFactory.getBean("lg");
		// TV user2 =(TV) TVFactory.getBean("samsung");
		// user1 = user2; //이제 사용할 수 있음
		
		// 2. 팩토리를 상속받은 applicationContext인터페이스를 이용해서 객체 생성
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		TV user1 = (TV) context.getBean("lg");
		TV user2 = (TV) context.getBean("samsung");
		
	}
}
