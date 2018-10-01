package day4_7;
/*�͸���Ŭ����
 * ��ü�� �����Ϸ��� ���� �� �ش��ϴ� Ŭ������ �Ϻ��� ���¿�����.->�����Ϸ��� Ŭ���� �̸����� �ö�
 * �Ϻ����� ���� ���¿����� ������ �ϴ� ������ ��ü�� ������->�����Ϸ��� �͸����� �ö�
 * �־���?
 * 1.abstract�� ��ӹ޾Ƽ� �����ؾ��ϴµ� �͸���Ŭ������ �̿��ϸ� ��� �ȹ޾Ƶ� ��� ����.
 * 2.�̷��� �س����� ��ü�� ���ó�� �� �� �ִ�.
 * 
 * =>��Ӿ��� ������·� �� �� �ִٴ� ����
 * */

abstract class TestAbst {
	int data = 10000;

	public abstract void printData(); // abstract method
}

public class AnnonymousInnerEx {

	TestAbst inn = new TestAbst() {
		public void printData() { //�̿ϼ��� ���� �ϼ��Ѵ�.
			System.out.println("data : " + data);
		}
	}; //�����ݷ� �� �������Ѵ�. ������ new TestAbst(); �̰��ε� �̿ϼ��̶� ���⼭ �߰�ȣ�� ���� ���� ���ְ� �ֱ⶧���� �̰� ������ �����ݷ����� �ݾ�����ϴ� ��. 
	
	public static void main(String[] args)
	{
		AnnonymousInnerEx ai = new AnnonymousInnerEx();
		ai.inn.printData(); //inn�̶�°�ü�� ������·� ��������.
	}
}
