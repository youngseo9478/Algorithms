package day27;

public class ControllerEx3 {	//if ���ǹ� ��ȣ�ȿ� �������� ����ϴ� ���

	public static void main(String[] args)
	{
		String name ="kim";	//������ �տ� String ���̸� ���ڿ� ������ ���� �� �ִ�. �ֵ���ǥ ���
		int number = 75;
		
		if(number>80 && name =="kim")	//OR�ϸ� �� �߿� �ϳ��� �¾Ƶ� if���� ����ȴ�
		{
			System.out.println(name+"�� ������"+number);
		}
		else
		{
			System.out.println(name+"�� ������"+number+"�� Ż��");
		}
	}
}
