package day10_7;

import javax.swing.JOptionPane;

public class InterruptedEx {

	public static void main(String[] args) throws Exception
	{
		ThreadEx13 th1 = new ThreadEx13();
		th1.start();
		
		String input = JOptionPane.showInputDialog("�ƹ����̳� �Է��ϼ��� ");
		System.out.println("�Է��Ͻ� ���� "+input+"�Դϴ�.");
		th1.interrupt(); //interrupt()ȣ���ϸ� interrupted���°� true�� �ȴ�.
		System.out.println("isInterrupted():"+th1.isInterrupted()); //true
	}
}

class ThreadEx13 extends Thread
{
	public void run()
	{
		int i = 10;
		
		while(i!=0 && !isInterrupted()) //0�̾ƴϰ�,interrupted���°� �ƴҶ� �����Ѵ� ��
		{
			System.out.println(i--);
			/*for(long x=0; x<2500000000L;x++); //�ð�����*/
			try
			{
				Thread.sleep(1000);
			}catch(InterruptedException ie){ 
				//interrupted ���¶��(true���) catch���� ������ {}���� ������ �����ϰԵǴµ� 
				//{}�� �����ϰ��� �ٽ� interrupted ���°� �����Ǿ ��� ī��Ʈ�ٿ��� ����ȴ�.
				//�׷��� ����� ���ͷ�Ʈ�� ó���Ϸ��� �ٽ� ���ͷ�Ʈ�� �ɾ��־ true���� �־��ָ� �����ϰ� �ȴ�.
				
				//System.out.println("Interrupted �߻�");
				interrupt();
			}
		}
		System.out.println("ī��Ʈ�� ����Ǿ����ϴ�.");
	}
}
