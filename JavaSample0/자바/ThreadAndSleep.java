package day10_7;
/*sleep�� static�޼ҵ�
 * =>�տ� ���� �Ե� ���� �������� �����带 ����Ŵ!*/
public class ThreadAndSleep {

	public static void main(String args[])
	{
		ThreadEx12_1 th1 = new ThreadEx12_1();
		ThreadEx12_2 th2 = new ThreadEx12_2();
		
		th1.start();
		th2.start();
		
		//������ start���Ѽ� ��Ƽ������ ���������� ���� runnable�����̱� ������ ���� �������� ������� main!
		try{
			//2�� ����ϴµ� th1�� ����϶�°� �ƴ�! ���� �������� �����带 ����϶� ��!
			th1.sleep(2000);  
			//������ ���⿡�� th1�� ���� �ʰ� ���� �� ������ ��� sleep�� main�� �� ���̱� ������ main�� ���� �ʰ� ����ȴ�
		}catch(InterruptedException ie){}
		
		System.out.print("<<main ����>>");
	}//main
}

class ThreadEx12_1 extends Thread
{
	public void run()
	{
		for(int i=0; i<300; i++)
		{
			System.out.print("-");
		}
		System.out.print("<<th1 ����>>");
	}//run
}

class ThreadEx12_2 extends Thread
{
	public void run()
	{
		for(int i=0; i<300; i++)
		{
			System.out.print("|");
		}
		System.out.print("<<th2 ����>>");
	}//run
}