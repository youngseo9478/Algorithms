package day27;

public class BreakLabelEx1 {	//break label�� �������� ���������� ��.
	
	public static void main(String[] args)
	{
		int result = 0;
		forout:	//�����ݷоƴϰ� �ݷ�! �극��ũ�ϸ� ���ε� �ѹ��� �������°�
		for(int i=0; i<10; i++)
		{
			for(int j=0; j<10;j++)
			{
				for(int k=0; k<10; k++)
				{
					result +=k;
					if(result>1000)
					{
						System.out.printf("i:%d, j:%d, k:%d\n", i,j,k);
						break forout;
					}
						
				}
			}
		}
	
	System.out.println("result:"+result);
	}
}
