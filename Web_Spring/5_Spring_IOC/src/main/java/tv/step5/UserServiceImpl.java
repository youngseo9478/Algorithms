package tv.step5;

import java.util.Locale;

import javax.inject.Inject;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("userService") //@Component랑 같은데 서비스라는걸 명시해주기 위해 이걸로 사용 ~
public class UserServiceImpl implements UserService {

	// 1번방법.UserService, ApplicationContextAware { // appContext를 찾아주는 인터페이스

	@Inject // 2번방법.같은타입이 어차피 한개이니까 그거 여기다 주입하라는 것(ApplicationContext이거하나뿐임)
	ApplicationContext context;
	// String[] config = { "applicationContext6.xml" };
	// ApplicationContext context = new ClassPathXmlApplicationContext(config);
	// 이와같이 안하려면 implements ApplicationContextAware하면 됨

	public UserServiceImpl() {
		System.out.println("UserServiceImpl() 생성자");
	}

	@Override
	public void login(String id, String pw) {

		if (id.equals("java01") && pw.equals("1234")) {
			Object[] msg = { id };
			System.out.println(context.getMessage("login.success", msg, Locale.getDefault()));
		} else {
			System.out.println(context.getMessage("login.fail", null, Locale.ENGLISH));
		}
	}

	// 1번방법. @Override// 콜백메소드이고 자동으로 호출되기때문에 객체 생성과 동시에 실행된다.
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// arg0은 applicationContext의 주소를 가지고 오는 콜백메소드로 현재 여기서 쓰는 context에 대입시켜주면 끝
		System.out.println("setApplicationContext(~)수행...");
		this.context = arg0;
	}
}
