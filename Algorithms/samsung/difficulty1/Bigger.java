package difficulty1;

import java.util.Scanner;

public class Bigger {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a>b){
				System.out.println("#"+tc+" "+">");
			}else if(a<b){
				System.out.println("#"+tc+" "+"<");
			}else if(a==b){
				System.out.println("#"+tc+" "+"=");
			}
		}
	}
}
