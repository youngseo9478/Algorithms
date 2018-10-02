package realTest;

import java.util.Scanner;

public class Swimming {
	static int costtable[] = new int[4];
	static int plan[] = new int[13];  //그냥 의미없이 어레이초과해서 에러안나게 하려고 넉넉하게 주는 듯
	static int MIN = 1 << 30;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			MIN = 1 << 30;
			for (int i = 0; i < 4; i++) {
				costtable[i] = sc.nextInt();
			}
			for (int i = 1; i <= 12; i++) {  //0부터 해도 되지만 달을 명확하게 알기 위해서 ...나는 1부터 초기화해줬다!
				plan[i] = sc.nextInt();
			}
			search(1, 0);
			System.out.println("#" + tc + " " + MIN);
		}
	} // end of main

	static void search(int month, int cost) {
		if (month >= 13) {
			MIN = cost < MIN ? cost : MIN;
			return;
		}
		search(month+1, cost+costtable[0]*plan[month]);
		search(month+1, cost+costtable[1]);
		search(month+3, cost+costtable[2]);
		search(month+12, cost+costtable[3]);
	}
}
