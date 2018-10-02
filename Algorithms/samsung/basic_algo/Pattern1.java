package basic_algo;

import java.util.Scanner;

public class Pattern1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <=10; tc++) {
			int test = sc.nextInt(); ///이거를 for문 밖에 둬서 계속 잘못된 값이 나왔었음....젠장....
			sc.nextLine();
			String p = sc.nextLine();
			String t = sc.nextLine();
			int cnt = 0;
			
			for (int i = 0; i < t.length(); i++) {
				if(p.charAt(0)==t.charAt(i)){
					if(i+p.length()>=t.length()+1) break;
					if(t.substring(i, i+p.length()).equals(p)){
						cnt++;
					}
				}
			}
			
			System.out.println("#"+tc+" "+cnt);
		}
		sc.close();
	}
}
