package difficulty2;

import java.util.Arrays;
import java.util.Scanner;

public class NumSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int num[] = new int[N];
			for (int i = 0; i < num.length; i++) {
				num[i] = sc.nextInt();
			}
			Arrays.sort(num);
			System.out.print("#"+tc);
			for (int i = 0; i < num.length; i++) {
				System.out.print(" "+num[i]);
			}
			System.out.println();
		}
		sc.close();
	}
}
