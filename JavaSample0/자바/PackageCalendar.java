package day3_7;
/*calendar class
 * get() �Ұ�ȣ�ȿ� �ʵ���� ���µ�
 * �ʵ尡 ������ �پ���.�׷��� �� �߿�
 * MONTH�� ������ 0~11�̴ϱ� �������� ����� �� ��� +1������ϴ°� �����ϱ�
 * */
import java.util.Calendar;
public class PackageCalendar {

	public static void main(String[] args)
	{
		StringBuffer sb = new StringBuffer("���� ��¥ : ");
		Calendar cTime = Calendar.getInstance();
		
		int year = cTime.get(Calendar.YEAR);
		int month = cTime.get(Calendar.MONTH)+1;
		int day = cTime.get(Calendar.DAY_OF_MONTH);
		
		sb.append(year);
		sb.append("�� ");//append�� �̾���̴� ��.
		sb.append(month);
		sb.append("�� ");
		sb.append(day);
		sb.append("�� ");

		System.out.println(sb.toString()); //toString�� ������..
	}
}
