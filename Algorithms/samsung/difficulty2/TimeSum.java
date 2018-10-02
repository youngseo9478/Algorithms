package difficulty2;

import java.util.Scanner;

public class TimeSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int h1 = sc.nextInt(); //first hours
			int m1 = sc.nextInt(); //first minute
			int h2 = sc.nextInt(); //second hours
			int m2 = sc.nextInt(); //second minute
			
			int H = 0;
			int M = 0;
			if(h1+h2>12){
				H = h1+h2-12;
			}else{
				H = h1+h2;
			}
			if(m1+m2>59){
				M = m1+m2-60;
				H++;
			}else{
				M = m1+m2;
			}
			
			System.out.println("#"+tc+" "+H+" "+M);
		}
	}
}
