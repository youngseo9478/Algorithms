package difficulty1;

import java.util.Scanner;

public class Password {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int k = sc.nextInt();
		int cnt = 0;
		cnt = p-k+1;
		System.out.println(cnt);
	}
}
