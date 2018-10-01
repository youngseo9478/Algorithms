package day30;
/*interface�� ����� ����
 * �ڹٿ����� � Ư¡���� ���ִ� �� ������ ���ֱ� ������ ���߻���� �������� �ʴµ� 
 * �������̽��� � ��ɿ� ���� ����� �ֱ⶧���� �̰ɷθ� �ٸ� �ֵ��� ������ ��ȭ��Ű���� ���� ->���߻���� ����!*/

interface Inter1
{
	static final int VALUEA=100;
	
	public int getA();
}

interface Inter2
{
	static final int VALUEB=200;
	
	public int getB();
}

interface Inter3 extends Inter1, Inter2  //��ӹ޾Ƽ� ���3�� �޼ҵ�3�������ִ°Ŷ� ����.
{
	static final int VALUEC=400;
	
	public int getC();
}

class ImpleC implements Inter3//���⼭ interface�� ��ü�� ������ �Ǿ�����. ->Inter1,2,3�� ImpleC�� ����ó�� �ൿ��!
{
	public int getA()
	{
		return VALUEA;
	}
	public int getB()
	{
		return VALUEB;
	}
	public int getC()
	{
		return VALUEC;
	}
}

public class InterfaceEx3 {

	public static void main(String[] args)
	{
		ImpleC ic = new ImpleC();
		System.out.println("A : "+ ic.getA());
		System.out.println("B : "+ ic.getB());
		System.out.println("C : "+ ic.getC());
		//���󵵾ƴϰ� ������ Inter1�� �������̽�.  implements���Ѽ� �����س�����	
		//�������̽��� ��ü�� ������ ���� Ŭ����ó�� �������� �� �ִ�.->��üȭ�� �� �ִ�
		Inter1 it1 = ic;//Inter1�� �����̶���ϸ� 2,3�κ��� ������ä�� �޴´�. ->ĳ�������� �� �� �� �ִ�.
		Inter2 it2 = ic;
		Inter3 it3 = ic;
		
		ImpleC ic2 = (ImpleC)it1;	//ImpleC Ŭ���� �ȿ� Inter1,2,3�� ��� �����Ǿ��ֱ� ������ ĳ������ ���ָ� �� ������ ���·� ��� �� ����� �� ����
		System.out.println("A:"+ic2.getA()+" B:"+ic2.getB()+" C:"+ic2.getC());
	}
}
