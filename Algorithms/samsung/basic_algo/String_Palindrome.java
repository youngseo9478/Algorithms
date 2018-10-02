package basic_algo;

import java.util.Scanner;

public class String_Palindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int len = sc.nextInt();
			sc.nextLine(); // ���๮�� �����ִ°� ó��
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
						boolean chk2 = true; //false�� �ƴ� true�� �ؾ���
						
						for (int k = 0; k < len/2; k++) { ///3�� ������ ���� �ȵȴٴ� ������ ��� �ظ���. 
							if(arr[i][j+k]!=arr[i][j+len-k-1]){ 
								//���⼭ !=�� �ƴ϶� ==�� �ϰ� �Ʒ��� true�� �־��ִ� ������ �ϸ� 
								//���� ��� ���� ���̰� 5�� �� 1,5�� �°� 2,4�� �޶��� �� false�� �ٽ� ������ ������ �ʿ���.
								//�װ� ���ٸ� cnt�� ���亸�� �ξ� Ŀ��.
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
