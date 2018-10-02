package difficulty2;

import java.util.Scanner;

/*패턴에서 반복되는 부분을 마디라고 부른다. 문자열을 입력 받아 마디의 길이를 출력하는 프로그램을 작성하라.
각 문자열의 길이는 30이다. 마디의 최대 길이는 10이다.
[입력]
가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
각 테스트 케이스의 첫 번째 줄에는 길이가 30인 문자열이 주어진다.
[출력]
출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)*/
public class Pattern {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next(); // 저번부터 같은 실수인데... nextLine()은 개행문자로 문자열로
									// 취급한다. 위에서 숫자를 입력하고 개행문자가 입력되어있기 때문에 각별히
									// 주의...
			int p = 0;
			for (int i = 0; i < str.length(); i++) {
				String a = str.substring(0, i);
				if (i * 2 <= str.length()) {
					String b = str.substring(i, i * 2);
					if (i != 0 && a.equals(b)) { // 꼭 i가 0일 때는 제외해야한다.
						p = a.length();
						break;  //여기서 브레이크 안걸면 KOREAKOREAKOREA를 패턴길이로 인식함.
					}
				}
			}
			System.out.println("#" + tc + " " + p);
		}
		sc.close();
	}
}
