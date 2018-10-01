package day4_7;
import java.util.*;
public class HashSetEx3 {

	public static void main(String[] args)
	{
		HashSet set = new HashSet();
		//���ڿ� "abc"�� ���� �ؽ��������� �ѹ��� ����(�ߺ��������� �ʴ� set�� Ư��)
		set.add("abc");
		set.add("abc");
		//������� ���·� ��ü�� �����ϸ� �ּҰ��� ���� �ٸ���. 
		//�ּҰ��� �ٸ��� hash�� �ٸ��� ���´�.
		set.add(new Person("David",10));
		set.add(new Person("David",10));
		
		System.out.println(set);
		//��ü�� print�޼ҵ忡 �����ָ� toString�� ���� ���ǵ� ���¿� �°� ��µȴ�.
	}
}

class Person
{
	String name;
	int age;
	
	Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	//toString �������̵�(������)->������º���
	public String toString()
	{
		return name +" : "+age;
	}
}
