package difficulty1;

import java.util.Scanner;

public class Substraction {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = num; i >=0; i--) {
			System.out.print(i+" ");
		}
		sc.close();
	}
}
