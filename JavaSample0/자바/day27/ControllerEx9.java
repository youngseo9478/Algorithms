package day27;

public class ControllerEx9 {	//while �� ->������ ���϶� ���� ����

	public static void main(String[] args)
	{
		int i=0;
		
		while(i<10)
		{
			System.out.println(i+"��° ����");
			i++;
		}
		
		System.out.println("���� ����");
		
		int j = 10;
		int result = 0;
		while(true)
		{
			result+=j;
			if(result>1000)
				break;
			j++;
		}
		System.out.println("result:"+result+", j:"+j);
	}
}
