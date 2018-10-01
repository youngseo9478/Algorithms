package day11_7;

interface MyFunction
{
	void run(); //public abstract void run();
}

public class LambdaEx1 {

	static void execute(MyFunction f)
	{//�Ű������� Ÿ���� MyFunction�� �޼���
		f.run();
	}
	
	static MyFunction getMyFunction()
	{//��ȯ Ÿ���� MyFunction�� �޼���
		MyFunction f = () -> System.out.println("f3.run()");
		return f;
	}
	
	public static void main(String[] args)
	{
		//���ٽ����� MyFunction�� run()�� ����
		MyFunction f1 = () -> System.out.println("f1.run()");
		
		//�͸�Ŭ������ run()�� ���� =>�̰� ���ٽ��� �̿��ϸ� ����ó�� ���� �� ������ ���ؼ� �����ִ� ��
		MyFunction f2 = new MyFunction() {
			public void run()
			{
				System.out.println("f2.run()");
			}
		};
		
		MyFunction f3 = getMyFunction();
		
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1); 
		//f1��ü�� �ᱹ MyFunctionŬ������ ��ü�̹Ƿ� ���� �޼ҵ带 �����ϰԵ�
		execute( ()->System.out.println("run()"));
		/*�ƹ��͵� ������ �ʾƵ� MyFunctionŬ������ �������̽��� ������ ���� �����ε� 
		 * �� ��ü�� �Ű������� �޴� execute�� �����ϸ� �翬�ϰ� �� ��ü�� run()���� 
		 * ���� ������ �ϰԵ� => run()�� ����Ʈ�ϴ°� run()�޼ҵ��� ���ΰ�!*/
	}
}
