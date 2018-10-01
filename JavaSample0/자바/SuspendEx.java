package day10_7;
/*suspend�� ��� �ߴ��ϴ°ǵ�
 * �������¿� ���� �� �ֱ⶧���� ������� ����
 * ��� ���� ����� �� �ִ�.*/


//�������� ��� �޶��� ����! 
class RunTimeEx implements Runnable
{
	boolean suspended = false;
	boolean stopped = false;
	
	public void run()
	{
		while(!stopped)//stop���� �ʾ����� ��� ����
		{
			if(!suspended)//suspend�� �ɷ����� if���� ���� ����X ->�ɸ� �ð����� ���� ���� �� ->�ڱⰡ �ƴϸ� �ٸ������忡�� ������ �Ѱ���� ��¥ suspend�ε� ���������� �ڵ�!
			{
				System.out.println(Thread.currentThread().getName()); //���籸�����ν������� �̸�
				try{
					Thread.sleep(1000); //���籸������ �����带 1�ʰ� ����ξ��->suspend�ɾ 1�� �����ٰ� �ɸ��� �� !! �̰� �ذ����� �ڵ尡 suspendEx2
				}catch(InterruptedException ie){}
			}
		}
		System.out.println(Thread.currentThread().getName()+"-stopped");
	}
	
	public void suspend() {suspended = true;}
	public void resume() {suspended = false;}
	public void stop() {stopped = true;}
}

public class SuspendEx {

	public static void main(String [] args)
	{
		RunTimeEx r1 = new RunTimeEx();
		RunTimeEx r2 = new RunTimeEx();
		RunTimeEx r3 = new RunTimeEx();
		
		//RunTimeEx�� ��ü�� Thread�� �ްԵ�
		Thread th1 = new Thread(r1,"*");
		Thread th2 = new Thread(r2,"**");
		Thread th3 = new Thread(r3,"***");
		
		//�� 4���� �����尡 �۵����ΰ� 
		th1.start();
		th2.start();
		th3.start();
		
		try{
			Thread.sleep(2000); //���籸������ �����带 ������� ->������ Ȯ���� ŭ
			r1.suspend(); //th1.suspend()�� �ƴԿ� ����!!
			Thread.sleep(2000);
			r2.suspend();
			Thread.sleep(3000);
			r1.resume();
			Thread.sleep(3000);
			r1.stop();
			r2.stop();
			Thread.sleep(2000);
			r3.stop();
		}catch(InterruptedException ie){}
	}
}
