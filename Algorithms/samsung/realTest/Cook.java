package realTest;

import java.util.Scanner;

public class Cook {
	static int S[][], ans;
	static final int INF = 2000000;
	static boolean check[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			S = new int[N + 5][N + 5];
			check = new boolean[N+5];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					S[i][j] = sc.nextInt();
				}
			}

			ans = INF;
			
			recursion(N, 0, N/2);
			
			System.out.println("#"+tc+" "+ans);

		}
	} // end of main

	// dfs
	static void recursion(int N, int cnt, int food) {

		if (cnt == N) {
			int A = 0, B = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j)
						continue;

					// A
					if (check[i] && check[j]) {
						A += S[i][j];
					}

					// B
					if (!check[i] && !check[j]) {
						B += S[i][j];
					}
				}
			}
			ans = min(ans, abs(A - B));
			return;
		}

		// A
		if (food > 0) {
			check[cnt] = true;
			recursion(N, cnt + 1, food - 1);
			check[cnt] = false;
		}

		// B
		recursion(N, cnt + 1, food);

	} // end of recursion

	static int abs(int a) {
		return a > 0 ? a : -a;
	}

	static int min(int a, int b) {
		return a > b ? b : a;
	}
}
