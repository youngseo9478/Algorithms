package difficulty2;

import java.util.Scanner;

public class FlyPaang {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int arr[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int col = 0;
			int row = 0;
			int max = 0; //얘를 while 안에 넣어버리면 계속 모든 sum이 max보다 크다고 계산되서 그냥 마지막 합이 max에 들어가게 됨
			while (true) {
				int sum = 0; //sum 초기화 위치가 중요함
				for (int i = row; i < row + M; i++) {
					for (int j = col; j < col + M; j++) {
						sum += arr[i][j];
					}
				}
				max = max < sum ? sum : max;
				col++;
				if (col + M > N) { // col+m>=N이 아닌 이유는 바로 위에서 col++을 했기 때문
					col = 0;
					row++;
					if (row + M > N) { //역시 마찬가지
						break;
					}
				}
			}

			System.out.println("#" + tc + " " + max);
		}
	}
}
