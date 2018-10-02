package realTest;

import java.util.Scanner;

public class Honey {

	static int MAXN = 10;
	static int MAXM = 5;
	static int honey[][] = new int[MAXN][MAXN];
	static int profit[][] = new int[MAXN][MAXN];
	static int N, M, C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					honey[i][j] = sc.nextInt();
					profit[i][j] = 0;
				}
			}
			System.out.println("#" + tc + " "+solve());
		}
	} // end of main

	static int solve() {
		int sum = 0;
		int maxProfit = 0;
		int y, x; // 세로 ,가로

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				profit[i][j] = getPSum(0, i, j, 0, 0);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) {
				sum = profit[i][j] + getPair(i,j);
				if(maxProfit<sum) maxProfit = sum;
			}
		}

		return maxProfit;
	} // end of solve

	static int getPSum(int m, int y, int x, int sum, int psum) {

		if (m >= M)
			return psum;

		int nextSum = 0;
		int max = 0;
		for (int i = m; i < M; i++) {
			if (sum + honey[y][x + i] <= C) {
				nextSum = getPSum(i + 1, y, x, sum + honey[y][x + i], psum + honey[y][x + i] * honey[y][x + i]);
				if (max < nextSum)
					max = nextSum;
			}
			nextSum = getPSum(i + 1, y, x, sum, psum); // 온전히 한통만 채취했을때 더 클 경우를
														// 확인하는 것!
			if (max < nextSum)
				max = nextSum;
		}
		return max;
	} //end of getPSum
	
	static int getPair(int y, int x){
		int maxProfit = 0;
		
		//같은행에서도 안겹치고 할 수 있으면 찾아보기
		for (int i = x+M; i <= N-M; i++) { //예를 들어 벌통이 4개인데 앞에서 0,1 선택하고 왔으면 x=1이자나 근데 여기다가 M=2라고 할때 더해보면 3이지? 3은 N-M=2보다 커서 루프 수행X 
			if(maxProfit<profit[y][i]) maxProfit = profit[y][i];
		}
		
		//다른행
		for (int i = y+1; i < N; i++) {
			for (int j = 0; j <= N-M; j++) {
				if(maxProfit<profit[i][j]) maxProfit = profit[i][j];
			}
		}
		
		return maxProfit;
	}//end of getPair
}
