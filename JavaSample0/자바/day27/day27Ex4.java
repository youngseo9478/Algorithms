package day27;

public class day27Ex4 {		//�̰� ����3�� ���ʸ��� ����

	public static void main(String[] args) {
		
		int n=17;
		int a=n;
		int b=n/2;
			
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (i <= b) {
					if (j >= b - i && j <= b + i) {
						System.out.print("* ");
					} else
						System.out.print("  ");
				}
				else
				{
					if(j>=i-b && j<a-i+b)
					{
						System.out.print("* ");
					}
					else
						System.out.print("  ");
				}		//���ʸ��ϰ� Ǫ�� ����� ����!! ����� �ٲ� �����ϰ� 
						//������ 10�̳� 9 �̷��Ÿ� ����� ������ ��Ȳ!! 
			}
			System.out.println();
		}
	}
}
