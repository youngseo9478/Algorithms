

abstract class Abs1
{
	String name;
	String firstName;
	abstract public void printName(); //��ü�� ���������ʰ� �����ݷ��� ���� ->abstract�� ǥ���������  -> Ŭ���� ��ü���� abstract �������
}

class AbsKorImp extends Abs1	//�ؿ� ��ü�� �Ⱦ��� �̷� ������ ��  The type AbsKorImp must implement the inherited abstract method Abs1.printName()
{
	
	public void printName()
	{
		System.out.println("name : "+firstName+name);//�� �̸�
	}
}

class AbsEngImp extends Abs1
{
	public void printName()
	{
		System.out.println("name :"+name+firstName);//�̸� ��
	}
}

public class AbstractKeywordEx2 {

	public static void main(String[] args)
	{
		AbsKorImp aki = new AbsKorImp();
		aki.firstName ="��";
		aki.name = "�ƹ���";
		aki.printName();
		
		AbsEngImp aei = new AbsEngImp();
		aei.firstName ="��";
		aei.name = "�ƹ���";
		aei.printName();
	}
}
