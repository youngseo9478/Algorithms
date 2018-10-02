package difficulty1;

import java.util.Scanner;

public class Square {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int s = 1;
		for (int i = 0; i <= num; i++) {
			System.out.print(s+" ");
			s *=2;
		}
		sc.close();
	}
}
