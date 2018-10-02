package difficulty2;

import java.util.Scanner;

public class RotationArr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int arr[][] = new int[N][N];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			//초기화 끝
			int arr90[][] = new int[N][N];
			int arr180[][] = new int[N][N];
			int arr270[][] = new int[N][N];
			
			//90 
			for (int i = 0; i < arr.length; i++) {
				for (int j = N-1; j >=0 ; j--) {
					arr90[i][N-j-1] = arr[j][i]; //인덱스 주의하기 !! [i][j]한다고 0,0부터 시작하는거 아님!! 잘 계산해서 넣어야함
				}
			}
			
			//180
			for (int i = N-1; i >=0; i--) {
				for (int j = N-1; j >=0; j--) {
					arr180[N-i-1][N-j-1] = arr[i][j];
				}
			}
			
			//270
			for (int i = N-1; i >=0; i--) {
				for (int j = 0; j < arr.length; j++) {
					arr270[N-i-1][j] = arr[j][i];
				}
			}
			
			System.out.println("#"+tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr90[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(arr180[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(arr270[i][j]);
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
