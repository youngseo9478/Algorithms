package day28;

public class ArrayEx6 {

	
	public static void main(String[] args)
	{
		int[] randArr = new int[10];
		for(int i=0; i<randArr.length;i++)
		{
			randArr[i] = i;
			System.out.print(randArr[i]);
		}
		System.out.println();
		
		for(int i=0; i<randArr.length; i++)
		{
			int n =(int)(Math.random()*10);
			int tmp = randArr[0];
			randArr[0]=randArr[n];	//�����Ҷ� randArr�� ũ�Ⱑ 10�̱⶧���� 0~9������ �ε����� ���� �׷��Ƿ� �����߻�*10�ϸ� 0~9�� �Ѽ��ڰ� ����..
			randArr[n]=tmp;

		}
		System.out.println();
		//�տ� ���� 0123456789�� ���׹��� ���̰� �Ǵ� ��.
		for(int i=0; i<randArr.length; i++)
		{
			System.out.print(randArr[i]);
		}
		System.out.println();
	}
}
