package day27;

public class ControllerEx7 { // ����� �� for��->�ݺ����� ����

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + "��° ����");
		}

		System.out.println("================");

		for (int i = 10; i > 0; i--) {
			System.out.println(11 - i + "��° ����");
		}

		// 1~10������ ���� ����ϴ� ���α׷�
		int result = 0;

		for (int i = 0; i < 10; i++) {
			result += i; // �̰� ����ð��� ���� �ѹ��� ������ ����� ����þ� ->n(n+1)/2
							// n��Ŀ������ for����ð��� ���� Ŀ���� �ݸ� �� ���� �ѹ��� �ϸ� ��.
		}
		System.out.println("1~10������ �� :" + result);
	}
}
