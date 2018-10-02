package difficulty1;

import java.util.Scanner;

public class Max {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int num[] = new int[10];
			for (int i = 0; i < num.length; i++) {
				num[i] = sc.nextInt();
			}
			int max = -1000000;
			for (int i = 0; i < num.length; i++) {
				if(num[i]>max){
					max = num[i];
				}
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}
