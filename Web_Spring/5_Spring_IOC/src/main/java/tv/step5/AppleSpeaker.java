package tv.step5;

import org.springframework.stereotype.Component;

@Component
public class AppleSpeaker implements Speaker{

	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker volume UP");
	}

	@Override
	public void volumeDown() {
		System.out.println("AppleSpeaker volume DOWN");
	}

}
