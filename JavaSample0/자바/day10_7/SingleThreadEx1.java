package day10_7;
/*********Tread************
 * life cycle�� �ִ�.*/

public class SingleThreadEx1 extends Thread {

	private int[] temp;
	public SingleThreadEx1(String threadname)
	{
		super(threadname);
		temp = new int[10];
		for(int start=0; start<temp.length;start++)
		{
			temp[start] = start;
		}
	}
	
	//Thread Ŭ������ �ִ� run()�� �������̵��ؼ� �� Ŭ�������� �����ϰ� ���� �� ��������
	public void run()
	{
		for(int start : temp)
		{
			try{
				sleep(1000); //sleep(õ����1��) ->�� ���⼭ 1�ʸ� ��� ���ڴٴ� ���ε� try, catch���� �ʿ��ϴ�! ���� ���ȿ� CPU�� ���� �� �ֱ� ����
			}catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
			//currentThread()�� ���� �������� Thread�� �ǹ��ϰ� getName()�� ���� �� Thread�� �̸��� �޾ƿ��� ��.
			System.out.printf("������ �̸� : %s,",currentThread().getName());
			System.out.printf("tmp value : %d %n", start);
		}
		System.out.println("������ ����");
	}
	
	public static void main(String[] args)
	{
		SingleThreadEx1 st = new SingleThreadEx1("ù��°");
		st.start(); //runnable���·� ��� �ߴٰ� �����췯�� ���� ����Ǹ� run()�� ������.
	}
}
