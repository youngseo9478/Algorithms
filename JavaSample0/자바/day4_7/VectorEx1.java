package day4_7;
/*##Vector##
 * ������ �����ڿ��� */
import java.util.*;
import static java.lang.System.out;

public class VectorEx1 {

	public static void main(String[] args)
	{
		Vector<Double> v = new Vector<Double>(2,5); //ó������ 2��¥�� �迭�� �Ҵ��ϴµ� ������ �����ϸ� 5���� �߰���Ű�� ��
		
		v.add(100.2);
		v.add(3.14); //��������� capacity = 2
		v.add(1000.0); //�� �������� v�� ũ�Ⱑ Ŀ���� �� ->5�� ������ �� ���� -> ���� capacity = 7
		
		for(Double n : v)
		{
			out.println(n);
		}
		
		double search = 1000.0;
		int index = v.indexOf(search); //search���� ����ִ� �ε��� ���� �����ϴ� �޼ҵ�
		
		if(index != -1)
		{
			out.println("�˻����"+search+"�� ��ġ : "+index);
		}else
		{
			out.println("�˻����"+search+"�� �����ϴ�.");
		}
		
		out.println("::::::::::::::: ������ �뷮/ũ�� :::::::::::::::");
		out.println("capacity : "+v.capacity()); //capacity() ������ �� �ִ� �뷮�� ũ��
		out.println("size : "+v.size()); //size() �� �ȿ� �����ִ� ��ü(����)�� ��
		
		double del= 3.14;
		if(v.contains(del))
		{
			v.remove(del);
			out.println(del+" �����Ϸ�!!!");
		}
		
		out.println("::::::::::::::: ������ �뷮/ũ�� :::::::::::::::");
		out.println("capacity : "+v.capacity());
		out.println("size : "+v.size());
		
		v.trimToSize(); //���� ����ϴ� ���� �ܿ� ���� ���� ������ �ڸ��� ��.(�޸��Ҵ�����)
		out.println("::::::::::::::: �뷮 ���� �� �뷮/ũ�� :::::::::::::::");
		out.println("capacity : "+v.capacity());
		out.println("size : "+v.size());
	}
}
