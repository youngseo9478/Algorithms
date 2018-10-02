package difficulty1;

import java.util.Scanner;

public class SumEachNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		int sum = 0;
		String num2[] = num.split("");
		for (int i = 0; i < num2.length; i++) {
			sum+=Integer.parseInt(num2[i]);
		}
		sc.close();
		System.out.println(sum);
	}
}
