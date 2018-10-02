package realTest;

import java.util.Scanner;

public class Runway2 {
	static final int MAX_N = 20;
	static int N, X;
	static int runway[][] = new int[MAX_N][MAX_N];
	static int height[] = new int[MAX_N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			X = sc.nextInt();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					runway[i][j] = sc.nextInt();
				}
			}

			int rowCnt, colCnt;
			rowCnt = colCnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					height[j] = runway[i][j];
				}
				if (canRunway()) {
					rowCnt++;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					height[j] = runway[j][i];
				}
				if (canRunway()) {
					colCnt++;
				}
			}
			System.out.println("#" + tc + " " + (colCnt + rowCnt));
		}
		sc.close();
	} // end of main

	static boolean canRunway() {
		for (int i = 0; i < N - 1; i++) {
			// 차이가 2이상나면 활주로 건설 불가
			if (abs(height[i] - height[i + 1]) >= 2) {
				return false;
			}
		}
		boolean upSlope[] = new boolean[N];
		boolean downSlope[] = new boolean[N];
		for (int i = 0; i < N; i++) {
			upSlope[i] = false;
			downSlope[i] = false;
		}

		for (int i = 0; i < N - 1; i++) {

			// down
			if (height[i] - 1 == height[i + 1]) {
				int s = i + 1;
				int e = i + X;
				if (isFlat(s, e)) {
					for (int j = s; j <= e; j++) {
						downSlope[j] = true;
					}
				} else {
					return false;
				}
			} else if (height[i] + 1 == height[i + 1]) { // up
				int s = i - X + 1;
				int e = i;
				if (isFlat(s, e)) {
					for (int j = s; j <= e; j++) {
						upSlope[j] = true;
					}
				} else {
					return false;
				}
			}

		}
		for (int j = 0; j < N; j++) {
			if (upSlope[j] && downSlope[j]) {
				return false;
			}
		}
		return true;
	}// end of canRunway

	static int abs(int a) {
		return a > 0 ? a : -a;
	} // end of abs

	static boolean isFlat(int s, int e) {
		if (s < 0 || N <= e)
			return false;
		for (int i = s; i < e; i++) {
			if (height[i] != height[i + 1]) {
				return false;
			}
		}
		return true;
	} // end of isFlat
}
