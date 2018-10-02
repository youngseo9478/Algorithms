package basic_algo;

import java.util.Scanner;

public class Ladder1_1210 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int ten = sc.nextInt();
			int arr[][] = new int[100][100];
			int end = 0;
			int start = 0;
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// end점 찾기
			for (int j = 0; j < arr.length; j++) {
				if (arr[99][j] == 2) {
					end = j;
					start = end;
					break;
				}
			}

			// 아래에서부터 거슬러 올라가며 사다리 타기
			for (int i = 98; i >= 0; i--) {
				//가장 왼쪽
				if(start==0){
					for (int j = 1; j < arr.length; j++) {
						if(arr[i][j]==1){
							start = j;
						}else{
							break;
						}
					}
				}else if(start==99){
					for (int j = 99; j >=0; j--) {
						if(arr[i][j]==1){
							start = j;
						}else{
							break;
						}
					}
				}else{
					if(arr[i][start+1]==1){
						for (int j = start+1; j < arr.length; j++) {
							if(arr[i][j]==1){
								start = j;
							}else{
								break;
							}
						}
					}else if(arr[i][start-1]==1){
						for (int j = start-1; j >= 0; j--) {
							if(arr[i][j]==1){
								start = j;
							}else{
								break;
							}
						}
					}
				}
			}
			System.out.println("#" + tc + " " + start);
		}
		sc.close();
	}
}
