package day29;

/*10��¥�� �迭����� ������ �߻����Ѽ� �迭�� �ְ� �̰��� �����ϴ� �� ������������!*/

//***�����Ʈ ����***(���̵� ��)
public class Example1 {

	public static void main(String[] args) {
		int random = 0;
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			random = (int) (Math.random() * 10);
			arr[i] = random;
		}
		System.out.println("���� �߻���Ų �迭");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
		System.out.println("==========");

		int tmp = 0;
		int count = arr.length;
		// �ݺ�Ƚ���� �ϳ��� �ٿ���� �Ѵ�. �ǵڿ� �ּڰ��� �ڸ������� ���� 9���� ���ϰ� �ι�° ū������ �⸮������ ������ 8����
		// ���ڸ� ���ϰ�! �̷����̴ϱ�
		for (int i = count - 1; i > 0; i--) {
			// j�� 1���� �������ִ°� �߿��ѵ� 0�����ϰԵǸ� j-1�� ������ ���ͼ� ������ ����.
			for (int j = 1; j < count; j++) {
				if (arr[j - 1] > arr[j]) {
					tmp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = tmp;
				}
			}
			
			/*//j�� 0�����ؼ� count-1�������ϸ�
			 * for (int j = 0; j < count-1; j++) {
				if (arr[j+1] < arr[j]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}*/
		}
		System.out.println("������������ ���ĵ� �迭");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}

	}
}
