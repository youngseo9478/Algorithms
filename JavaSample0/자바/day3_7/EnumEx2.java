package day3_7;

enum Transportation {
	BUS(100) {
		int fare(int distance) {
			return distance * BASIC_FARE;
		}
	},
	TRAIN(150) {
		int fare(int distance) {
			return distance * BASIC_FARE;
		}
	},
	SHIP(100) {
		int fare(int distance) {
			return distance * BASIC_FARE;
		}
	},
	AIRPLANE(300) {
		int fare(int distance) {
			return distance * BASIC_FARE;
		}
	};
	
	protected final int BASIC_FARE; //protected�� �ؾ� �� ������� ���ٰ���
	
	Transportation(int basicFare){//private Transportation(int basicFare){
		BASIC_FARE = basicFare;
	}
	
	public int getBasicFare(){return BASIC_FARE;}
	
	abstract int fare(int distance); //�Ÿ��� ���� ��� ���
}

public class EnumEx2 {

	public static void main(String[] args)
	{
		System.out.println("bus fee="+Transportation.BUS.fare(100));
		System.out.println("train fee="+Transportation.TRAIN.fare(100));
		System.out.println("ship fee="+Transportation.SHIP.fare(100));
		System.out.println("airplane fee="+Transportation.AIRPLANE.fare(100));
		
	}
}
