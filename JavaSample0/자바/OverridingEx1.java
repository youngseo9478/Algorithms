package day30;
/*
 * <�������̵�>
 * 
 * */

class CellP
{
	public void sendSMS(String number, String msg)
	{
		System.out.println(number+"����"+msg+"�� �����ϴ�.");
	}
}

//����Ʈ�������� �޼����� ���� �� ����, ������, ���ϵ� ���� ���� ����
class SmartP extends CellP
{
	String fileName;	//�޼ҵ� �ȿ� ������ ������.. ��?
	
	//�޼����� ������ �Ϳ��� ���ϵ� ÷���� �� �ְ� ����� �߰��ߴ�. ->'������'
	public void sendSMS(String number, String msg)	//���� �ʷϻ� �ﰢ���� overrides day30.CellP.sendSMS �̷��� ��! ��ӹ��� Ŭ������ �������̵��ߴٴ°�~
	{
		System.out.println(number+"����"+msg+"�� �����ϴ�.");
		System.out.println(fileName+"������ ÷���մϴ�.");
		
	}
}

public class OverridingEx1 {

	public static void main(String[] args)
	{
		SmartP sp = new SmartP();
		sp.fileName = "Java_education.txt";
		sp.sendSMS("010-7878-8989", "������ ��ſ� �ݿ����Դϴ�.");
	}
}
