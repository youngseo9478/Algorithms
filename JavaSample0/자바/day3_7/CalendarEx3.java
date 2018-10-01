package day3_7;
//import java.util.*; //util�ȿ��Ÿ� �� �������°ǵ� �̷��� �ʹ� Ŀ���� ��ȿ����
import java.util.Calendar;

public class CalendarEx3 {

	public static void main(String[] args)
	{
		Calendar date = Calendar.getInstance();
		date.set(2014, 1,19);// 2005.8.31 MONTH�� 0~11�̴ϱ�
		
		System.out.println(toString(date));
		System.out.println("==1230�� ��==");
		date.add(Calendar.DATE, 1230);	//DATE : the day of the month.
		System.out.println(toString(date));
		
		System.out.println("==6�� ��==");
		date.add(Calendar.MONTH, -6);
		System.out.println(toString(date));
		
		System.out.println("==31�� ��(roll)=="); 
		date.roll(Calendar.DATE, 31);//������ �������� �� Ŀ���ų� �� �۾����� �ڸ��ø��� �����ʰ� �� �ڸ����� ��ȭ��Ű�� �޼ҵ�(roll)
		System.out.println(toString(date));
		
		System.out.println("==31�� ��(add)==");
		date.add(Calendar.DATE, 31);//������ �������� �� Ŀ���ų� �� �۾����� �ڸ��ø��� �ϴ� �޼ҵ�(add)
		System.out.println(toString(date));		
	}
	
	public static String toString(Calendar date)
	{
		return date.get(Calendar.YEAR)+"�� "+(date.get(Calendar.MONTH)+1)+"�� "+date.get(Calendar.DATE)+"��";
	}
}
