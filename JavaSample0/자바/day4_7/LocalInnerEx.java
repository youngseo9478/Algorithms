package day4_7;
/*���� ���� Ŭ����
 * Ŭ������ �޼ҵ� �ȿ� Ŭ������ �����ؼ� ����ϴ� ��.
 * 
 * �׳� �޼ҵ�ó�� ���� �� ���� Ŭ������ �� �־������?
 * ->������ ������ ����(�ڿ��� ����)
 * 
 * 
 * (����)���� ��Ű������ ���� �̸��� Ŭ���� �̸��� ���� �ȵ�! 
 * ������ �����̸����� �� Ŭ�������� ã�´�. 
 * */
class LocalInner
{
	int a=100;
	
	public void innerTest(int number)
	{
		int b =200;
		
		class Inner
		{
			public void printData()
			{
				System.out.println("a:"+a);
				System.out.println("b:"+b);
				System.out.println("number:"+number);
			}
		}
		Inner i = new Inner();
		i.printData();
	}
}

public class LocalInnerEx {
	
	public static void main(String[] args)
	{
		LocalInner li = new LocalInner();
		li.innerTest(3000);
	}

}
