package tv.step5;

import org.springframework.stereotype.Component;

@Component("sony") //bean태그의 역할을 함
public class SonySpeaker implements Speaker{

	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker volume UP");
	}

	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker volume DOWN");
	}

}
