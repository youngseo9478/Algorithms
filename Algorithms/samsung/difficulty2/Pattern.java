package difficulty2;

import java.util.Scanner;

/*���Ͽ��� �ݺ��Ǵ� �κ��� ������ �θ���. ���ڿ��� �Է� �޾� ������ ���̸� ����ϴ� ���α׷��� �ۼ��϶�.
�� ���ڿ��� ���̴� 30�̴�. ������ �ִ� ���̴� 10�̴�.
[�Է�]
���� ù �ٿ��� �׽�Ʈ ���̽��� ���� T�� �־�����, �� �Ʒ��� �� �׽�Ʈ ���̽��� �־�����.
�� �׽�Ʈ ���̽��� ù ��° �ٿ��� ���̰� 30�� ���ڿ��� �־�����.
[���]
����� �� ���� '#t'�� �����ϰ�, ������ �� ĭ �� ���� ������ ����Ѵ�.
(t�� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)*/
public class Pattern {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next(); // �������� ���� �Ǽ��ε�... nextLine()�� ���๮�ڷ� ���ڿ���
									// ����Ѵ�. ������ ���ڸ� �Է��ϰ� ���๮�ڰ� �ԷµǾ��ֱ� ������ ������
									// ����...
			int p = 0;
			for (int i = 0; i < str.length(); i++) {
				String a = str.substring(0, i);
				if (i * 2 <= str.length()) {
					String b = str.substring(i, i * 2);
					if (i != 0 && a.equals(b)) { // �� i�� 0�� ���� �����ؾ��Ѵ�.
						p = a.length();
						break;  //���⼭ �극��ũ �Ȱɸ� KOREAKOREAKOREA�� ���ϱ��̷� �ν���.
					}
				}
			}
			System.out.println("#" + tc + " " + p);
		}
		sc.close();
	}
}
