package day27;

import java.util.Scanner;

public class FunctionEx2 { //���� ���� �Է¹޾Ƽ� ����� ���� �Լ��� ���� ��հ��� �޾Ƽ� ����ϴ� ���α׷�

		public static void main(String[] args)
		{
			int kor,eng,math;
			
			Scanner sc = new Scanner(System.in);
			kor = getscore("����", sc);
			eng = getscore("����", sc);
			math = getscore("����", sc);
			
			/*Scanner sc = new Scanner(System.in);
			
			System.out.println("���������� �Է����ּ��� >");		//�̺κе鵵 �Լ��� ����� �� �� �ִ�. �ݺ��Ǵϱ�!
			kor = sc.nextInt();		//sc.nextInt()��...
			
			System.out.println("���������� �Է����ּ��� >");
			eng = sc.nextInt();
			
			System.out.println("���������� �Է����ּ��� >");
			math = sc.nextInt();
			*/
			System.out.print("���� ��������� :");		//�ڹٿ��� �Ҽ��� ����Ʈ�� double~!!
			double average = avr(kor,eng,math);		//�̷��� ������ �ᵵ �ǰ� ��¶� �ѹ��� println(avr(kor,eng,math));�ص� �ǰ�, ("���:"+average);�ص���.
			System.out.println(average);            //�Է¹��� ����,����,���������� �Ű������� ����� ���ϴ� �Լ�
			
			sc.close();	//sc�Ҵ��� �����ϴ� �ǰ�..?
		
			
		}
		
		public static int getscore(String subjectName, Scanner sc)
		{
			int num = 0;
			System.out.println(subjectName+"������ �Է����ּ��� >");
			num = sc.nextInt();
			
			return num;
		}
		public static double avr(int a, int b, int c)
		{
			double result=(a+b+c)/3.0;	//�׳� 3�ϸ� ���������� ���Ǿ �Ҽ����Ʒ��ڸ��� ���ư���. �ϳ����̶� �Ǽ������� ���ָ� ��굵 �Ǽ��� ���Ǿ� ���´�.
			return result;		//result=a+b+c�̸� return result/3; �ص� �� 
		}
}
