package day4_7;
/*��������Ŭ����
 * static�� �ٷ� �޸𸮿� �ö�->�̹��ֱ⶧���� ��ü �����Ҷ� ���� �ٸ���! new�Ƚᵵ ��.
 * �ȿ� static�� ������ �� Ŭ������ static�̾�� �Ѵ�.
 * 
 * */

//import day4_7.MemberInnerClass.Inner;

class StaticInner
{
	int a=100;
	int b=200;
	static int c = 300;
	
	static class Inner
	{
		static int d = 2000; //�� ���� static������ Ŭ������ static���� ������ ������ �ȳ�
		public void printData()
		{
			System.out.println("c: "+c);
			System.out.println("d: "+d);
			//System.out.println("a: "+a); ->instance variable�̶� ���⼭ ��� ���Ѵ�
		}
	}
}

public class StaticInnerEx {

	public static void main(String[] args)
	{
		StaticInner.Inner inner = new StaticInner.Inner(); 
		//�Ʊ�� MemberInnerClass.Inner inner = new MemberInnerClass().new Inner(); �̷����ߴµ�
		//���⼭�� static�̶� �̹� �޸𸮿� �ö� �ֱ⶧���� new�� �Ⱦ��� StaticInner�� ()�� �Ⱥ��δ�
		inner.printData();
	}
}
