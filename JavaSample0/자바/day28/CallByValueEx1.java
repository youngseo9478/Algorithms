package day28;
/*call by value
 * ���� ���� ���� ������ ������ ���� �ƴ϶� ���纻�� �����ִ� �� .
 * �׷��Ƿ� �� ���� ����ϴ� ������ ���� �ٲ���� ���纻�� �ٲ� �� ������ �ٲ�� ���� �ƴ�*/
public class CallByValueEx1 {

	public static void main(String[] args)
	{
		int value =10;
		int value2 = increaseNum(value);	//���纻�� �־��� �� (��)
		
		System.out.println("value : "+value); //������ �ش��ϴ� ���� ���Ծ��� ���� ������ ����  10
		System.out.println("value2 : "+value2);//���纻�� �̿��� ���ο� ���������� ������ �������� �޾Ƽ� ���Խ����� 11
	}
	
	public static int increaseNum(int num)
	{
		++num;	//value�� �ּҸ� �޾ƿ� ���� �ƴϰ� �׳� ���纻 �� 10�̶�� ���� ������ ��. �������ѵ� ���� value�� ��ȭ��Ű�� ���� �ƴϴ�***
		return num;	//������ 1�� ������Ų ���� ����. �� ���� �޴� ���� �Լ��� ȣ���Ѱ����� value2�� ��.
	}
}
