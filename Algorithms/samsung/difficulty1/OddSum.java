package difficulty1;

import java.util.Scanner;

public class OddSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int num[] = new int[10];
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				num[i] = sc.nextInt();
			}
			for (int i = 0; i < num.length; i++) {
				if(num[i]%2!=0){
					sum+=num[i];
				}
			}
			System.out.println("#"+tc+" "+sum);
		}
	}
}
