package day28;

public class ArrayEx4 {

	public static void main(String[] args)
	{
		int [] arrInt1 = new int[5]; 	//�迭1�� 5��¥���� �������. arrInt1�� �ּҰ��� ���� �ִ�.
		for(int i=0; i<arrInt1.length; i++)
		{
			arrInt1[i]=i;
		}
		
		int [] arrInt2 = arrInt1; 		//�迭2���ٰ� �迭1�� �ּҰ��� �Ѱ��� ��. ->�ᱹ �� ���� ���� �ּҰ��� ����Ű�Եȴ�. ***
		for(int i=0; i<arrInt2.length;i++)
		{
			System.out.println("arrInt2["+i+"] = "+arrInt2[i]);
		}
	}
}
