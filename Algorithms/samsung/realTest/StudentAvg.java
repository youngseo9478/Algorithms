package realTest;

import java.util.Scanner;

class StudentAvg {
	static final int STUDENTS = 1000;
	static int[] score = new int[STUDENTS];
	static int[] count = new int[100];

	public static void main(String args[]) throws Exception {
		/*
		 * �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�. ��������
		 * �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��, �� �ڵ带 ���α׷��� ó�� �κп�
		 * �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�. ���� �׽�Ʈ�� ������ ������ �Ʒ�
		 * �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�. ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ�
		 * ó�� �ϼž� �մϴ�.
		 */
		// System.setIn(new FileInputStream("res/input.txt"));

		/*
		 * ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) { //################# �Ʊ�� ��� ù��° �����ͼ¸� �۵����ڳ�... ������ ���� ��� ���͵� ��� ����Ƿ���... hasNext���� ������ ����������~
			int T;
			T = sc.nextInt();
			/*
			 * ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
			 */

			for (int i = 0; i < STUDENTS; i++) {
				score[i] = sc.nextInt();
			}

			for (int i = 0; i < 100; i++) {
				count[i] = 0;
			}

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < STUDENTS; j++) {
					if (i == score[j]) {
						count[i]++;
					}
				}
			}
			int max = 0;
			int avg = 0;
			for (int i = 0; i < 100; i++) {
				if (max <= count[i]) {
					max = count[i];
					avg = i;
				}
			}
			System.out.println("#" + T + " " + avg);
		}
		sc.close();
	}
}