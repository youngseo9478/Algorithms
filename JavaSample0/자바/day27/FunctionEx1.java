package day27;

public class FunctionEx1 {	
	/*�Լ�(method)��?
	 * �Լ��� �츮�� ���� �ְų� ���־��� �� ���𰡸��ؼ� ����� �ټ��� �ְ� ���ټ����ִ� ��..
	 * �ݺ��Ǵ°� �Ѱ��� ��Ƴ��� �ڵ带 ��Ȱ���ؼ� ����� �� �ִ� ��*/
	
	public static void main(String[] args)
	{
		System.out.println(add(10,20));
		System.out.println(add(310,30));
		System.out.println(add(102,2560));
		System.out.println(add(1043,430));
		
		printName("�谡");
	}
	
	public static int add(int a, int b)	//�Լ��� ��忡 �ش�.add�� �Լ���.add�տ� int�� return��. ���⼭ int a,b�� �Ű�����(=���޹�������) 
										//a,b�� �Լ��������� �޸𸮿��� �������� ����(=��������)
	{
		int result = a+b;
		return result;
	}

	public static void printName(String name)		//void�� ���ϰ��� ���ٴ� ��.
	{
		System.out.println("name:"+name);
	}
}
