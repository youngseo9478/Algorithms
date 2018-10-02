package realTest;

import java.util.Scanner;

class Runway {
	static final int MAX_N = 20;
	static int[][] map = new int[MAX_N][MAX_N];
	static int[] height = new int[MAX_N];
	static int N, X;

	// ���밪 �Լ�
	static int abs(int a) {
		return a > 0 ? a : -a;
	}

	// �������� Ȯ���ϴ� �Լ�
	static boolean isFlat(int s, int e) {

		if (s < 0 || N <= e) {
			return false;
		}

		for (int i = s; i < e; i++) { //############### ���⼭ �� i<e-1�߾� ???�׷� ��ĭ��
			if (height[i] != height[i + 1]) {
				return false;
			}
		}

		return true;
	}

	// Ȱ�ַθ� ���� �� �ִ� ��/���� �˻��ϴ� �Լ�
	static boolean canRunway() {

		// 2�̻� ���̳��°� ������ �����Ƶ� Ż��!!
		for (int i = 0; i < N - 1; i++) {
			if (abs(height[i] - height[i + 1]) >= 2) {
				return false;
			}
		}

		// ���θ� ���� �� �ִ� ���� true�� �ֱ����� ��� false�� �ʱ�ȭ
		boolean[] upSlope = new boolean[N];
		boolean[] downSlope = new boolean[N];
		for (int i = 0; i < N; i++) {
			upSlope[i] = downSlope[i] = false;
		}

		for (int i = 0; i < N - 1; i++) {
			// upSlope�� ��ġ�ؾ��ϴ��� Ȯ���ϱ� ����
			if (height[i] + 1 == height[i + 1]) {
				int s = i - X + 1;
				int e = i;
				if (isFlat(s, e)) {
					for (int j = s; j <= e; j++) {
						upSlope[j] = true;
					}
				} else {
					return false;
				}
			} else if (height[i] - 1 == height[i + 1]) {
				int s = i + 1;
				int e = i + X;
				if (isFlat(s, e)) {
					for (int j = s; j <= e; j++) {
						downSlope[j] = true;
					}
				} else {
					return false;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			if (upSlope[i] && downSlope[i]) {
				return false;
			}
		}

		return true;
	}

	public static void main(String args[]) throws Exception {
	
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			X = sc.nextInt();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int rowCnt, colCnt;
			rowCnt = colCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					height[j] = map[i][j];// ###############################
				}
				if (canRunway()) {
					rowCnt++;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					height[j] = map[j][i];// ###########################�� i��
											// �־���? j�ε�....
				}
				if (canRunway()) {
					colCnt++;
				}
			}
			System.out.println("#" + tc + " " + (colCnt + rowCnt));
		}
		sc.close();
	}
}