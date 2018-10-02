package difficulty1;

import java.util.Scanner;

public class Alphabet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().trim();
		char a[] = str.toCharArray();
		for (int i = 0; i < a.length; i++) {
			if(65<=a[i]&&a[i]<=90){
				System.out.print(a[i]-64+" ");
			}else if(97<=a[i]&&a[i]<=122){
				System.out.print(a[i]-96+" ");
			}
		}
	}
}
