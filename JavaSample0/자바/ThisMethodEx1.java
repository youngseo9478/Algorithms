package day29;



public class ThisMethodEx1 {

	String name;
	int age;
	String address;
	
	//�����ڸ� �����ε� ��ų ����
	
	public ThisMethodEx1()
	{
		name = "noname";
		age =10;
		address = "noaddress";
	}
	
	/*public ThisMethodEx1(String name)
	{
		this.name= name;
		age = 10;
		address = "noaddress"
	}  ���� �ڵ�� �ߺ��� �ʹ� ���� �ٿ��ָ� �Ʒ�ó��!*/
	
	
	public ThisMethodEx1(String name)
	{
		this(name,10,"noaddress");	//�ڵ��� �ߺ��� �����ִµ� �����ϴ�
	}
	
	public ThisMethodEx1(String name, int age)
	{
		this(name, age,"noaddress");
	}
	
	public ThisMethodEx1(String name, int age, String address)		//����ٰ��� this(name, age,adress); �̷��Ը� ���� �ȵ�
	{																//���϶�°��� �� �� ���⶧���� ������ ���� Ǯ� ����� �Ѵ�.
		
		this.name= name;
		this.age= age;
		this.address= address;
	}
	
	public void printData()
	{
		System.out.println("name :"+name+", age :"+age+", address :"+address);
	}
	
	
	public static void main(String[] args)
	{
		ThisMethodEx1 t1 = new ThisMethodEx1();
		ThisMethodEx1 t2 = new ThisMethodEx1("kim");
		ThisMethodEx1 t3 = new ThisMethodEx1("lee", 22);
		ThisMethodEx1 t4 = new ThisMethodEx1("choi",33,"seoul");
		
		t1.printData();
		t2.printData();
		t3.printData();
		t4.printData();
		
	}
}
