package day27;		//������Ʈ ��°�� ���� ���ϸ� �ű�� �ٸ� ��ǻ�Ϳ����� �����غ� �� �ִµ� �̶� �Ȱ��� ��Ű���� ���������� �ƴϸ� �ƿ�������� �ƴϸ� ���θ��� ��Ű�������� �ٲ��ִ��� �ؾ� 
					//������ �ȳ���~~(����!)

public class day27Ex3 { // ä���� ������� �����

	public static void main(String[] args) {
		int n=10;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (i < 5) {
					if (j >= n/2 - i && j <= n/2 + i) {
						System.out.print("* ");
					} else
						System.out.print("  ");
				}
				else
				{
					if(j>=i-n/2 && j<=n-i+n/2)
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
