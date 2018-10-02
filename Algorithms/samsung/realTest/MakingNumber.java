package realTest;

import java.util.Scanner;

public class MakingNumber {
	static int number[] = new int[13];
	static int N, MIN, MAX;
	static final int INF = 2000000000;
	static int operator[] = new int[4]; // + - * / ¼ø¼­

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			MIN = INF;
			MAX = -INF;
			N = sc.nextInt();
			for (int i = 0; i < 4; i++) {
				operator[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				number[i] = sc.nextInt();
			}
			dfs(operator,number[0],1);
			
			System.out.println("#"+tc+" "+(MAX-MIN));

		}
		sc.close();
	}// end of main

	static void dfs(int remain[], int now, int n) {

		if (n == N) {
			MAX = now > MAX ? now : MAX;
			MIN = now < MIN ? now : MIN;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (remain[i] > 0) {
				remain[i]--;
				if (i == 0) {
					dfs(remain, now + number[n], n + 1);
				} else if (i == 1) {
					dfs(remain, now - number[n], n + 1);
				} else if (i == 2) {
					dfs(remain, now * number[n], n + 1);
				} else if (i == 3) {
					dfs(remain, now / number[n], n + 1);
				}
				remain[i]++;
			}
		}

	}
}
