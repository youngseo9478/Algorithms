package day29;
/*�����ε� = ��������
 * �����ε��� ��� ��ü���� ���� ����ϹǷ� ������ Ȯ���� �صδ°� ����
 * ���� ����� ���� �޼ҵ带 ���� �ٸ� Ÿ���� �Ű������� �־ ����ǵ��� �������� �������ִ� ��
 * ���߿� ������Ʈ�� �ϴٺ��� ���Ǵ� Ŭ����, �żҵ���� �ſ� ������ �׶����� ��� �޼ҵ���� ����ϱ�� �ʹ� ����� �׷��� �̸��� �����ϰ� �Ű������κи� �ٸ��� ���ָ� 
 * ���� �̸����� ��� ����� �� �� �ִ�.
 * ���� Ÿ�Կ� ����, �Ű������� ������ ����, �� �Ű������� ������ ���� ��� �����Ͽ� ���� �Լ� �̸����� �̿��� �� �ִ�.*/
public class OverloadingEx1 {
	
	public static void getLength(int i)
	{
		String str = String.valueOf(i);
		System.out.println(i+"�� ���ڿ� ���� :" +str.length());
	}
	
	public static void getLength(float f)
	{
		String str = String.valueOf(f); //valueOf�� static Ÿ��!(�����ε��Ǿ�����) ����Ŭ���� Ȯ�ΰ���
		System.out.println(f+"�� ���ڿ� ���� :" +str.length());
	}
	
	public static void getLength(String str)
	{
		System.out.println(str+"�� ���ڿ� ���� :" +str.length());
	}
	
	public static void getLength(int i, float f)		//�ΰ��� �Ű������� ���� �޼ҵ嵵 �����ε����� ���� �� �ִ�.
	{
		String str = String.valueOf(i);
		System.out.println(i+"�� ���ڿ� ���� :" +str.length());
		
		String str2 = String.valueOf(f);
		System.out.println(f+"�� ���ڿ� ���� :" +str2.length());
	}
	
	public static void getLength(float f,int i)	//(����,�Ǽ�)������ (�Ǽ�,����)������ ������ �򰥸� �� �ֱ⶧���� ������ �ݴ밡�ǵ��� �������ָ� ��� ��쿡 ��� ����!
	{
		String str = String.valueOf(i);
		System.out.println(i+"�� ���ڿ� ���� :" +str.length());
		
		String str2 = String.valueOf(f);
		System.out.println(f+"�� ���ڿ� ���� :" +str2.length());		//str2.length()�ΰ� �򰥸��� ����!
	}
	
	public static void main(String[] args)
	{
		getLength(3432.323f);
		getLength("abcdefghijk");
		getLength(1003);
		getLength(322,857.4f);
		getLength(935.5435f,1222);
	}

}
