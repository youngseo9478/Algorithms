package day4_7;
/*
 * 1.������ ���ص� �� 
 * Ŭ������ �����Ѱͱ��� ��ü�� �����ϴµ� ..�͸�Ŭ������ ���� �̿ϼ��� interface�� �޼ҵ忡�� ���� �����ϰ� �Ǹ� 
 * �� �޼ҵ� �ȿ����� ���ǰ� �޼ҵ尡 ������ �Ҵ�Ǿ��� �޸𸮵� ���� �����Ǵ°�. 
 * �������� ���°� �ƴ϶� �Ͻ����� ���·� ����ϴ� ��(���󵵰� ������ �޸𸮸� �ƿ�����ִ°Ծƴ϶� ������ �޸� ��� ����̳����� �ٷ� �������ִ°�) 
 * 2.ǥ������ ǳ������(interface�� ���� �����ϴ� Ŭ���������� Ư¡�� �� ��Ÿ�� �� ����
 * 3.�������� ������*/
interface TestInter
{
	final int DATA = 3000;
	
	public void printData();
	
}

class AnnonyInner2{
	public void test(String str)
	{
		new TestInter(){ //��ü�� �ϼ��Ǹ� �͸� Ŭ������ �νĵȴ�=> ��ü�� �Ǵ� ��.
			public void printData()
			{
				System.out.println(str+":data="+DATA);
			}
		}.printData();
	}
}

public class AnnonymousInnerEx2 {

	public static void main(String[] args)
	{
		new AnnonyInner2().test("kim");
	}
}
