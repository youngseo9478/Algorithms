package day27;

import java.util.Scanner;	//Scanner�� ����ϱ����ؼ��� �� ������ �� ����� �Ѵ�.

	public class ControllerEx5 {	//consoleâ���� �Է¹޴� ��� ����

		public static void main(String[] args)
		{
			System.out.println("������ ���� �Է��ϼ��� > ");
			
			Scanner sc = new Scanner(System.in);		//Scanner�� �Է¹��� ���� �����ϴ� ...
			int month = sc.nextInt();	
			
			switch (month)
			{
			case 3:
			case 4:
			case 5:
				System.out.println("������ ������ ���Դϴ�.");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("������ ������ �����Դϴ�.");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("������ ������ �����Դϴ�.");
				break;
			default:
				System.out.println("������ ������ �ܿ��Դϴ�.");
			}
		}
}
