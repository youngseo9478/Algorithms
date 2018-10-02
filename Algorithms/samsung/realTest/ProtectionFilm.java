package realTest;

import java.util.Scanner;

public class ProtectionFilm {
	static int D,W,K;
	static final int DSIZE = 13;
	static final int WSIZE = 20;
	static int minChemicalCnt;
	static int [] chemical = new int[DSIZE];
	static int film[][] = new int[DSIZE][WSIZE];
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for (int tc = 1; tc <= T; tc++) {
		D = sc.nextInt();
		W = sc.nextInt();
		K = sc.nextInt();
		
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < W; j++) {
				film[i][j]=sc.nextInt();
			}
		}
		minChemicalCnt = K;
		
		int continuum[] = new int[WSIZE];
		int maxContinuum[] = new int[WSIZE];
		
		
	}
	} //end of main
	
}
