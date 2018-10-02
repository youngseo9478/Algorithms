package difficulty1;

import java.util.Scanner;

public class RoundAvg {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int sum = 0;
			int num[] = new int[10];
			for (int i = 0; i < 10; i++) {
				num[i] = sc.nextInt();
			}
			for (int i = 0; i < num.length; i++) {
				sum += num[i];
			}
			System.out.println("#"+tc+" "+Math.round(sum/10.0));  ////##############  10으로 나누면 자동으로 정수가 되버림!!! 10.0으로 나눠야함!!
		}
	}
}
