package difficulty2;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next().trim();
			String[] str2 = str.split("");
			String[] reverse = new String[str2.length];
			for (int i = 0; i < str2.length; i++) {
				reverse[i] = str2[str2.length - i - 1];
			}
			String result = "";
			for (int i = 0; i < reverse.length; i++) {
				result += reverse[i];
			}
			if (result.equals(str)) {
				System.out.println("#"+tc+" "+1);
			} else {
				System.out.println("#"+tc+" "+0);
			}
		}
		sc.close();
	}
}
