package basic_algo;

import java.util.Scanner;

public class Ladder2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int ten = sc.nextInt();
			int arr[][] = new int[100][100];
			int map[] = new int[100];
			int index = 0;

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < map.length; i++) {
				if (arr[0][i] == 1) {
					map[i]++;
					index = i;

					for (int row = 1; row < map.length; row++) {
						map[i]++;
						if (index == 0) {
							for (int col = 1; col < map.length; col++) {
								if (arr[row][col] == 1) {
									map[i]++;
									index = col;
								} else {
									break;
								}
							}
						} else if (index == 99) {
							for (int col = 98; col >= 0; col--) {
								if (arr[row][col] == 1) {
									map[i]++;
									index = col;
								} else {
									break;
								}
							}
						} else {
							if (arr[row][index + 1] == 1) {
								for (int col = index + 1; col < map.length; col++) {
									if (arr[row][col] == 1) {
										map[i]++;
										index = col;
									} else {
										break;
									}
								}
							} else if (arr[row][index - 1] == 1) {
								for (int col = index - 1; col >= 0; col--) { /////처음에 결과 잘못나온 이유가 반복문을 잘못 작성.
																				/////(int col = index - 1; col < map.length(); col++) 이렇게...
									if (arr[row][col] == 1) {
										map[i]++;
										index = col;
									} else {
										break;
									}
								}
							}
						}
					} //사다리
				}
			}
			int min =1000;
			int result = 0;
			for (int j = 0; j < map.length; j++) {
				if(map[j]>0&&map[j]<=min){
					min = map[j];
					result = j;
				}
			}
			System.out.println("#" + tc + " " + result);
		}
		sc.close();
	}
}
