package step4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
	public static void main(String[] args) {
		
		String[] config = { "applicationContext3.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		HandlerMapping mapping = (HandlerMapping)context.getBean("mapping");
		System.out.println(mapping.getMapping());
		
		
		
	}
}
