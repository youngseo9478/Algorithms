package difficulty2;

import java.util.Arrays;
import java.util.Scanner;
//스코어를 계산할 때 퍼센트이기 때문에 정수형으로 표기하면 같은 값이 존재하게 됨
//문제의 제약 조간은 같은 총점이 없는 것 이었기 때문에 꼭 double형으로 해주는 것이 관건이었음
public class TotalScore {
	static String total[] = {"D0","C-","C0","C+","B-","B0","B+","A-","A0","A+"};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int s[][] = new int[N][3];
			int section = N/10;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 3; j++) {
					s[i][j] = sc.nextInt();
				}
			}
			double score[] = new double[N];
			for (int i = 0; i < s.length; i++) {
				  score[i]= s[i][0] * 0.35 + s[i][1] * 0.45 + s[i][2] * 0.20;
			}
			double one = score[K-1];
			int index = 0;
			Arrays.sort(score);
			
			for (int i = 0; i < N; i++) {
				if(score[i]==one){
					index = i/section;
					break;
				}
			}
			
			System.out.println("#"+tc+" "+total[index]);
			
		}
		sc.close();
	}
}
