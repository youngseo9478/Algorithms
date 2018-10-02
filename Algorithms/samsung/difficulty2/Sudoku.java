package difficulty2;

import java.util.Scanner;
//��, ��, ����ť�� ������ ���������� �˻��� �ϴµ� ������ �ϳ��� false�� ������ ���� �ݺ����� ������ �ʿ䵵 ����.
//������ ���� ť�긦 �˻��� �� 3���� ������Ű���� index ������ �̿��ϴ� ���� ����.
//�Ź� sum�� ��,��,����ť�� �Ѽ�Ʈ ������ 0���� �ʱ�ȭ ���������
public class Sudoku {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int[][] sudoku = new int[9][9];
			for (int i = 0; i < sudoku.length; i++) {
				for (int j = 0; j < sudoku.length; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}

			boolean flag = false;
			// row�˻�
			for (int i = 0; i < sudoku.length; i++) {
				int sum = 0;
				for (int j = 0; j < sudoku.length; j++) {
					sum += sudoku[i][j];
				}
				if (sum != 45) {
					flag = false;
					break;
				} else {
					flag = true;
					sum = 0;
				}
			}
			if (flag) {
				// col�˻�
				for (int i = 0; i < sudoku.length; i++) {
					int sum = 0;
					for (int j = 0; j < sudoku.length; j++) {
						sum += sudoku[j][i];
					}
					if (sum != 45) {
						flag = false;
						break;
					} else {
						flag = true;
						sum = 0;
					}
				}
			}
			if (flag) {
				int index = 0;
				int sum = 0;
				while (true) {
					for (int i = index; i < 3 + index; i++) {
						for (int j = index; j < 3 + index; j++) {
							sum += sudoku[i][j];
						}
					}
					if (sum != 45) {
						flag = false;
						break;
					} else {
						flag = true;
						index += 3;
						sum = 0;
					}
					if (index == 9) {
						break;
					}
				}
			}
			if (flag)
				System.out.println("#" + tc + " " + 1);
			else
				System.out.println("#" + tc + " " + 0);

		}
	}
}
