package day3_7;
import java.util.Arrays;
import static java.lang.System.out;
public class ArraysEx1 {
	public static void main(String[] args)
	{
		String[] ar = {"fill()","in","the","Arrays"};
		String[] ar2 = {"fill()","in","","Arrays"};
		if(!Arrays.equals(ar, ar2))
		{
			out.println("�� �迭�� �ٸ��ϴ�.");
			out.println("\n-------------------------------");
		}
		Arrays.fill(ar,"SunAe"); //����� ��ҵ��� ��� SunAe�� ä���.
		for(String n: ar)
			out.print(n+",");
		
		out.println("\n-------------------------------");
		Arrays.fill(ar,1,3,"��"); //1,2�� ��Ʈ�� �ٲٶ�� ��
		for(String n : ar)
			out.print(n+",");
	}

}
