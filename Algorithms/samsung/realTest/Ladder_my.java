package realTest;

import java.util.Scanner;

public class Ladder_my {

	static int N, M, H, ans = -1;
	static int[][] map = new int[32][12]; // 그냥 좀 크게 줌
	static boolean checkFlag = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 세로선
		M = sc.nextInt(); // 현재 가로선 개수
		H = sc.nextInt(); // 가로선

		for (int i = 0; i < M; i++) {
			int dy = sc.nextInt();
			int dx = sc.nextInt();

			map[dy][dx] = 1; // 오른쪽으로 이동 지정
			map[dy][dx + 1] = 2; // 왼쪽으로 이동 지정
		}

		for (int i = 0; i <= 3; i++) // 가로선 없을때 부터 최대 3번 까지 확인 !
		{
			dfs(0, i);
			if (checkFlag)
				break; // 최소값을 찾은 경우 break
		}
		System.out.println(ans);
		sc.close();
	}

	public static void dfs(int curLine, int targetLine) {
		if (checkFlag)
			return;

		if (curLine == targetLine) // 검사 시작 !
		{
			boolean flag = true;
			for (int i = 1; i <= N; i++) {
				int target = i; // 검사 세로 선 위치!
				for (int j = 1; j <= H; j++) {
					if (map[j][target] == 0)
						continue; // 아래로 이동

					if (map[j][target] == 1)
						target++; // 오른쪽 이동
					else if (map[j][target] == 2)
						target--; // 왼쪽 이동
				}
				if (target != i) { // 해당 세로선이 아닌 경우
					flag = false;
					break;
				}
			}
			if (flag) {
				ans = targetLine; // 추가한 가로선의 최소값 찾음
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
				dfs(curLine + 1, targetLine);
				// 다시 원상태로 복귀
				map[i][j] = 0;
				map[i][j + 1] = 0;
			}
		}
	}
}
