package day30;
class Product
{
	int price;	//��ǰ����
	int bonusPoint;//��������Ʈ
	
	Product(int price)
	{
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
	
}

class Tv extends Product
{
	Tv()
	{//����Ŭ������ ������ Product(int price)�� ȣ���Ѵ�.
		super(100); //Tv�� ������ 100�������� �Ѵ�.
	}
	
	public String toString()
	{//ObjectŬ������ toString()�� �������̵��Ѵ�(������)
		return "Tv";
	}
}

class Computer extends Product
{
	Computer()
	{
		super(200);
	}
	
	public String toString()
	{
		return "Computer";
	}
}

class Audio extends Product
{
	Audio()
	{
		super(50);
	}
	public String toString()
	{
		return "Audio"; 
	}
}

class Buyer	//��
{
	int money =1000;//������
	int bonusPoint = 0;//���ʽ������ʱ�ȭ
	Product[] item = new Product[10]; //������ ��ǰ�� �����ϱ� ���� �迭
	int i=0;
	
	void buy(Product p) //������** p�� ����·� ������ �𸣴µ� �̷��� ������ ��������� �� �� ����
	{
		if(money<p.price)
		{
			System.out.println("�ܾ��� �����Ͽ� ������ �� �� �����ϴ�.");
			return ;
		}
		
		money -= p.price;	//���� ������ ������ ��ǰ�� ������ ����.
		bonusPoint +=p.bonusPoint;
		item[i++]=p;
		System.out.println(p+"��/�� �����ϼ̽��ϴ�.");
	}
	
	void summary()				// ������ ��ǰ�� ���� ������ ����ؼ� �����ش�
	{									
		int sum =0;				//������ ��ǰ�� �����հ�
		String itemList ="";	//������ ��ǰ ���
		
		//�ݺ����� �̿��ؼ� ������ ��ǰ�� �� ���ݰ� ����� �����.
		for(int i=0; i<item.length;i++)
		{
			if(item[i]==null) break;
			sum+=item[i].price;
			itemList += item[i]+",";
		}
		System.out.println("�����Ͻ� ��ǰ�� �� �ݾ��� "+sum+" �����Դϴ�.");
		System.out.println("�����Ͻ� ��ǰ�� "+itemList+"�Դϴ�.");
	}
}


public class PolymorphismGeneric {

	public static void main(String[] args)
	{
		Buyer b = new Buyer();
		b.buy(new Tv());	//���������� �ڽ�Ŭ������ Tv�� �θ�Ŭ������ Product�� ������.
		b.buy(new Computer());	//���� buy�޼ҵ屸���� ���� Product p = new Tv(); ���¸� ���´ٴ� �� �� �� �ִµ� �̰� �ٷ� �������̴�.
		b.buy(new Audio());
		b.summary();
		System.out.print("=========================");
		System.out.println();
		System.out.println("���� ���� ���� "+b.money + "�����Դϴ�.");
		System.out.println("���� ���ʽ� ������ "+b.bonusPoint + "���Դϴ�.");
	}
}
