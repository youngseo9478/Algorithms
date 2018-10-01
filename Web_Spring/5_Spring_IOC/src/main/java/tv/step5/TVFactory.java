package tv.step5;

//팩토리 디자인 패턴
public class TVFactory {
	public static Object getBean(String keyname) {
		if (keyname.equals("samsung")) {
			return new SamsungTV();
		} else if (keyname.equals("lg")) {
			return new LgTV();
		}
		return null;
	}
}
