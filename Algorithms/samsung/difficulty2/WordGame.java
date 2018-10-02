package difficulty2;

import java.util.Scanner;

public class WordGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int arr[][] = new int[N][N];
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// row
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					if(arr[i][j]==1&&j!=N-1){
						cnt++;
					}else if(arr[i][j]==1&&j==N-1){
						cnt++;
						if(cnt==K){
							result++;
						}
					}else if(arr[i][j]==0){
						if(cnt==K){
							result++;
						}
						cnt = 0;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					if(arr[j][i]==1&&j!=N-1){
						cnt++;
					}else if(arr[j][i]==1&&j==N-1){
						cnt++;
						if(cnt==K){
							result++;
						}
					}else if(arr[j][i]==0){
						if(cnt==K){
							result++;
						}
						cnt = 0;  //���⼭ �� �� 0���� �ʱ�ȭ �ϳĸ�, �� �࿡�� �ϳ� ã�Ҵٰ� �� �ƴ��ڳ�    011011 �̸� �ΰ������ϴϱ� ~ 
					}
				}
			}
			
			System.out.println("#"+tc+" "+result);
			

		}
	}
}
