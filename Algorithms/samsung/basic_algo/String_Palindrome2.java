package basic_algo;

import java.util.Scanner;

public class String_Palindrome2 {
	public static int palindrome(int len, char[][] arr){
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - len + 1; j++) {
				boolean chk1 = true;
				boolean chk2 = true;

				for (int k = 0; k < len / 2; k++) {
					if (arr[i][j + k] != arr[i][j + len - k - 1]) {
						chk1 = false;
					}
					if (arr[j + k][i] != arr[j + len - k - 1][i]) {
						chk2 = false;
					}
				}
				if (chk1){
					cnt++;
				}
				if(chk2){
					cnt++;
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			String num = sc.nextLine();
			char arr[][] = new char[100][100];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextLine().toCharArray();
			}
			for (int i = 100; i >= 0; i--) {
				int len = palindrome(i,arr);
				if(len>=1){
					System.out.println("#" + tc + " " + i);
					break;
				}
			}
		}
		sc.close();
	}
}
