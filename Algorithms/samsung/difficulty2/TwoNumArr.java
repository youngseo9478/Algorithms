package difficulty2;

import java.util.Scanner;


//N과 M의 크기비교를  통해 다른 포문을 돌려줘야하는 것이 관건이었음
//항상 N이 더 작은수라는 보장이 없기 때문임
public class TwoNumArr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int nArr[] = new int[n];
			int mArr[] = new int[m];
			for (int i = 0; i < n; i++) {
				nArr[i] = sc.nextInt();
			}
			for (int i = 0; i < m; i++) {
				mArr[i] = sc.nextInt();
			}
			int sum = 0;
			int result = 0;
			if (n > m) {
				for (int i = 0; i <= n - m; i++) {
					for (int j = 0; j < m; j++) {
						sum += (mArr[j] * nArr[j + i]);
					}
					result = result < sum ? sum : result;
					sum = 0;
				}
			}else{
				for (int i = 0; i <= m-n; i++) {
					for (int j = 0; j < n; j++) {
						sum += (nArr[j] * mArr[j + i]);
					}
					result = result < sum ? sum : result;
					sum = 0;
				}
			}

			System.out.println("#" + tc + " " + result);
		}
		sc.close();
	}
}
