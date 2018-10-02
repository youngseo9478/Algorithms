package realTest;

import java.util.Scanner;

class StudentAvg {
	static final int STUDENTS = 1000;
	static int[] score = new int[STUDENTS];
	static int[] count = new int[100];

	public static void main(String args[]) throws Exception {
		/*
		 * 아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다. 여러분이
		 * 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후, 이 코드를 프로그램의 처음 부분에
		 * 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다. 따라서 테스트를 수행할 때에는 아래
		 * 주석을 지우고 이 메소드를 사용하셔도 좋습니다. 단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석
		 * 처리 하셔야 합니다.
		 */
		// System.setIn(new FileInputStream("res/input.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) { //################# 아까는 계속 첫번째 데이터셋만 작동했자녀... 데이터 셋이 몇개가 들어와도 계속 수행되려면... hasNext값이 있으면 계속해줘야해~
			int T;
			T = sc.nextInt();
			/*
			 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
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