package day3_7;
/*random()���� �� ���� ���� �߻���Ű�� ���
 * 
 * seed ->������ � ���ؿ� ���� ...*/

import java.util.Random;
import static java.lang.System.out;

public class RandomClassEX1 {

	public static void main(String[] args)
	{
		String[] lesson = {"Java Beg","JSP","XML&Java","EJB"};
		Random r1 = new Random();
		
		int index = r1.nextInt(4);	//nextInt(n)->0~n-1������ ���� �߿� ���� ��
		out.println("���ð��� "+lesson[index]);
	}
}
