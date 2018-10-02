package basic_algo;

import java.util.Scanner;

public class String_Palindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int len = sc.nextInt();
			sc.nextLine(); // 개행문자 남아있는거 처리
			char arr[][] = new char[8][8];
			int cnt = 0;
			
			for (int i = 0; i < arr.length; i++) {
					arr[i] = sc.nextLine().toCharArray();
			}
			
			if (len == 1) {
				cnt = 64;
			} else {
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr.length-len+1; j++) {
						boolean chk1 = true;
						boolean chk2 = true; //false가 아닌 true로 해야함
						
						for (int k = 0; k < len/2; k++) { ///3중 포문을 쓰면 안된다는 생각에 계속 해맸음. 
							if(arr[i][j+k]!=arr[i][j+len-k-1]){ 
								//여기서 !=가 아니라 ==로 하고 아래서 true를 넣어주는 식으로 하면 
								//예를 들어 제한 길이가 5일 때 1,5은 맞고 2,4는 달랐을 때 false로 다시 돌려줄 구간이 필요함.
								//그게 없다면 cnt가 정답보다 훨씬 커짐.
								chk1 = false;
							}
							if(arr[j+k][i]!=arr[j+len-k-1][i]){
								chk2 = false;
							}
						}
						if(chk1) cnt++;
						if(chk2) cnt++;
					}
				}
			}
			
			System.out.println("#"+tc+" "+cnt);

		}
		sc.close();
	}
}
