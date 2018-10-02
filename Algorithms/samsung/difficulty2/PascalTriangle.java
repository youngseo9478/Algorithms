package difficulty2;

import java.util.Scanner;

public class PascalTriangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int size = sc.nextInt();
			int t[][] = new int[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j <= i; j++) {  //i까지만 도는게 포인트 이때는 j<i이면 첫줄은 아예 값 안넣는 것임
					t[i][j] = 1;
				}
			}
			for (int i = 2; i < size; i++) {
				for (int j = 1; j <= i; j++) { 
					t[i][j] = t[i-1][j-1]+t[i-1][j];
				}
			}
			System.out.println("#"+tc);
			for (int i = 0; i < size; i++) {
				for (int j = 0; j <= i; j++) {  
					System.out.print(t[i][j]+" ");
				}
				System.out.println();
			}
			
		}
	}
}
