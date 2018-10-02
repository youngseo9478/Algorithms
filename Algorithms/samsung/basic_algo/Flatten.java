package basic_algo;

import java.util.Arrays;
import java.util.Scanner;

public class Flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int cnt = sc.nextInt();
			int num = cnt;
			int dump[] = new int[100];
			for (int i = 0; i < dump.length; i++) {
				dump[i] = sc.nextInt();
			}
			//크기순으로 정렬
			Arrays.sort(dump);
			for (int i = 0; i < num; i++) {
				if(dump[99]-dump[0]<=1){
					break;
				}
				//덤프 1번하고
				dump[99]= dump[99]-1;
				dump[0] = dump[0]+1;
				Arrays.sort(dump);
			}
			System.out.println("#"+tc+" "+(dump[99]-dump[0]));
		}
		sc.close();
	}
}
