package day4_7;
/*
 * ###Iterator###
 * public interface Iterator<E>
An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework. 
Iterators differ from enumerations in two ways:

1.Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
2.Method names have been improved.

This interface is a member of the Java Collections Framework.

###iterator()###
Iterator<E> iterator()
Returns an iterator over the elements in this set. 
The elements are returned in no particular order (unless this set is an instance of some class that provides a guarantee).
*/
import java.util.*;
public class HashSetEx4 {

	public static void main(String[] args)
	{
		HashSet setA = new HashSet();
		HashSet setB = new HashSet();
		HashSet setHap = new HashSet();
		HashSet setCha = new HashSet();
		HashSet setKyo = new HashSet();
		
		setA.add("1");	setA.add("2");
		setA.add("3");	setA.add("4");
		setA.add("5");
		System.out.println("A = "+setA);
		
		setB.add("4");	setB.add("5");
		setB.add("6");	setB.add("7");
		setB.add("8");
		System.out.println("B = "+setB);
		
		//�������� A�� B�� ���ÿ� ������ ���Ҹ� ��Ÿ��
		Iterator it = setB.iterator();
		while(it.hasNext())
		{
			Object tmp = it.next();
			if(setA.contains(tmp)) //setB�� ���Ұ� setA�� ���ԵǸ� setKyo�� �ִ°�
				setKyo.add(tmp);
		}
		
		//A-B�� A���� ���Եǳ� B�� ������ �ʴ� ����θ� ��ƾ� �Ѵ�.
		it = setA.iterator();
		while(it.hasNext())
		{
			Object tmp = it.next();
			if(!setB.contains(tmp)) //B�� A�� ���Ҹ� �������� �ʴ� setA�ǿ��Ҹ� setCha�� �־��ش�.
				setCha.add(tmp);
		}
		
		//�������� setA,setB �Ѵ� setHap�� ������ �˾Ƽ� �ߺ��� ���� ������� ����.
		it = setA.iterator();
		while(it.hasNext())
			setHap.add(it.next());		
		it = setB.iterator();
		while(it.hasNext())
			setHap.add(it.next());
		
		System.out.println("A������B = "+setKyo);
		System.out.println("A������B = "+setCha);
		System.out.println("A������B = "+setHap);
	}
}
