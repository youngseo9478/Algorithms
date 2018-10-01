package day10_7;

//��Ƽ������
class MyRunnableTwo implements Runnable
{
	public void run()
	{
		System.out.println("run");
		first();
	}
	
	public void first()
	{
		System.out.println("first");
		second();
	}
	
	public void second()
	{
		System.out.println("second");
	}
}

public class JoinEx {
	public static void main(String[] args)
	{
		System.out.println(Thread.currentThread().getName()+" start");
		Runnable r = new MyRunnableTwo();
		Thread myThread = new Thread(r);
		myThread.start();
		
		//try�� ������ join�� ���� �ʾҴٸ� ����� main start, main end, run, first, second���̾��� ��
		//�ֳ��ϸ� myTread.start();�ϰ� ��Ƽ �����尡 runnable���¿� ������ ���� �� main������� ���� ���� ������ �ٷ� ����Ǳ⶧����
		//end�� ���� ������ �Ǵ� ���̴�. (���࿡ main���� ������ ����Ǿ��ϴ� ������ ���Ҵٸ� �̿Ͱ��� �۵����� �ʾ��� ��)
		try{
			//join�� CPU�� ��� �ڱ� �����带 ��� �����Ų ������ �ٸ� �����带 �����ϰ� �ȴ�.
			myThread.join();
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" end");
	}

}
