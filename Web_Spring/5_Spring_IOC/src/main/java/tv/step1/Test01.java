package tv.step1;

public class Test01 {
	public static void main(String[] args) {
		// LgTV user1 = new LgTV();
		// SamsungTV user2 = new SamsungTV();
		// user1=user2; 강력한 커플링 : 서로 바꿔서는 절대 사용 할 수 없음(호환불가)ㄴ
		// 클래스 디자인 할 때에는 low 커플링 high 응집력이 좋은것!

		TV user1 = (TV) TVFactory.getBean("lg");
		TV user2 =(TV) TVFactory.getBean("samsung");
		user1 = user2; //이제  사용할 수 있음
	}
}
