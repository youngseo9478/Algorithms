package tv.step5;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("samsung") //원하는 이름으로 바인딩도 가능
@Service("samsung")
public class SamsungTV implements TV {

	// @Autowired //speaker타입이 두가지일거라서 이렇게만 해주면 에러날 것(에러확인하기)
	// @Qualifier("sony") //@Component("sony")이렇게 해줬기때문에 sony만해도 된다.

	@Resource(name = "sony")
	Speaker speaker;

	public SamsungTV() {
		System.out.println("SamsungTV() 객체 생성");
	}

	public SamsungTV(Speaker speaker) {
		super();
		this.speaker = speaker;
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public void init() {
		System.out.println("초기화작업 수행");
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTV power On");

	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV power Off");

	}

	@Override
	public void volumnUp() {
		speaker.volumeUp();
		// System.out.println("SamsungTV volumnUp");

	}

	@Override
	public void volumnDown() {
		speaker.volumeDown();
		// System.out.println("SamsungTV volumnDown");

	}// TV라는 규칙을 따르는 티비가 된다.ㄴ

}
