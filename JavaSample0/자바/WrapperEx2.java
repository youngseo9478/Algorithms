package day29;


//parse�� �ַξ�
public class WrapperEx2 {

	
	public static void main(String[] args)
	{
		int i = new Integer("100");//�̰� ��ü ������ �³��� ..? �տ��� Ŭ���� �̸��� �ƴ϶� �׳� ���������ε�..
		int i2 = Integer.parseInt("100"); //10,11������� ���� (����ڽ̰���ã�ƺ���)
		Integer i3 = Integer.valueOf("100");	//�Ͻ���������	//IntegerŬ������ valueOf(String s)�޼ҵ带 �̿��� ���ڿ�"100"�� ���ڷ� ǥ���Ѱ� i3�� �ִµ�...
		//�Ͻ����� ������ ���δ� String str = "������"; ->�̰͵� ��Ʈ�� Ŭ������ �������� str�̶�� ��ü������°ǵ� new�� ���� �ʾ���!
		//���� ���µ� �̿� ���� �Ͻ����� ���·� �����ڸ� ������ ��! �������� ����� int������ �����Եǰ� �� �������� i3�� ���ԵǴ� ��.
		int i4 = Integer.parseInt("100",2);
		int i5 = Integer.parseInt("100",8);
		int i6 = Integer.parseInt("100",16);
		int i7 = Integer.parseInt("FF",16);
		
		int i8 = Integer.valueOf("100",2);
		int i9 = Integer.valueOf("100",8);
		int i10 = Integer.valueOf("100",16);
		int i11 = Integer.valueOf("FF",16);
		
		System.out.println(i);
		System.out.println(i2);
		System.out.println(i3);
		
		System.out.println("100(2) ->"+i4);
		System.out.println("100(8) ->"+i5);
		System.out.println("100(16)->"+i6);
		System.out.println("FF(16) ->"+i7);
		
		System.out.println("100(2) ->"+i8);
		System.out.println("100(8) ->"+i9);
		System.out.println("100(16)->"+i10);
		System.out.println("FF(16) ->"+i11);
	}
}
