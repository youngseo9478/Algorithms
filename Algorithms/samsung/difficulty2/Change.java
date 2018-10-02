package difficulty2;

import java.util.Scanner;

public class Change {
	static int[] won = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int change[] = new int[8];
			for (int i = 0; i < won.length; i++) {
				if (N / won[i] != 0) {
					change[i] = N / won[i];
					N = N % won[i];
				}
			}

			System.out.println("#" + tc);
			for (int i = 0; i < change.length; i++) {
				if (i == 7) {
					System.out.println(change[i]);
				} else {
					System.out.print(change[i] + " ");
				}
			}
		}
	}
}
