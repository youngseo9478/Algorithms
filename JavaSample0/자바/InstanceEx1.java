package day28;

/*�ν��Ͻ�ȭ*/

class Card // Ŭ������ new�� ��� �޸𸮿� �ö����� ������ �޸� ����. �ٵ� ���ܷ� ���� ���� �տ� static���̸�
			// ����Ǿ����� ���� �޸𸮿� �ö������. �ݸ鿡 instance variable�� ��ü�� �����Ǿ�� ����� �� �ִ� ����
{
	static int width; // static ->�������� ���Ǿ����� ����! ->��ü�� �������� ���� �������� ���Ǵ� ���
						// �ʿ��� �� �̷��� ���! ī���� ��� width,height�� �����ϱ� �׳� static �ص� �Ǵ� ��.
	static int height;
	String shape;
	int number;

	public void printCardInfo() {
		System.out.println("width : " + width);
		System.out.println("height : " + height);
		System.out.println("shape : " + shape);
		System.out.println("number : " + number);
	}
}

public class InstanceEx1 {

	public static void main(String[] args) {	//main �޼ҵ�� static�̹Ƿ� �ϳ��� �ִ� �� ,public �̴ϱ� �ƹ��� �������� �� �� �ִ� ��...
		Card c1 = new Card();
		c1.width = 80;		//��� �̰� �ι� ��ġ�� �Ű� ������ Card.width�� ���� ���� 
		c1.height = 120;
		c1.shape = "spade";
		c1.number = 10;

		Card c2 = new Card();
		//c2.width = 90;	->static���� �����f���ϱ� ���� �ʿ� ����.ī���� ũ��� �����ϴϱ�!
		//c2.height = 140;
		c2.shape = "heart";
		c2.number = 3;

		c1.printCardInfo();
		System.out.println("====================================================");
		c2.printCardInfo();

	}
}
