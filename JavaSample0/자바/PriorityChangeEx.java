package day10_7;
/*CPU�� ���� ���ټ��� ���ð��� ���ؼ� �켱������ �ִ� ��*/

class SuperThreadPriority extends Thread
{
	public SuperThreadPriority(String threadName)
	{
		super(threadName);
	}
	
	public void run()
	{
		for(int i=0; i<100; i++)
		{
			try{
				sleep(500);
			}catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
			System.out.printf("������ �̸� : %s %n", Thread.currentThread().getName());
		}
	}
}

public class PriorityChangeEx extends SuperThreadPriority{

	public PriorityChangeEx(String threadName)
	{
		super(threadName);
	}
	
	public static void main(String arg[])
	{
		//���⼭�� 100���� �� ���� ���̰� ũ�� ��Ÿ���� ������ Ƚ���� ���� Ŀ���� ����ؼ� ������� �ι�° �����尡 �� ���� ������ Ȯ���غ� �� �ִ�.
		Thread t1 = new SuperThreadPriority("ù��° ������");
		t1.setPriority(1); //�̷��� ���ڷ� �־ �ǰ� �������(���)�� �־ �ǰ�
		t1.start();
		
		Thread t2 = new SuperThreadPriority("�ι�° ������");
		t2.setPriority(Thread.MAX_PRIORITY);
		t2.start();
	}
}
