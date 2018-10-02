package difficulty2;

import java.util.Arrays;
import java.util.Scanner;

public class Millionaire {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int p[] = new int[N];
			int get[] = new int[N];
			int max = 0;
			for (int i = 0; i < p.length; i++) {
				p[i] = sc.nextInt();
				if(p[i]>max) max = p[i];
			}
			for (int i = 0; i < p.length; i++) {
				if(i==0){ 
					get[i]=p[i];
				}
			}
		}
	}
}
