package tv.step3;

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
