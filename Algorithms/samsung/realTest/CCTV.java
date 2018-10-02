package realTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CCTV {
	  // http://mygumi.tistory.com/313
	  // https://github.com/hotehrud/acmicpc

	  static int n, m, ans = Integer.MAX_VALUE;
	  static int[][] map; //�繫�� ����
	  static ArrayList<Node> list = new ArrayList<Node>(); //CCTV ����Ʈ

	  private void solve() {
	    n = sc.nextInt();
	    m = sc.nextInt();
	    map = new int[n][m]; //�Է¹��� ũ���� �繫�� ����

	    for (int i = 0; i < n; i++) {
	      for (int j = 0; j < m; j++) {
	        int v = sc.nextInt();
	        map[i][j] = v; //0~6�� �Է¹���, 0:�����, 6:��, 1~5:CCTV
	        if (1 <= v && v <= 5) {// CCTV�� ��츸 ��尴ü ������ �� ����Ʈ�� �߰�
	          list.add(new Node(i, j, v)); //���: �繫�� ���� �� ��ǥ�� CCTV��ȣ�� ����
	        }
	      }
	    }
	    search(0, map); //��������� ȣ���� ����, ù��° CCTV���� �˻����
	    System.out.println(ans);
	  }

	  /**
	   * 
	   * @param cctvIndex cctv����
	   * @param prev
	   */
	  public static void search(int cctvIndex, int[][] prev) {
	    int[][] visited = new int[n][m]; //�繫���� ���� ������ �迭
	    if (cctvIndex == list.size()) {
	      int temp = 0;
	      for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	          if (prev[i][j] == 0) {
	            temp++;
	          }
	        }
	      }
	      if (temp < ans) {
	        ans = temp; //temp�� �� ���� �� ��ü
	      }
	    } else {
	      Node node = list.get(cctvIndex);
	      int idx = node.idx;
	      int x = node.x;
	      int y = node.y;

	      switch (idx) {
	      case 1:
	        for (int k = 0; k < 4; k++) { //����: �� �� �� �� 4��
	          for (int i = 0; i < n; i++) {//n�� ���� ũ��
	            visited[i] = Arrays.copyOf(prev[i], m); //���� ���� ����
	          }
	          detect(visited, y, x, k); //k�� ����! visited�� ���� �ٲ� ���� ->k�� 0~3�� �ݺ��ϴ� �� 4��..
	          search(cctvIndex + 1, visited); //
	        }
	        break;
	      case 2:
	        for (int k = 0; k < 2; k++) {
	          for (int i = 0; i < n; i++) {
	            visited[i] = Arrays.copyOf(prev[i], m);
	          }
	          detect(visited, y, x, k);
	          detect(visited, y, x, k + 2);
	          search(cctvIndex + 1, visited);
	        }
	        break;
	      case 3:
	        for (int k = 0; k < 4; k++) {
	          for (int i = 0; i < n; i++) {
	            visited[i] = Arrays.copyOf(prev[i], m);
	          }
	          detect(visited, y, x, k);
	          detect(visited, y, x, (k + 1) % 4); //�̷� ������...
	          search(cctvIndex + 1, visited);
	        }
	        break;
	      case 4:
	        for (int k = 0; k < 4; k++) {
	          for (int i = 0; i < n; i++) {
	            visited[i] = Arrays.copyOf(prev[i], m);
	          }
	          detect(visited, y, x, k);
	          detect(visited, y, x, (k + 1) % 4);
	          detect(visited, y, x, (k + 2) % 4);
	          search(cctvIndex + 1, visited);
	        }
	        break;
	      case 5:
	        for (int i = 0; i < n; i++) {
	          visited[i] = Arrays.copyOf(prev[i], m);
	        }
	        detect(visited, y, x, 0);
	        detect(visited, y, x, 1);
	        detect(visited, y, x, 2);
	        detect(visited, y, x, 3);
	        search(cctvIndex + 1, visited);
	        break;
	      }
	    }
	  }

	  public static void detect(int[][] visited, int i, int j, int direction) {
	    switch (direction) { //���Ⱚ���� �귣ġ
	    case 0:
	      for (int k = j; k >= 0; k--) { //��
	        if (map[i][k] == 6) { //���� ������ ���� ������
	          break;
	        }
	        visited[i][k] = 7;
	      }
	      break;
	    case 1:
	      for (int k = i; k >= 0; k--) { //��
	        if (map[k][j] == 6) {
	          break;
	        }
	        visited[k][j] = 7;
	      }
	      break;
	    case 2:
	      for (int k = j; k < m; k++) { //��
	        if (map[i][k] == 6) {
	          break;
	        }
	        visited[i][k] = 7;
	      }
	      break;
	    case 3:
	      for (int k = i; k < n; k++) { //��
	        if (map[k][j] == 6) {
	          break;
	        }
	        visited[k][j] = 7;
	      }
	      break;
	    }
	  }

	  public static class Node {
	    int x;
	    int y;
	    int idx;

	    Node(int y, int x, int idx) {
	      this.x = x;
	      this.y = y;
	      this.idx = idx;
	    }
	  }

	  public static void main(String[] args) {
	    sc.init();

	    new CCTV().solve();
	  }

	  static class sc {
	    private static BufferedReader br;
	    private static StringTokenizer st;

	    static void init() {
	      br = new BufferedReader(new InputStreamReader(System.in));
	      st = new StringTokenizer("");
	    }

	    static String readLine() {
	      try {
	        return br.readLine();
	      } catch (IOException e) {
	      }
	      return null;
	    }

	    static String readLineReplace() {
	      try {
	        return br.readLine().replaceAll("\\s+", "");
	      } catch (IOException e) {
	      }
	      return null;
	    }

	    static boolean hasNext() {
	      return st.hasMoreTokens();
	    }

	    static String next() {
	      while (!st.hasMoreTokens()) {
	        try {
	          st = new StringTokenizer(br.readLine());
	        } catch (IOException e) {
	        }
	      }
	      return st.nextToken();
	    }

	    static long nextLong() {
	      return Long.parseLong(next());
	    }

	    static int nextInt() {
	      return Integer.parseInt(next());
	    }

	    static double nextDouble() {
	      return Double.parseDouble(next());
	    }
	  }
	}

