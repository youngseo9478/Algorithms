package basic_algo;

import java.util.Scanner;

public class View {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int view = 0;
			int left = 0;
			int right = 0;
			int length = sc.nextInt();
			int arr[] = new int[length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}

			for (int i = 2; i < arr.length-2; i++) {
				if (arr[i - 2] < arr[i] && arr[i - 1] < arr[i] && arr[i + 1] < arr[i] && arr[i + 2] < arr[i]) {
					left = arr[i] - max(arr[i-2],arr[i-1]);
					right = arr[i] - max(arr[i+1],arr[i+2]);
					view = view + min(left,right);
				}
			}
			
			System.out.println("#"+tc+" "+view);
		}
		sc.close();
	}
	
	//큰값
	static int max(int a, int b){
		return a>b?a:b;
	}
	
	//작은값
	static int min(int a, int b){
		return a>b?b:a;
	}
}
