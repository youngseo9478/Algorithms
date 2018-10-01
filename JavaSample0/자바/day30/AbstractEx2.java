package day30;

abstract class Unit
{
	String familyName;
	String unitName;
	int life =100;
	
	public void printUnitInfo()
	{
		System.out.println("���� :"+familyName);
		System.out.println("���� : "+unitName);
		System.out.println("���� ����ġ : "+life);
	}
	
	public abstract void decreaseLife();
}

class AAA extends Unit
{
	public AAA()
	{
		familyName = "AAA";
		unitName = "A worker";
	}
	
	public void decreaseLife()
	{
		life-=10;
	}
}

class BBB extends Unit
{
	public BBB()
	{
		familyName = "BBB";
		unitName = "B fighter";
	}
	
	public void decreaseLife()
	{
		life-=5;
	}
}


public class AbstractEx2 {

	public static void main(String [] args)
	{
		AAA aaa = new AAA();
		BBB bbb = new BBB();
		
		aaa.decreaseLife();
		bbb.decreaseLife();
		
		aaa.printUnitInfo();
		System.out.print("=====================");
		System.out.println();
		bbb.printUnitInfo();
	}
}
