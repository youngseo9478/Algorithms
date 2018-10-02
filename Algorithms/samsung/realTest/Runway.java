package realTest;

import java.util.Scanner;

class Runway {
	static final int MAX_N = 20;
	static int[][] map = new int[MAX_N][MAX_N];
	static int[] height = new int[MAX_N];
	static int N, X;

	// 절대값 함수
	static int abs(int a) {
		return a > 0 ? a : -a;
	}

	// 평평한지 확인하는 함수
	static boolean isFlat(int s, int e) {

		if (s < 0 || N <= e) {
			return false;
		}

		for (int i = s; i < e; i++) { //############### 여기서 왜 i<e-1했어 ???그럼 한칸만
			if (height[i] != height[i + 1]) {
				return false;
			}
		}

		return true;
	}

	// 활주로를 지을 수 있는 행/열을 검사하는 함수
	static boolean canRunway() {

		// 2이상 차이나는게 있으면 뭐가됐든 탈락!!
		for (int i = 0; i < N - 1; i++) {
			if (abs(height[i] - height[i + 1]) >= 2) {
				return false;
			}
		}

		// 경사로를 만들 수 있는 곳을 true로 주기위해 모두 false로 초기화
		boolean[] upSlope = new boolean[N];
		boolean[] downSlope = new boolean[N];
		for (int i = 0; i < N; i++) {
			upSlope[i] = downSlope[i] = false;
		}

		for (int i = 0; i < N - 1; i++) {
			// upSlope를 설치해야하는지 확인하기 위함
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
					height[j] = map[j][i];// ###########################왜 i를
											// 넣었어? j인데....
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