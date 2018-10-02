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
		int y, x; // ���� ,����

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
			nextSum = getPSum(i + 1, y, x, sum, psum); // ������ ���븸 ä�������� �� Ŭ ��츦
														// Ȯ���ϴ� ��!
			if (max < nextSum)
				max = nextSum;
		}
		return max;
	} //end of getPSum
	
	static int getPair(int y, int x){
		int maxProfit = 0;
		
		//�����࿡���� �Ȱ�ġ�� �� �� ������ ã�ƺ���
		for (int i = x+M; i <= N-M; i++) { //���� ��� ������ 4���ε� �տ��� 0,1 �����ϰ� ������ x=1���ڳ� �ٵ� ����ٰ� M=2��� �Ҷ� ���غ��� 3����? 3�� N-M=2���� Ŀ�� ���� ����X 
			if(maxProfit<profit[y][i]) maxProfit = profit[y][i];
		}
		
		//�ٸ���
		for (int i = y+1; i < N; i++) {
			for (int j = 0; j <= N-M; j++) {
				if(maxProfit<profit[i][j]) maxProfit = profit[i][j];
			}
		}
		
		return maxProfit;
	}//end of getPair
}
