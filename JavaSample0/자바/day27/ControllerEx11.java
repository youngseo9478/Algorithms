package day27;

import java.util.Scanner;

public class ControllerEx11 { // do while��! ���ǽ��� Ȯ���ϱ����� ������ �ѹ��� ����Ǵ� ��. ��ó�� �ĺ�

	public static void main(String[] args) {
		int i = 5;
		do {
			System.out.println("������ �� ���� �����մϴ�.");
		} while (i > 6); // ������ ���̱� ������ �����ݷ�

		int answer = 0;
		answer = (int) (Math.random() * 100) + 1; // Math.random()�� ������ �߻���Ŵ ������ (0~0.999...)
													// ����� *100�ϸ� (0~99.99...)
													// ���⿡ (int)�ϸ� (0~99)���� ����
													// ����� +1�ϸ� (1~100)�����߻���Ű���ڵ�!!
		Scanner sc = new Scanner(System.in);
		int input = 0;
		do {
			System.out.println("1~100���� ������ �Է��ϼ��� > ");
			input = sc.nextInt();
			if (input > answer)
				System.out.println("�� ���� ���� �Է��ϼ���");
			else if (input < answer)
				System.out.println("�� ū ���� �Է��ϼ���");

		} while (input != answer); // ****���� ���� ������ ����϶�� �� -->�� �����̸� stop*****

		System.out.println("������ ���߼̽��ϴ�~~¦¦¦");
	}

}
