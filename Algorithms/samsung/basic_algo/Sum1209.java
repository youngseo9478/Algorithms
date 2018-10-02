package basic_algo;

import java.util.Scanner;

public class Sum1209 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int test = sc.nextInt();
			int arr[][] = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int max = 0;
			int sum1 = 0; // 행우선
			int sum2 = 0; // 열우선
			int sum3 = 0; // 대각선1
			int sum4 = 0; // 대각선2
			int cnt = 0;
			int c = 0;

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (i == j) {
						sum3 = sum3 + arr[i][j];
						c++;
					}
					if (j == (100 - i - 1)) {     ///// else if문으로 만들면 안됌!!!
						sum4 = sum4 + arr[i][j];
						cnt++;
					}
					///// else 로 만들면 안됌~!!!!! 중복인 부분도 있는데 그 연산을 빼먹게 된다!!
					sum1 = sum1 + arr[i][j];
					sum2 = sum2 + arr[j][i];
				}
				max = sum1 > max ? sum1 : max;
				max = sum2 > max ? sum2 : max;
				sum1 = 0;
				sum2 = 0;
			}
			max = sum3 > max ? sum3 : max;
			max = sum4 > max ? sum4 : max;
			System.out.println("#" + tc + " " + max);
		}
		sc.close();
	}
}
