package day3_7;
/*enum�� ������� ��Ƽ� �� �� ���
 * ���� �ڹٿ����� ������ final �ٿ��� �������� ��.
 * final int MAX = 100; �̷�������!
 * �ٵ� ������� �������� �̷��� ���� ������
 * [Access Modifier] enum [enum name]{
 * Constant1, constant2...} �̷��� ����
 * 
 * GUI������ ����� ���� ���� ����
 * �������� ������
 * �׳� 0,1,2�� �ϸ� �װ� �������� �𸣰ڴ°�찡 ���⶧���� �̷��� ����� ����� �ִ� ���� ���ϴ�.
 * Ÿ���� ������ ��!
 * */

enum mouse 
{
	LEFT_CLICK, RIGHT_CLICK, DOUBLE_CLICK	//0,1,2�� �Ǵ� ��
}

enum result
{
	RESULT_OK, RESULT_CANCEL, RESULT_ERROR
}

public class EnumEx1 {

	public static void main(String[] arsg)
	{
		System.out.println(mouse.LEFT_CLICK);
		mouse e = mouse.LEFT_CLICK;
		switch(e)
		{
		case LEFT_CLICK:
			System.out.println("mouse left click");
			break;
		case RIGHT_CLICK:
			System.out.println("mouse right click");
			break;
		}
		System.out.println("LEFT_CLICK�� ���� ��:"+e.ordinal());//.ordinal�� ���� ��Ÿ���� ����
		System.out.println("DOUBLE_CLICK�� ���� ��:"+mouse.DOUBLE_CLICK.ordinal());//�̷����Ҽ����ִ�.
		
		mouse[] numbers = mouse.values();//�Ѳ����� ������ ���
		for(mouse m : numbers)
		{
			System.out.println(m.ordinal()); 
		}
	}
}
