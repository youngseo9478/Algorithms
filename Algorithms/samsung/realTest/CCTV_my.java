package realTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CCTV_my {

	static int n, m, ans = Integer.MAX_VALUE;
	static int[][] map;
	static ArrayList<Node> list = new ArrayList<Node>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int v = sc.nextInt();
				map[i][j] = v;
				if (v >= 1 && v <= 5) {
					list.add(new Node(i, j, v));
				}
			}
		}
		search(0, map);
		System.out.println(ans);
		
		sc.close();
	}

	public static void search(int cctvIdx, int[][] prev) {
		int[][] visited = new int[n][m];
		if (cctvIdx == list.size()) {
			int temp = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (prev[i][j] == 0) {
						temp++;
					}
				}
			}
			ans = temp < ans ? temp : ans;
		} else {
			Node node = list.get(cctvIdx);
			int idx = node.idx;
			int x = node.x;
			int y = node.y;

			switch (idx) {
			case 1: // 단방향
				for (int k = 0; k < 4; k++) {
					for (int i = 0; i < n; i++) {
						// visited[i] = prev[i];
						visited[i] = Arrays.copyOf(prev[i], m);
					}
					detect(visited, y, x, k);
					search(cctvIdx + 1, visited);
				}
				break;
			case 2: // 양방향
				for (int k = 0; k < 2; k++) {
					for (int i = 0; i < n; i++) {
						visited[i] = Arrays.copyOf(prev[i], m);
					}
					detect(visited, y, x, k);
					detect(visited, y, x, k + 2);
					search(cctvIdx + 1, visited);
				}
				break;
			case 3: // 직각방향
				for (int k = 0; k < 4; k++) {
					for (int i = 0; i < n; i++) {
						visited[i] = Arrays.copyOf(prev[i], m);
					}
					detect(visited, y, x, k);
					detect(visited, y, x, (k + 1) % 4);
					search(cctvIdx + 1, visited);
				}
				break;
			case 4: // 세방향
				for (int k = 0; k < 4; k++) {
					for (int i = 0; i < n; i++) {
						visited[i] = Arrays.copyOf(prev[i], m);
					}
					detect(visited, y, x, k);
					detect(visited, y, x, (k + 1) % 4);
					detect(visited, y, x, (k + 2) % 4);
					search(cctvIdx+1, visited);
				}
				break;
			case 5: // 전방향
				for (int i = 0; i < n; i++) {
					visited[i] = Arrays.copyOf(prev[i], m);
				}
				detect(visited, y, x, 0);
				detect(visited, y, x, 1);
				detect(visited, y, x, 2);
				detect(visited, y, x, 3);
				search(cctvIdx+1, visited);
				break;
			}
		}
	}

	public static void detect(int[][] visited, int y, int x, int direction) {

		switch (direction) {
		case 0: // 좌
			for (int i = x; i >= 0; i--) {
				if (map[y][i] == 6) { // 원본 데이터!!
					break;
				}
				visited[y][i] = 7; // 카피본의 값을 변경해준다.
			}
			break;
		case 1: // 상
			for (int i = y; i >= 0; i--) {
				if (map[i][x] == 6) {
					break;
				}
				visited[i][x] = 7;
			}
			break;
		case 2: // 우
			for (int i = x; i < m; i++) {
				if (map[y][i] == 6) {
					break;
				}
				visited[y][i] = 7;
			}
			break;
		case 3: // 하
			for (int i = y; i < n; i++) {
				if (map[i][x] == 6) {
					break;
				}
				visited[i][x] = 7;
			}
			break;
		}

	}

}

class Node {
	int x;
	int y;
	int idx;

	public Node(int y, int x, int idx) {
		this.x = x;
		this.y = y;
		this.idx = idx;
	}
}
