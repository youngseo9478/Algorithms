package day4_7;
/*colletion ->�ڷᱸ�� ����
 * �ڷᱸ���� ? �����͸� �����ϰ�, ����� �����͸� �ٽ� ����ϴ� ���.
 * �ڷᱸ���� ���忡 ���� ������� '�ڷᱸ��'
 * �� ��Ȳ�� �´� ȿ������ ������ ����� ���� �ʿ��� ����.
 * �ڹٿ����� Object Ÿ���� ����/���� �Ѵ�. -> Ŭ������ ���� ���� Ŭ������ ������Ʈ => �������Ŭ������ ������ ������ �� �ִ�.=>��� ���µ��� �����ϴ�.
 * ���͸� ���ִ� �� =>generic 
 * 
 * Ư�� Ÿ�Ը� �ް� ������ �߰��� �ٸ� Ÿ���� �������� ��� =>�ǵ��� �ٿ� �ٸ� ��.. =>�ذ��ϱ����� �Ѱ��� ����� �Ϲ�ȭ�ϴ� �� (generic)*/

import static java.lang.System.out;

class GenericC<T>
{
	T[] v; //T=>type ���⼭ String �־����ϱ� String���� �ٲ�� ��. =>String�� �� �� �ִ�.
	
	public void set(T[] n)
	{
		v = n;
	}
	
	public void print()
	{
		for(T s:v)
		{
			out.println(s);
		}
	}
}

public class GenericEx1 {

	public static void main(String[] args)
	{
		GenericC<String> gc = new GenericC<String>();
		Integer[] intArr = {1,2,3,4,5,6,7};
		String[] strArr = {"�ȳ��ϼ���","�ݰ����ϴ�","�����Ϸ�Ǽ���"};
		
		gc.set(strArr);
		gc.print();
		System.out.print("===================");
		System.out.println();
		/*������ => String���� Ÿ�� ��ø� ����⋚���� ������ ���� �� ����.
		gc.get(intArr);
		gc.print();*/
		
		//Ÿ�Ը�ø� ���߱⶧���� ������ �ް� ���ڿ��� ���� �� �ִ� ��.
		GenericC gc1 = new GenericC(); //type�� ǥ�� �����ִ� ���
		
		gc1.set(intArr);
		gc1.print();
		System.out.print("===================");
		System.out.println();
		//���ڿ��ε� �̰͵� ������ �� =>������ ��ü �����Ҷ� Ÿ�Ը�ø� ���߱� ����
		gc1.set(strArr);
		gc1.print();
		
	}
}
