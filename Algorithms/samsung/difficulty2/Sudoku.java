package difficulty2;

import java.util.Scanner;
//행, 열, 작은큐브 순으로 순차적으로 검색을 하는데 위에서 하나라도 false가 있으면 다음 반복문은 수행할 필요도 없음.
//마지막 작은 큐브를 검사할 때 3개씩 증가시키려고 index 변수를 이용하는 것이 관건.
//매번 sum은 행,열,작은큐브 한세트 돌고나면 0으로 초기화 시켜줘야함
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
			// row검사
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
				// col검사
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
