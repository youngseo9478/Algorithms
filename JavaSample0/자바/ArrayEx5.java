package day28;

public class ArrayEx5 {
	// �迭 Ȱ�� �ڵ�
	public static void main(String[] args) {
		int[] korNum = { 87, 94, 56, 76, 94, 78, 86, 56, 69, 55 };
		int[] mathNum = { 87, 97, 56, 76, 84, 78, 86, 56, 69, 55 };
		int[] engNum = { 87, 98, 56, 76, 53, 78, 86, 56, 69, 55 };

		int totalKor = 0, totalMath = 0, totalEng = 0;

		for (int i = 0; i < korNum.length; i++) {
			totalKor += korNum[i];
			totalMath += mathNum[i];
			totalEng += engNum[i];
		}

		System.out.println("�л����� ���� ��� : " + (totalMath / 3.0)); // ��Ģ�����ϸ�
																	// int��������
																	// 3.0�־��ָ�
																	// �����
																	// double��
																	// ��µǴ� ��.**
		System.out.println("�л����� ���� ��� : " + (totalEng / 3.0));
		System.out.println("�л����� ���� ��� : " + (totalKor / 3.0));

		int korMax = 0, engMax = 0, mathMax = 0; // �ִ밪�� ���� ������ ���񺰷� ���� �������ش�
													// �ִ밪�� �˰� ���� ���� 0���� �ʱ�ȭ�ϰ�,
													// �ּҰ��� �˰� ���� ���� 100����
													// �ʱ�ȭ�ؾ��Ѵ�.

		int tmp =0;
		//swap�ϴ� ����� �ִ�.->�ϼ��ȵ� �ٽ� �����ϱ� Ʋ����
		for (int i = 1; i < korNum.length; i++) {
			if (korNum[i] > korNum[i-1]) 
			{
				tmp=korNum[0];
				korNum[i-1]=korNum[i];
				korNum[i]=tmp;
			}
			if (engNum[i] > engNum[i-1]) 
			{
				tmp=engNum[i-1];
				engNum[i-1]=engNum[i];
				engNum[i]=tmp;
			}
			if (mathNum[i] > mathNum[i-1]) 
			{
				tmp=mathNum[i-1];
				mathNum[i-1]=mathNum[i];
				mathNum[i]=tmp;
			}
		}
		System.out.println();
		System.out.println("����1�� ���� : " + korNum[0]);
		System.out.println("����1�� ���� : " + engNum[0]);
		System.out.println("����1�� ���� : " + mathNum[0]);
		
		for (int i = 0; i < korNum.length; i++) {
			if (korNum[i] > korMax) // �ּҰ��� ���ϴ� ���̶�� �ε�ȣ�� �ݴ뿩���Ѵ�.
				korMax = korNum[i];
			if (engNum[i] > engMax)
				engMax = engNum[i];
			if (mathNum[i] > mathMax)
				mathMax = mathNum[i];
		}
		System.out.println();
		System.out.println("����1�� ���� : " + korMax);
		System.out.println("����1�� ���� : " + engMax);
		System.out.println("����1�� ���� : " + mathMax);
	}
}
