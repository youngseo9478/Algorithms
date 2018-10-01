package day11_7;
/*�Լ����� �Ű������� �����ִ� ���̾ƴ϶� 
 * ����Ǿ���� �Լ��� ���������ν� 
 * ��Ƽ������ ������ �� ����ó���� ��������*/
//ArrayList�� �ᱹ�� �迭����!!
import java.util.*;
public class LambdaEx2 {

	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<10; i++)
		{
			list.add(i);
		}
		//list�� ��� ��Ҹ� ��� =>forEach�� for�� ����� ��.
		list.forEach(i->System.out.print(i+","));
		System.out.println();
		
		//list���� 2�Ǵ� 3�� ����� ����
		list.removeIf(x->x%2==0||x%3==0);
		System.out.println(list);
		//list�� �� ��ҿ� 10�� ���Ѵ�.
		list.replaceAll(i->i*10);
		System.out.println(list);
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
				
		//mpa�� ��� ��Ҹ� {k,v}�� �������� ����Ѵ�.
		map.forEach((k,v)->System.out.print("{"+k+","+v+"},"));
		System.out.println();
	}
}
