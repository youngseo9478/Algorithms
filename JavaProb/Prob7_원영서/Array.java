package util;

public class Array {
	public static int[] sort(int[] a) {

		// ���� �����ϱ� ���� a2�� �迭 ����
		int[] a2 = new int[a.length];
		System.arraycopy(a, 0, a2, 0, a.length);

		// sorting
		int temp;
		for (int i = 0; i < a2.length - 1; i++) {
			for (int j = i + 1; j < a2.length; j++) {
				if (a2[i] > a2[j]) {
					temp = a2[i];
					a2[i] = a2[j];
					a2[j] = temp;
				}
			}
		}
		
		//������ �����͸� ����
		return a2;
	}
}
