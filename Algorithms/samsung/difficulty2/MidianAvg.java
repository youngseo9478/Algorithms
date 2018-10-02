package difficulty2;

import java.util.Scanner;

public class MidianAvg {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int num[] = new int[10];
			
			for (int i = 0; i < num.length; i++) {
				num[i] = sc.nextInt();
			}
			
			int max = 0;
			int min = 0;
			int sum = 0;
			for (int i = 0; i < 10; i++) {
					max = num[max]<num[i]?i:max;
					min = num[min]>num[i]?i:min;
			}
			for (int i = 0; i < 10; i++) {
				if(i!=max&&i!=min){
					sum+=num[i];
				}
			}
			int avg = (int)Math.round(sum/8.0);
			System.out.println("#"+tc+" "+avg);
		}
		sc.close();
	}
}
