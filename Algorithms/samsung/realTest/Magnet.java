package realTest;

import java.util.Scanner;

class Magnet {
	static final int numOfmagnet = 4;
	static final int numOfteeth = 8;
	static int magnet[][] = new int[5][8];
	static int turnInfo[][] = new int[21][2]; // 인덱스 번호를 20번까지 사용하기 위해 21로 준것!
												// 최대 20번까지만 회전할 수 있음
	static int magnetScorePointer[] = new int[numOfmagnet + 1]; // 포인터의 값이 아니고
																// 위치임!!
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

			////////////////// 이제 입력받은 데이터는 다 저장했다.초기화가 필요하다.

			for (int i = 0; i < numOfmagnet + 1; i++) {
				magnetScorePointer[i] = 0; // 그냥 magnet[i][0]으로 모두 초기화 하면 안되는
											// 것일까....안돼!!! 이건 포인터의 값이 아니라 위치를
											// 나타내는거야! 처음엔 다 첫번째지!! 인덱스로는 0번쨰!!
			}

			for (int i = 1; i <= k; i++) {
				for (int j = 0; j < numOfmagnet + 1; j++) {
					turningMagnet[j] = 0;
				}
				pivotMagnetNum = turnInfo[i][0]; // 회전시키려는 자석
				rotationDirection = turnInfo[i][1]; // 회전방향

				turningMagnet[pivotMagnetNum] = rotationDirection;

				if (pivotMagnetNum != numOfmagnet) {
					checkSide(pivotMagnetNum, rotationDirection, 1);
				}
				// 아래걸 else if로 걸면 안되 그럼 두개 중 하나만 수행할 거 아니야 ? 양쪽을 다 체크해야되는데!!
				if (pivotMagnetNum != 1) {
					checkSide(pivotMagnetNum, rotationDirection, -1);
				}

				turnmagnet();
			}

			/////// 여기까지하면 k번의 회전을 모두 마친 거! 그럼 이제 화살표자리의 값을 더해줘야함
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

			// main에서 젤 끝자석이나 첫 자석은 거르고 오지만 루프 돌다보면 해당 위치에 오게 될 거 아니겠어 ? 그러니까 루프
			// 시작전에 항상 먼저 점검을 해야대 끝이나 처음은 옆자석이란게 없으니까 에러날 거 아니야
			// 근데 조건이 두개가 같이 걸려야지 그냥 처음이나 끝이라고 해서 루프를 종료시키는게 아니자나
			// 끝 자석이 자신의 오른쪽을 탐색할 때 그리고 첫 자석이 자신의 왼쪽을 탐색할 때만 종료해야지!!
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
				// pivot은 시계방향, side는 반시계방향으ㅏ로 회전 시켜야 함
				turningMagnet[sideMagnetNum] = -rotationDirection;
				rotationDirection = -rotationDirection;
			} else {
				break;
			}
			pivotMagnetNum += side; // 1이래버리면 안됨 왼쪽으로 이동하는건지 오른쪽으로 이동하는 건지 알수 없기
									// 때문~~
		}
	}// end of checkSide

	static void turnmagnet() {
		for (int magnet = 1; magnet <= numOfmagnet; magnet++) {
			int turningDirection = turningMagnet[magnet];
			if (turningDirection == 1) {
				// 인덱스가 0~7이니까 8번톱니의 인덱스는 7
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
		for (int i = 1; i < n; i++) { //1번 자석이 들어왔을 땐 for문 수행 안하는 것
			result *=x; 
		}
		return result;
	}

}