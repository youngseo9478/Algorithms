package day27;

public class ControllerEx10 {	//while �̿��� ������

	public static void main(String[] args)
	{
		int i=2;
		while(i<10)
		{
			System.out.println(i+"��");
			int j=1;	//j�� ���⼭ �ʱ�ȭ�Ǿ���ϴ� ������ �ٽ� 1�� �Ǿ�� 3,4,...,9���� ����ϱ⶧��
			while(j<10)
			{
				System.out.println(i+"*"+j+"="+i*j);
				j++;
			}
			i++;
			System.out.println();
		}
	}
}
