package day30;
/*<Final>
 * 
 * ���� �տ� final���̸� ������ ����� �ǹ��ؼ� ������ �ʴ� �� ����� �� -> **���**����°�!!
 * �޼ҵ� �տ� final���̸� (�޼ҵ�� �����ǰ� ������ = �������̵� ����) �����ǰ� ���̻� �ȵ�!!
 * Ŭ���� �տ� final���̸� ��� ���ް� ����� ��
 * 
 * �־���? ���ϰ� �س��� �� �����ϰ� ����� ��?
 * ��) ����̶�� �޼ҵ尡 �ִµ� �ؿ��� �������̵��Ҽ� ������ ���� ������ �� ���� 
 * Ư���� �޼ҵ�� � ���� �־ ������ �ʰ� �ؾ��ϴ� ��찡 ���� . Ŭ������ ������ �������� ->�̷� Ư���� �ִ� Ŭ���� �޼ҵ� ���� ���� ���Ҽ������� ��ŷ�ϱ� ���������� ��
 * 
 * */

class Parent
{
	//final int value = 10; 
	//���� ���̻� ���� ������� �� ���� �����! �׷��� ���ο��� child ��ü�� 100�������� �ϸ� ��������.
	int value;
	
	public void printValue()
	{
		System.out.println("value : "+value);
	}
	
	/*final public void printValue()
	{
		System.out.println("value : "+value);
	}
	�̷��� �޼ҵ忡 final���̸� �������̵��� �Ұ���������.*/
}

class Child extends Parent
{
	int value2;
	public void printValue()
	{
		super.printValue();
		System.out.print("value2 : "+ value2);
	}
}

public class FinalEx1 {

	public static void main(String[] args)
	{
		Child c= new Child();
		c.value=100; //�θ�κ��� ����� �޾ұ� ������ value�� ���� �־��� �� ����.�θ�Ŭ������ value�տ� final�� ������ ���⼭ ���� �ٽ� ������ ���� ���� ! �´� ����� �ȰŶ�!!
		c.value2=200;
		c.printValue();
	}
}
