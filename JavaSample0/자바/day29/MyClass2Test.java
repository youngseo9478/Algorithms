package day29;
/*�����ڵ� �����ε����� ���� �� �ִٴ� �� �����ִ� �ڵ�
 * �������� �Ű����� �κ��� ���� �ͺ����ؼ� �Ѱ���Ÿ��, �ΰ���Ÿ��, �Դٰ� �������� �ٸ��� �ؼ� ����� ������
 * �Ű������κи� �˸°� ä���ָ� ���� ������ �̸����� ȣ���� �� �ִ�.*/

public class MyClass2Test {		//�̰� �츮�� ���� ���� Ŭ���� public class�� ��ü�� �Ǵ� ������ �ϳ��� �����ؾ��Ѵ�.

	public static void main(String[] args)
	{
		MyClass2 mc1 = new MyClass2();
		MyClass2 mc2 = new MyClass2("2MB");
		MyClass2 mc3 = new MyClass2("2MB",46);
		MyClass2 mc4 = new MyClass2(46,"2MB");
		
		System.out.println(mc1.getName()+", "+mc1.getAge());
		System.out.println(mc2.getName()+", "+mc2.getAge());
		System.out.println(mc3.getName()+", "+mc3.getAge());
		System.out.println(mc4.getName()+", "+mc4.getAge());
	}
}

class MyClass2	//�츮�� ���Ӱ� ������ Ŭ����
{
	private String name;
	private int age;
	
	public MyClass2()
	{
		name = "www.itbank.kr";
	}
	
	public MyClass2(String n)
	{
		name = n;
	}
	
	public MyClass2(String n, int a)
	{
		age = a;
		name = n;
	}
	
	public MyClass2(int a, String n)
	{
		age =a;
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
}
