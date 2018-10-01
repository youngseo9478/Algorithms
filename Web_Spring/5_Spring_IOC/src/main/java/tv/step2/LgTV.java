package tv.step2;

public class LgTV implements TV{

	public LgTV(){
		System.out.println("LgTV() 객체 생성");
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
		System.out.println("Lg TV volumnUp");
		
	}

	@Override
	public void volumnDown() {
		System.out.println("Lg TV volumnDown");
		
	} //TV라는 규칙을 따르는 티비가 된다.
	
}
