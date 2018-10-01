package day3_7;
import java.util.Date;	//DateŬ������ �����ִ� ��Ű��
import java.util.Scanner;	//��ĳ��Ŭ������ hasNextLine()�޼ҵ带 �����ִ� ��Ű��
import java.util.Calendar;	//Calendar�� �ʿ��� ��Ű��
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class DateFormatEx2 {

	public static void main(String[] args)
	{
		String pattern = "yyyy/MM/dd";
		DateFormat df = new SimpleDateFormat(pattern);
		Scanner s = new Scanner(System.in);
		
		Date inDate = null;
		
		System.out.println("��¥�� "+pattern+"�� ���·� �Է����ּ���.");
		
		while(s.hasNextLine()) //�޾ƿ� ���ڰ� �ִ��� Ȯ���ϴ� �� Scanner�� ��Ű���� �����Ե� ��.
		{
			try{
				inDate = df.parse(s.nextLine());	//���� �Է��� ���� Date���·� �޾Ƽ� inDate�� ����
				break;
			}catch(Exception e){
				System.out.println("��¥��"+pattern+"���·� �ٽ� �Է����ּ���.");// ���������ƴ� �ٸ��ɷ� ǥ���� ��� �˸��� �������� �Է��ش޶�� ��û�ϴ� ��.
			}
		}//while
		
		Calendar cal = Calendar.getInstance(); //Calendar Ŭ������ ��ü�� �����ϴ� ���. new�� �Ⱦ�! ����
		cal.setTime(inDate);
		Calendar today = Calendar.getInstance();
		long day = (cal.getTimeInMillis() - today.getTimeInMillis())/(60*60*1000);
		
		System.out.println("�Է��Ͻ� ��¥�� �����"+day+"�ð� ���̰� �ֽ��ϴ�.");
		s.close(); //scanner������ �ݾ��ִ�....
	}//main
}
