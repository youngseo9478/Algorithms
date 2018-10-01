package day5_7;
/*******�������ϸ� ������ ���� ����� �� ���� ����*******/
import java.util.*;
public class HashMapEx5 {

	public static void main(String[] args)
	{
		String[] data = {"A","K","A","k","D","K","A","K","K","K","k","Z","D"};
		
		//������ �ߴ������� generic�� �����־��⶧�� ���� Class AA<T> { T[]~~}�̷������� �����ִµ� <>���� �������ָ� default�� ObjectŸ��!
		HashMap map = new HashMap();
		
		for(int i=0; i<data.length;i++)
		{
			if(map.containsKey(data[i]))
			{
				Integer value = (Integer)map.get(data[i]); 
				map.put(data[i], new Integer(value.intValue()+1)); //���� value�κ��� ���� ��ü�� ����
			}
			else
			{
				map.put(data[i], new Integer(1));
			}
		}
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext())
		{
			Map.Entry entry = (Map.Entry)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey()+" : " +printBar('#',value)+" "+value);
		}
	}//main
	
	public static String printBar(char ch, int value)
	{
		char[] bar = new char[value];
		
		for(int i=0; i<bar.length;i++)
		{
			bar[i] = ch;
		}
		return new String(bar); 
	}
}
