package day4_7;
/*ArrayList(Collection<? extends E> c)
Constructs a list containing the elements of the specified collection, in the order they are returned by the collection's iterator.
���� �ݷ��� Ÿ�����ε� ����Ʈ�� �޴´ٴ� �ǹ�.
 * 
 * �迭����Ʈ ���� �迭����
 * 
 * 
 * ###List Interface###
 * �迭�̶��� �ٸ��� �������� �����ε� ����� �����ϴ�.
 * Resizable-array implementation of the List interface.*/

import java.util.*;

public class ArrayListEx1 {

	public static void main(String[] args)
	{
		ArrayList list1 = new ArrayList(10); 
		//�̰� ��������� ��ü�� ������ �� (��Ȯ�� ���ϸ� ������ �ƴ����� 5,4,2,0,1,3�� ���� list1�� ���� ����)
		//��������� ��ü�� �����߱⶧���� ������� ������� ����.
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4)); //subList(fromindex, toindex) 1,2,3�� �ش��ϴ� �κи� �ڸ���
		print(list1, list2); //print()�޼ҵ忡 ��ü�� ������ toString���� �������� ���ǵ� ���·� ��µȴ�.
		
		System.out.println("list1.containsAll(list2) : "+list1.containsAll(list2)); //containsAll()�� ���ϰ��� true/false
		
		list2.add("B");
		list2.add("C");
		list2.add(3, "A"); //3��° �ڸ����ٰ� A�� �־�� -> ���� B,C������ ���µ� A������ �ϳ��� �ڷ� �и� ->������ �������� ��ȿ������ ���
		print(list1,list2);
		
		list2.set(3,"AA"); //������ index 3���� ���� A���µ� set() �޼ҵ� ���� �߰��� AA�� ���°� �ƴ϶� ������ �ִ��ſ� ���� ������.=>##�����Ҷ����##
		print(list1,list2);
		
		//list1���� list2�� ��ġ�� �κи� ����� �������� �����Ѵ�.
		System.out.println("list1.retainAll(list2): "+list1.retainAll(list2));
		print(list1,list2);
		
		//list2���� list1�� ���Ե� ��ü���� �����Ѵ�.
		for(int i = list2.size()-1; i>=0;i--) //size()�� �迭���� ���� ������ ��Ÿ�� index���� ǥ���Ϸ��� -1�ؼ� ����ؾ���.
		{/*###for�� index �������ý� ���ǻ���!!###
		for�� �ȿ��� �ε��� ���� �ʱ�ȭ�� 0�����ؼ� �պ��� ���ϰ� �����ϰԵǸ� �ڿ��ִ� ������ ������
		������� �Ǵµ� �̷��� �Ǹ� �������� �ι�°�� �ִ� ���� ù��°�� ������ �ι�° ���Ҷ��� �� ���� �ǵ����� �ʰ� �� ���� ��(��������°)
		�� ���ϰ� �ȴ�. 
		##�׷��� ���� ���ϰ� ������ index�� �ڿ������� �����ؾ� �Ѵ�.##*/ 
		
			if(list1.contains(list2.get(i))) //list2���� list1�� ���Ե� ��ü���� �����Ѵ�.
			{/*get(index) �� index�� �ش��ϴ� ���� �������� ��*/
				list2.remove(i);
			}
		}
		print(list1,list2);
	}//main��
	
	static void print(ArrayList list1, ArrayList list2)
	{
		System.out.println("list1 : "+list1);
		System.out.println("list2 : "+list2);
		System.out.println();
	}
}//class��
