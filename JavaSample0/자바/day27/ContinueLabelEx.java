package day27;

public class ContinueLabelEx { 	//continue �� 
	
	public static void main(String[] args)
	{
		out:
		for(int i=2; i<10; i++)
		{
			for(int j=1; j<10; j++)
			{
				if(j==5)
				{
					//break;		//->(1~9)*4�� ����� (�ݺ����� ���ߴ°Ŵϱ� j�� for���� ����ǰ� ������ ������ �Ŀ� i�� �����°�.
					//break out; //->out���̺��� ��°�� ��������.
					//continue;	//->j������������ ���� j==5�� ���� ����Ǿ���.
					continue out;	//->i�� ���������� ����. break�� ����� ��� ���������ϱ�? �ٹٲ��� ���Ͼ
				}
				System.out.println(i+"*"+j+"="+i*j);
			}
			System.out.println();
		}
	}

}
