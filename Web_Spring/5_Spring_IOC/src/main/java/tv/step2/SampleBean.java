package tv.step2;

public class SampleBean {

	private SampleBean() { // 외부에서는 이 샘플빈을 생성하는게 불가능->메소드 통해서 객체 생성하게 함
		System.out.println("SampleBean() 생성 ");
	}

	// 이렇게 하면 외부에서는 호출이 불가능해짐 왜냐면 이 객체가 생성된 후에 이 메소드를 사용할 수 있기 때문에!
	// SampleBean getInstance() {

	//static으로 만들어주면 객체가 생성되기 전에 미리 메모리에 떠있기때문에 이 메소드를 사용하는게 가능해짐
	//그래서 메소드를 통해서 객체를 생성하는게 가능해짐!
	//아무나 객체 만들지 못하게 방어하므로 보안도 좋고 뭐....그렇다
	//아무튼 이렇게 디폴트 생성자를 통해서 객체를 생성하지 않는경우
	//환경설정 파일에서 factory-method에 등록해줘야한다.
	public static SampleBean getInstance() {
		return new SampleBean();
	}
}
