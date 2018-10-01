package day11_7;
import java.util.function.*;
import java.util.*;


public class LambdaEx3 {

	public static void main(String[] args)
	{
		//supplier�� �Ű������� ���� ���ϰ��� ���� -> �������� ���������� ������ ��
		Supplier<Integer> s = ()->(int)(Math.random()*100)+1;
		
		//consumer�� ���ϰ��� ���� �Ű������� ���� -> �Ű��������� ���������� ������ ��
		Consumer<Integer> c = i -> System.out.print(i+",");
		
		//Predicate�� ���� ���� ������ ���� booleanŸ���� ���ϰ��� �����ִ� ��
		Predicate<Integer> p = i -> i%2==0;  //2�� ����� true�� ����
		
		//Function�� �Ű������� ���ϰ��� ����
		Function<Integer,Integer> f = i -> i/10*10; //�������� 10���� ������ 1���ڸ��� �߸� �ű⿡ 10�� ���ϸ� ó�������� 1���ڸ��� 0���� ���� ���� ����
		
		
		List<Integer> list = new ArrayList<>();
		makeRandomList(s, list);
		System.out.println(list);
		
		printEventNum(p, c, list);
		
		List<Integer> newList = doSomthing(f,list);
		System.out.println(newList);
		//System.out.println(list);
	}
	
	static <T> List<T> doSomthing(Function<T,T> f, List<T> list)
	{
		List<T> newList = new ArrayList<T>(list.size());
		for(T i:list)
		{
			newList.add(f.apply(i));
		}
		return newList;
	}
	
	static <T> void printEventNum(Predicate<T> p, Consumer<T> c, List<T> list)
	{
		System.out.print("[");
		for(T i:list)
		{
			if(p.test(i)) //predicate�� �޼ҵ�� ���ǿ� �´��� �˻��ϴ� �޼ҵ�
				c.accept(i); //consumer�� �ִ� �޼ҵ�� i���� �Ű������� �������� �޼ҵ�
		}
		System.out.print("]");
		System.out.println();
	}
	
	static <T> void makeRandomList(Supplier<T> s, List<T> list)
	{
		for(int i=0; i<10; i++)
		{
			list.add(s.get()); //get()�� supplier�� ���ԵǾ��ִ� �޼ҵ�
		}
	}
}
