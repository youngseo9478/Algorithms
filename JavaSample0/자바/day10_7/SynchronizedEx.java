package day10_7;
/*synchronized
 * �� �޼ҵ峪 Ư�� ��Ͽ� �����  �� �ִ�.
 * 
 * */
class ATM implements Runnable
{
	private long depositeMoney = 10000;
	
	public void run()
	{
		synchronized (this)//���� ���� ������ �ϳ��� �� ���� ������� �� �����ϱ� ������ �ٸ� ������� runnable���·� ����Ѵ�.
		{
			for(int i=0; i<10; i++)
			{
				try
				{
					Thread.sleep(1000);
				}catch(InterruptedException ie)
				{
					ie.printStackTrace();
				}
				if(getDepositeMoney() <=0)
				{
					break;
				}
				withDraw(1000);
			}
		}
	}
	
	public void withDraw(long howMuch)
	{
		if(getDepositeMoney() > 0)
		{
			depositeMoney -= howMuch;
			System.out.print(Thread.currentThread().getName()+" , ");
			System.out.printf("�ܾ� : %,d �� %n", getDepositeMoney());
		}
		else
		{
			System.out.print(Thread.currentThread().getName()+" , ");
			System.out.println("�ܾ��� �����մϴ�.");
		}
	}
	
	public long getDepositeMoney()
	{
		return depositeMoney;
	}
}


public class SynchronizedEx {

	public static void main(String[] args)
	{
		ATM atm = new ATM();
		//atm ��ü�� mother, son�� �����Ͽ� ����ϴ� ����! �׷��� synchronized�� �ʿ���
		Thread mother = new Thread(atm,"mother");
		Thread son = new Thread(atm,"son");
		mother.start();
		son.start();
		
	}
}
