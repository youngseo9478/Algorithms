package day29;
/*����� ��Ʈ���� �������� ��Ʈ�����۰� �� ������! ��Ʈ���� ������ �߸�������ֱ⶧���� �׸�ŭ ���α׷��� ���̴�.�׷��� ����ð��� �����̱⶧���� ��Ʈ���� ũ�Ⱑ ũ�ٸ� ��Ʈ�����۸� ���!!*/
public class StringBufferEx1 {

	
	public static void main(String[] args)
	{
		StringBuffer sb1= new StringBuffer("Sun-Ae");
		StringBuffer sb2= sb1.append("&Kyung-ju"); //sb2��sb1�� �ּҰ��� ���ԹްԵ�
		
		String msg = null;
		
		if(sb1==sb2)
			msg = "sb1�� sb2�� ����";
		else
			msg = "sb1�� sb2�� �ٸ���";
		
		System.out.println(msg);
		msg = sb1.toString();
		System.out.println("sb1: "+msg);
		msg = sb2.toString();
		System.out.println("sb2: "+msg);
	}
}
