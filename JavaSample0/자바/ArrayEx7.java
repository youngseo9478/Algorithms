package day28;

public class ArrayEx7 {

	/*
	 * �������迭 a[][] -> a[��][��]
	 */

	public static void main(String[] args) {
		int[][] arrInt = new int[2][3];
		int count = 1;
		for (int i = 0; i < arrInt.length; i++) // arrInt�� length�� 2 �׸��� �����غ���
												// ��. �ΰ��� ū �޸𸮾ȿ� 3��¥�� �迭�� �ִ� �׸�
												// ����!
		{
			for (int j = 0; j < arrInt[i].length; j++)// ������ length�� 3. �������
														// length[0].length����ϸ�
														// �ΰ��� ū�޸� �� ��ĭ�� �鿩�ٺ�����
														// 3��¥�� �迭�� ������ ����Ŵ
			{
				arrInt[i][j] = count++;
			}
		}
		for (int i = 0; i < arrInt.length; i++) {
			for (int j = 0; j < arrInt[i].length; j++) {
				System.out.println(arrInt[i][j]);
			}
		}
		//////////////////////// for(type ���� : �迭) �ε������Ⱦ��� �ȿ� ���鸸 �����Ҷ� ���. ���� ���� ���Ǵ� �̷��� ���
		
		System.out.println("================for �� ���");

		int[] arrInt3 = { 1, 2, 3, 4, 5, 6, 7 };
		for (int temp : arrInt3) // int���� �����ϴ� ������ �迭3�� �ϳ��ϳ��� ���� �ش��ϴ� ����������
									// int�̱� ����
		{
			System.out.println(temp);
		}
		//////////////////////////
		System.out.println("================������ �迭 for�� ���");
		int[][] arrInt2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } }; // �̰�
																						// 4X3���.

		for (int[] temp1 : arrInt2) // ������ �迭2�� �⺻����ϳ��� �޴°�..{1,2,3} ,{4,5,6}
									// �̷��� �ϳ��� ���°�! ������ Ÿ���� ���� ��� ����!
		{
			for (int temp2 : temp1) {	//����1���� ��� �ϳ����� ��������Ƿ� �̰� �����·� ��Ÿ���� ����1�� 4���� 3��¥���迭�� ���� ���ְ� 
										//�̷��� �ѹ��� �����ȿ� �־��ָ� 3��¥�� �迭�� ������ ���� ����2�� ���°�!******
				System.out.println(temp2);//����2�� ������ ������ ������ �� �����°�
			}
		}

	}
}
