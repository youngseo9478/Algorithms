package realTest;

import java.util.Scanner;

class Magnet {
	static final int numOfmagnet = 4;
	static final int numOfteeth = 8;
	static int magnet[][] = new int[5][8];
	static int turnInfo[][] = new int[21][2]; // �ε��� ��ȣ�� 20������ ����ϱ� ���� 21�� �ذ�!
												// �ִ� 20�������� ȸ���� �� ����
	static int magnetScorePointer[] = new int[numOfmagnet + 1]; // �������� ���� �ƴϰ�
																// ��ġ��!!
	static int turningMagnet[] = new int[numOfmagnet + 1];

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T, k, score, pivotMagnetNum, rotationDirection;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			k = sc.nextInt();
			score = 0;

			for (int i = 1; i < numOfmagnet + 1; i++) {
				for (int j = 0; j < numOfteeth; j++) {
					magnet[i][j] = sc.nextInt();
				}
			}

			for (int i = 1; i <= k; i++) {
				turnInfo[i][0] = sc.nextInt();
				turnInfo[i][1] = sc.nextInt();
			}

			////////////////// ���� �Է¹��� �����ʹ� �� �����ߴ�.�ʱ�ȭ�� �ʿ��ϴ�.

			for (int i = 0; i < numOfmagnet + 1; i++) {
				magnetScorePointer[i] = 0; // �׳� magnet[i][0]���� ��� �ʱ�ȭ �ϸ� �ȵǴ�
											// ���ϱ�....�ȵ�!!! �̰� �������� ���� �ƴ϶� ��ġ��
											// ��Ÿ���°ž�! ó���� �� ù��°��!! �ε����δ� 0����!!
			}

			for (int i = 1; i <= k; i++) {
				for (int j = 0; j < numOfmagnet + 1; j++) {
					turningMagnet[j] = 0;
				}
				pivotMagnetNum = turnInfo[i][0]; // ȸ����Ű���� �ڼ�
				rotationDirection = turnInfo[i][1]; // ȸ������

				turningMagnet[pivotMagnetNum] = rotationDirection;

				if (pivotMagnetNum != numOfmagnet) {
					checkSide(pivotMagnetNum, rotationDirection, 1);
				}
				// �Ʒ��� else if�� �ɸ� �ȵ� �׷� �ΰ� �� �ϳ��� ������ �� �ƴϾ� ? ������ �� üũ�ؾߵǴµ�!!
				if (pivotMagnetNum != 1) {
					checkSide(pivotMagnetNum, rotationDirection, -1);
				}

				turnmagnet();
			}

			/////// ��������ϸ� k���� ȸ���� ��� ��ģ ��! �׷� ���� ȭ��ǥ�ڸ��� ���� ���������
			for (int i = 1; i <= numOfmagnet; i++) {
				if (magnet[i][magnetScorePointer[i]] == 1) {
					score += pow(2, i);
				}
			}
			System.out.println("#"+tc+" "+score);

		}
		sc.close();
	} // end of main

	static void checkSide(int pivotMagnetNum, int rotationDirection, int side) {

		int pivotMagnetPole, sideMagnetPole, pivotScorePointer, sideMagnetPointer, sideMagnetNum;

		sideMagnetPole = 0;
		pivotMagnetPole = 0;
		while (true) {

			// main���� �� ���ڼ��̳� ù �ڼ��� �Ÿ��� ������ ���� ���ٺ��� �ش� ��ġ�� ���� �� �� �ƴϰھ� ? �׷��ϱ� ����
			// �������� �׻� ���� ������ �ؾߴ� ���̳� ó���� ���ڼ��̶��� �����ϱ� ������ �� �ƴϾ�
			// �ٵ� ������ �ΰ��� ���� �ɷ����� �׳� ó���̳� ���̶�� �ؼ� ������ �����Ű�°� �ƴ��ڳ�
			// �� �ڼ��� �ڽ��� �������� Ž���� �� �׸��� ù �ڼ��� �ڽ��� ������ Ž���� ���� �����ؾ���!!
			if (side == 1 && pivotMagnetNum == numOfmagnet) {
				break;
			} else if (side == -1 && pivotMagnetNum == 1) {
				break;
			}

			sideMagnetNum = pivotMagnetNum + side;
			pivotScorePointer = magnetScorePointer[pivotMagnetNum];
			sideMagnetPointer = magnetScorePointer[sideMagnetNum];

			if (side == -1) {
				pivotMagnetPole = pivotScorePointer < 2 ? magnet[pivotMagnetNum][pivotScorePointer + numOfteeth - 2]
						: magnet[pivotMagnetNum][pivotScorePointer - 2];
				sideMagnetPole = sideMagnetPointer >= numOfteeth - 2
						? magnet[sideMagnetNum][sideMagnetPointer - numOfteeth + 2]
						: magnet[sideMagnetNum][sideMagnetPointer + 2];

			} else if (side == 1) {
				pivotMagnetPole = pivotScorePointer >= numOfteeth - 2
						? magnet[pivotMagnetNum][pivotScorePointer - numOfteeth + 2]
						: magnet[pivotMagnetNum][pivotScorePointer + 2];
				sideMagnetPole = sideMagnetPointer < 2 ? magnet[sideMagnetNum][sideMagnetPointer + numOfteeth - 2]
						: magnet[sideMagnetNum][sideMagnetPointer - 2];
			}

			if (pivotMagnetPole != sideMagnetPole) {
				// pivot�� �ð����, side�� �ݽð���������� ȸ�� ���Ѿ� ��
				turningMagnet[sideMagnetNum] = -rotationDirection;
				rotationDirection = -rotationDirection;
			} else {
				break;
			}
			pivotMagnetNum += side; // 1�̷������� �ȵ� �������� �̵��ϴ°��� ���������� �̵��ϴ� ���� �˼� ����
									// ����~~
		}
	}// end of checkSide

	static void turnmagnet() {
		for (int magnet = 1; magnet <= numOfmagnet; magnet++) {
			int turningDirection = turningMagnet[magnet];
			if (turningDirection == 1) {
				// �ε����� 0~7�̴ϱ� 8������� �ε����� 7
				magnetScorePointer[magnet] = magnetScorePointer[magnet] == 0 ? numOfteeth - 1
						: magnetScorePointer[magnet] - 1;
			} else if (turningDirection == -1) {
				magnetScorePointer[magnet] = magnetScorePointer[magnet] == numOfteeth - 1 ? 0
						: magnetScorePointer[magnet] + 1;
			}
		}

	}// end of turnmagnet

	static int pow(int x, int n) {
		int result = 1;
		for (int i = 1; i < n; i++) { //1�� �ڼ��� ������ �� for�� ���� ���ϴ� ��
			result *=x; 
		}
		return result;
	}

}