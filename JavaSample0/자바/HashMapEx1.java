package day5_7;
/****Map****/
import java.util.*;
import static java.lang.System.out;
public class HashMapEx1 {

	public static void main(String[] args)
	{
		String[] msg = {"Berlin","Dortmund","Frankfurt","Gelsenkirchen","Hamburg"};
		
		HashMap<Integer,String> map = new HashMap<Integer,String>(); //�ؽ��� ����
		
		//Ű���� ���۵� 0���� �־���, length = 5
		for(int i=0; i<msg.length;i++)
			map.put(i, msg[i]);//Ű���� �����Ͱ��� ������ �ʿ� ����
		
		//Ű�� ��Ÿ��, keySet()�� �ʿ� ����� ��� Ű���� �������� ��.
		Set<Integer> keys = map.keySet();
		//out.println(map.keySet());
		for(Integer n : keys)
		{//Ű���� n�� ����
			out.println(n+"."+map.get(n)); //�ش� Ű���� ������ �ʿ��� �о����
		}
		
	}
}
