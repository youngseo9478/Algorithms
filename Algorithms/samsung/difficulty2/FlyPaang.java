package difficulty2;

import java.util.Scanner;

public class FlyPaang {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int arr[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int col = 0;
			int row = 0;
			int max = 0; //�긦 while �ȿ� �־������ ��� ��� sum�� max���� ũ�ٰ� ���Ǽ� �׳� ������ ���� max�� ���� ��
			while (true) {
				int sum = 0; //sum �ʱ�ȭ ��ġ�� �߿���
				for (int i = row; i < row + M; i++) {
					for (int j = col; j < col + M; j++) {
						sum += arr[i][j];
					}
				}
				max = max < sum ? sum : max;
				col++;
				if (col + M > N) { // col+m>=N�� �ƴ� ������ �ٷ� ������ col++�� �߱� ����
					col = 0;
					row++;
					if (row + M > N) { //���� ��������
						break;
					}
				}
			}

			System.out.println("#" + tc + " " + max);
		}
	}
}
