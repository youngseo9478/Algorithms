package day28;

//private���� �����ϰ� set, get�Լ��� �̿��ؼ� ���������� ����ϴ� ���� ����. ������ ���к��ϰ� �Ű����ų� ���ǵǴ°� ���� ����!
class Time
{
	private int hour;
	//public int hour;  ->�̷����ϸ� 24���̻��� ���ڵ� �� �� ��
	public int min;
	public int second;
	
	/*public void setHour(int h)
	{
		hour = h;
	}*/  //private���� ���� Ÿ�� �ٲ��ְ� �̷��� �ص� ������ �ذ��� �ȵ�
	public void setHour(int h)
	{
		if(h<24)
		{
			hour = h;
		}
		else
		{
			System.out.println("�ð��� �߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���");
		}
		
	}
	
	public void printTime()
	{
		System.out.println(hour+"��"+min+"��"+second+"��");
	}
	
}

public class CapsulationEx2 {

	public static void main(String[] args)
	{
		Time t = new Time();
		
		t.setHour(50);
		t.min = 50;
		t.second =45;
		t.printTime();
	}
}
