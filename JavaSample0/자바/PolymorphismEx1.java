package day30;
/*<������ : polymorphism>
 * 
 * ����!!! �Ϲ�ȭ��ų �� �ִ�.
 *  
 * **��������**
 * 1.�θ�(����)Ŭ������ ������ �ڽ�Ŭ�������� �ּҸ� ������ �� �ִ�. instance���� �ڽ��� �ּ��� ���� �� �ִ�.
 * 2.�ڽ� �ּҰ��� ���� instance variable�� instance variable�� Ŭ������ ���ǵ� �κθ� ���δ�.
 *  ->����Ŭ������ ������ �κб����� �� �� �ִٴ� ��.*/

class One
{
	int valueOne;
	
	public void printOne()
	{
		System.out.println("valueOne : "+valueOne);
	}
}

class Two extends One
{
	int valueTwo;
	
	public void printTwo()
	{
		System.out.println("valueTwo : "+valueTwo);
	}
}

class Three extends Two
{
	int valueThree;
	public void printThree()
	{
		System.out.println("valueThree : "+valueThree);
	}
}

public class PolymorphismEx1 {

	public static void main(String[] args)
	{
		/*�츮�� ���� ���� ���!
		One one = new One();
		one.valueOne = 1;
		one.printOne();
		
		Two two = new Two();
		two.valueTwo = 2;
		two.printTwo();
		
		Three three = new Three();
		three.valueThree = 3;
		three.printThree();*/
		
		One one1 = new One();
		One one2 = new Two();
		One one3 = new Three();
		
		/*��������
		 * Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
		valueTwo cannot be resolved or is not a field
		The method printTwo() is undefined for the type One
		
		����ȭ�Ȱɷ� ���� one2�� one,two��� ������� ������ ������ ����
		�ֳ��ϸ� OneŬ������ �����ϰ��ִ°� valueOne�� printOne�� �����ϰ� �ֱ⶧���� �ű������ ���δ�.
		����Ŭ������ ������ �κб����� �� �� �ִٴ� ��.
		
		one2.valueOne = 10;
		one2.printOne();
		one2.valueTwo=20;
		one2.printTwo();
		*/
		
		//ĳ���� *****������ �߿�
		//ĳ���� �����ν� �������ִ� two�� three�κ��� ���� �� �ְ� �ȴ�. ->*�Ϲ�ȭ*��Ű�µ� ����
		Two two1 = (Two)one2;
		two1.valueOne=200;
		two1.printOne();
		two1.valueOne=300;
		two1.printOne();
		
		Three three1 = (Three)one3;
		three1.valueOne=400;
		three1.printOne();
	}
}
