package day10_7;
/*
 * runnable interface�� run() ���� ����
 * implements ���Ѽ� 
 * Ŭ�������� run()�� �����ؼ� ������ ������*/
public  class SingleRunnableEx implements Runnable{

	private int temp[];
	
	public SingleRunnableEx()
	{
		temp = new int[10];
		for(int start = 0; start<10; start++)
		{
			temp[start] = start;
		}
	}
	
	public void run() {
		for(int start : temp)
		{
			try{
				//���� ��  ���α׷��� �����带 ���ߴ� ���� �ƴ϶� ���� run�� �������� �����带 ���ߴ� ��. 
				Thread.sleep(1000);
			}catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
			System.out.printf("������ �̸� : %s,", Thread.currentThread().getName());
			System.out.printf("temp value : %d %n",start);
		}
	}
	
	public static void main(String[] args)
	{
		//SingleRunnableEx Ŭ������ ��ü�� ������ ���� 
		SingleRunnableEx srt = new SingleRunnableEx();
		//Thread ��ü�� �����ؼ� SingleRunnalbleEx ��ü�� �����ش�.
		Thread t = new Thread(srt,"ù��°");
		t.start();
	}
}
