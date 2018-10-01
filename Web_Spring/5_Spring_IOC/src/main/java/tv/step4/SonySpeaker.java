package tv.step4;

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
