package realTest;

import java.util.Scanner;

public class Ladder_my2 {

	static int N, M, H, ans = -1;
	static int[][] map = new int[32][12];
	static boolean checkFlag = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();

		for (int i = 0; i < M; i++) {
			int dy = sc.nextInt();
			int dx = sc.nextInt();
			map[dy][dx] = 1;
			map[dy][dx + 1] = 2;
		}

		for (int i = 0; i <= 3; i++) {
			// 0~3까지 반복
			dfs(0, i);
			if (checkFlag)
				break;
		}

		System.out.println(ans);
		sc.close();
	}

	public static void dfs(int curCnt, int addCnt) {
		if (checkFlag)
			return;
		
		if (curCnt == addCnt) {
			boolean flag = true;
			for (int i = 1; i <= N; i++) {
				int index = i;
				for (int j = 1; j <= H; j++) {
					if (map[j][index] == 0)
						continue; // 아래로 이동
					if (map[j][index] == 1) {
						index++;
					} else if (map[j][index] == 2) {
						index--;
					}
				}
				if (i != index) {
					flag = false;
					break;
				}
			}
			if (flag) {
				ans = addCnt;
				checkFlag = true;
			}
			return;
		}
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= N - 1; j++) {
				if (map[i][j] > 0 || map[i][j + 1] > 0)
					continue;
				map[i][j] = 1;
				map[i][j + 1] = 2;
				dfs(curCnt + 1, addCnt);
				map[i][j] = 0;
				map[i][j + 1] = 0;
			}
		}
	}
}
