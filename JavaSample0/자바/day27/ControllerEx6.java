package day27;

import java.util.Scanner;

public class ControllerEx6 {	//����(0~100)�� �Է¹޾Ƽ� �����ִ� ���α׷�(switch case�� ���) 

	public static void main(String[] args)
	{
		System.out.println("������ �Է����ּ��� > ");
		
		Scanner sc = new Scanner(System.in);		//Scanner�� �Է¹��� ���� �����ϴ� ...
		int score = sc.nextInt();		//�ڵ徲�� �ڿ��ڵ� �������� insertŰ ������ �ذ�~	
		
		switch(score)
		{
		case 100:		//�ڹٿ����� case�� �ȿ� ���ǹ� �� �� ����. case score>90: ->�̷��� �ȵȴ�.
		case 99:
		case 98:
		case 97:
		case 96:
		case 95:
			System.out.println("����� ������ A�Դϴ�.");
			break;
		case 89: case 88: case 87: case 86:	case 85:  //�̷��� ���ٿ� ���� �͵� �����ϴ�.
			System.out.println("����� ������ B�Դϴ�.");
			break;
		case 79:
		case 78:
		case 77:
		case 76:
		case 75:
			System.out.println("����� ������ C�Դϴ�.");
			break;
		default:
			System.out.println("����");	
		}
			
	}
}
