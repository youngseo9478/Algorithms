package day10_7;

/*���ν������ ���꽺����� ������
 * ���ν����尡 �׾ ���꽺���尡 ������ ���������� ��� ������
 * ������ ������ ���꽺���嵵 �װ��Ҷ��� Demon ��� 
 * �ΰ����α���� �����带 ����ؼ� ����ڴ�->���ν����� ������ �ڵ����� ������*/
public class DemonThreadEx implements Runnable {

	static boolean autoSave = false;

	public static void main(String args[]) {
		Thread t = new Thread(new DemonThreadEx());
		t.setDaemon(true); //���ν����尡 ������ ���꽺���嵵 ������ ��.
		t.start(); // t, main ������ �ΰ��� ���ÿ� ���� �ְԵ�

		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
			}
			System.out.println(i);

			if (i == 5) {
				autoSave = true;
			}
		}
		System.out.println("���α׷��� �����մϴ�.");
	}//main
	
	public void run()
	{
		while(true)
		{
			try{
				Thread.sleep(3*1000); //3�ʸ���
			}catch(InterruptedException ie){}
			
			if(autoSave)
			{
				autoSave();
			}
		}
	}//run
	
	public void autoSave()
	{
		System.out.println("�۾������� �ڵ�����Ǿ����ϴ�.");
	}
}
