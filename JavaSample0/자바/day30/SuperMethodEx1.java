package day30;
/*
 * ������ ȣ���� �����ϴ� ��� ȣ��ȴ�.

 * 
 * this() ���������Ҷ� �ڱ������ ȣ��
 * super() ���������Ҷ� �θ������ ȣ��
 * 
 * super �� super() 
 * ���ۿ� ���۸޼ҵ�!
 * 
 * 
 * */

class SuperC
{
	String name;
	
	public SuperC(String name)//�����ڿ� �޼ҵ�...
	{
		this.name = name;
	}
	
	public void printName()
	{
		System.out.println("name : "+name);
	}
}
/*�̷����ϸ� ������ -> �θ��� superC�� �̸��� �޾ƾ���.
 * �̸��� ���⶧���� �θ�κ��� �̸��� ������� ������ �ߴ°� */
class ChildC extends SuperC
{
	int age;
	//�̰Ե����� ������ �ȶ�
	public ChildC(String name, int age)
	{
		super(name); //�����ڸ� ȣ���ؼ� ���۸� ���ؼ� name�� �� �Ѱ�����Ѵ�.
		this.age=age;//���⿡ age �ʱ�ȭ�����ָ� ���ο��� �� �ְ� ��ü �����ؼ� ����ص� 0�̶�� ���.
	}
}

public class SuperMethodEx1 {
	public static void main(String [] args)
	{
		System.out.print("==========�θ�Ŭ����===========");
		System.out.println();
		SuperC sc = new SuperC("�谡");
		sc.printName();
		
		System.out.print("==========�ڽ�Ŭ����===========");
		System.out.println();
		ChildC cc = new ChildC("�̰�", 33);
		cc.printName();
		System.out.println("age : "+cc.age);
	}
}
