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
						cnt = 0;  //여기서 왜 또 0으로 초기화 하냐면, 한 행에서 하나 찾았다고 끝 아니자나    011011 이면 두개여야하니까 ~ 
					}
				}
			}
			
			System.out.println("#"+tc+" "+result);
			

		}
	}
}
