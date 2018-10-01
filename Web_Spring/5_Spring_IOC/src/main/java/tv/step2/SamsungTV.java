package tv.step2;

public class SamsungTV implements TV {

	public SamsungTV() {
		System.out.println("SamsungTV() 객체 생성");
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
		System.out.println("SamsungTV volumnUp");

	}

	@Override
	public void volumnDown() {
		System.out.println("SamsungTV volumnDown");

	}// TV라는 규칙을 따르는 티비가 된다.ㄴ

}
