package day10_7;
/*���� Suspend�� ������ ������ ���� �ڵ尡 �ƴ�
 * ��ü���������� �ٲ��� �� �ִ�.
 * */
class SuspendEx2_2 implements Runnable
{
	boolean suspended = false;
	boolean stopped = false;
	
	Thread th;
	
	SuspendEx2_2(String name)
	{
		th = new Thread(this, name); //Thread(Runnable r, String name)
		//���⼭ this�� Runnable�� run()�� ������ ������ �� �ֵ��� �ϱ����� ����� ��.
	}
	
	public void run()
	{
		String name = th.getName();
		
		while(!stopped)
		{
			if(!suspended)
			{
				System.out.println(name);
				try{
					Thread.sleep(1000);
				}catch(InterruptedException ie){
					System.out.println(name+" - interrupted");
				}
			}else{
				Thread.yield();
			}
		}
		System.out.println(name+" - stopped");
	}
	
	public void suspend()
	{
		suspended = true;
		th.interrupt(); //isInterrupted���°� true�� �ȴ�
		System.out.println(th.getName()+" - interrupt() by suspend()");
	}
	
	public void resume()
	{
		suspended = false;
	}
	
	public void stop()
	{
		stopped = true;
		th.interrupt();
		System.out.println(th.getName()+" - interrupt() by stop()");
	}
	
	public void start()
	{
		th.start();
	}
}

public class SuspendEx2
{
	public static void main(String[] args)
	{
		SuspendEx2_2 th1 = new SuspendEx2_2("*");
		SuspendEx2_2 th2 = new SuspendEx2_2("**");
		SuspendEx2_2 th3 = new SuspendEx2_2("***");
	
		th1.start();
		th2.start();
		th3.start();
		
		try{
			Thread.sleep(2000);
			th1.suspend();
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume();
			Thread.sleep(3000);
			th1.stop();
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
		}catch(InterruptedException ie){}
	}
}