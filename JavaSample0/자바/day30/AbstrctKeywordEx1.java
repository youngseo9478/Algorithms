package day30;
/*<Abstract Keyword>
 * �־������� ���� �������� ����!
 * 
 * �̿ϼ����� ���¸� ����
 * 
 * ��ü�� ���⶧���� ���赵�� �ϼ��Ȱ� �ƴ� ->��ü�� ������ �� ����
 * <��ü�� �����ϴ� ���>
 * 1.�̿ϼ��� Ŭ������ ��ӹ����� �ڽ�Ŭ������ �̿ϼ��� �޼ҵ嵵 ������ �ְԵ� �̰Ÿ� �ڽ�Ŭ�������� �ϼ��ϴ� �� ->��ü�� ���� �� �ִ�.
 * 		(�ڽ�Ŭ������ �̿ϼ������·� �������� ���� ������ �츮�� ����Ϸ��°Ŵϱ� �ϼ��Ǵ¹���� ���� ���.)*/

abstract class Abs1
{
	String name;
	
	abstract public void printName(); //��ü�� ���������ʰ� �����ݷ��� ���� ->abstract�� ǥ���������  -> Ŭ���� ��ü���� abstract �������
}

class AbsKorImp extends Abs1	//�ؿ� ��ü�� �Ⱦ��� �̷� ������ ��  The type AbsKorImp must implement the inherited abstract method Abs1.printName()
{
	String firstName;
	
	public void printName()
	{
		System.out.println("name : "+firstName+name);
	}
}


public class AbstrctKeywordEx1 {

	public static void main(String[] args)
	{
		AbsKorImp aki = new AbsKorImp();
		aki.firstName ="��";
		aki.name = "�ƹ���";
		aki.printName();
	}
}
