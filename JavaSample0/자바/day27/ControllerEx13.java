package day27;
import java.util.Scanner;
public class ControllerEx13 {

	public static void main(String[] args)
	{
		int menu = 0;
		
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("(1) square");
			System.out.println("(2) square root");
			System.out.println("(3) log");
			System.out.println("���ϴ� �޴�(1~3)�� �����ϼ���. (���� :0) >");
			menu = sc.nextInt();
			
			if(menu==0)
			{
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
			else if (!(1<=menu && menu<=3))
			{
				System.out.println("�޴��� �߸� �����Ͽ����ϴ�. �ٽ� �Է����ּ���");
				System.out.println();
				continue;	//��Ƽ���ϸ� �Ʒ��� ����ȵǰ� �ٽ� ���Ϲ��� �������� ���� �����ϱ⶧���� �ؿ� ���� ������ ��µ��� �ʴ´�.
			}
			System.out.println("�����Ͻ� �޴��� "+menu+"�� �Դϴ�.");
			System.out.println();
		}
	}
}
