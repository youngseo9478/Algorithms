package tv.step5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class LgTV implements TV {
	
	@Autowired
	@Qualifier("appleSpeaker") //AppleSpeaker에 @Component만 했기때문에 첫글자 소문자가 이름!
	Speaker speaker;
	
	public LgTV() {
		System.out.println("LgTV() 객체 생성");
	}

	public LgTV(Speaker speaker) {
		this.speaker = speaker;
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	@Override
	public void powerOn() {
		System.out.println("Lg TV power On");

	}

	@Override
	public void powerOff() {
		System.out.println("Lg TV power Off");

	}

	@Override
	public void volumnUp() {
		speaker.volumeUp();
		// System.out.println("Lg TV volumnUp");

	}

	@Override
	public void volumnDown() {
		speaker.volumeDown();
		// System.out.println("Lg TV volumnDown");

	} // TV라는 규칙을 따르는 티비가 된다.

}
