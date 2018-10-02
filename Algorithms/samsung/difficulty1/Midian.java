package difficulty1;

import java.util.Arrays;
import java.util.Scanner;

public class Midian {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num[] = new int[N];
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
		}
		
		Arrays.sort(num);
		int midian = N/2;
		System.out.println(num[midian]);
	}
}
