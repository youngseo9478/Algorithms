package tv.step2;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
	public static void main(String[] args) {

		String[] config = { "applicationContext.xml" };

		// 2. 팩토리를 상속받은 applicationContext인터페이스를 이용해서 객체 생성
		ApplicationContext context = new ClassPathXmlApplicationContext(config);// spring

		TV user1 = (TV) context.getBean("lg");
		user1.powerOn();
		user1.volumnUp();
		user1.volumnDown();
		user1.powerOff();

		TV user2 = context.getBean("samsung", TV.class); // 타입을 함께넘겨주면 캐스팅 필요 없음
		TV user3 = context.getBean("samsung", TV.class); // 타입을 함께넘겨주면 캐스팅 필요 없음
		System.out.println("default scope => SingleTone ? " + (user2 == user3)); // 주소가 같은지 비교
		// 객체를 계속 띄우는게 아니라 객체 하나를 띄어서 두 개에 같은 객체를 준 것 그래서 주소가 같다.
		user2.powerOn();
		user2.powerOff();
		user2.volumnUp();
		user2.volumnDown();

		Calendar now = (Calendar) context.getBean("now");
		System.out.println(now);
		// 캘린더 객체는 생성자를 통해서 생성할 수 없음. 즉 new 안쓰고 getInstance사용해서 객체 생성함
		// 환경설정 파일에 lg/samsung티비같이 기술해두면 디폴트생성자를 통해서 객체를 생성한다는 것이기 때문에
		// 디폴트 생성자를 통하지 않는 캘린더 객체는 생성시 에러가 발생하는 것!
		// 그래서 factory-method에 getInstance를 써줘야 에러 발생 안한다.
		
		SampleBean sample = (SampleBean) context.getBean("sample");
		
	}
}
