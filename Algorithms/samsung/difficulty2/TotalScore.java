package difficulty2;

import java.util.Arrays;
import java.util.Scanner;
//���ھ ����� �� �ۼ�Ʈ�̱� ������ ���������� ǥ���ϸ� ���� ���� �����ϰ� ��
//������ ���� ������ ���� ������ ���� �� �̾��� ������ �� double������ ���ִ� ���� �����̾���
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
