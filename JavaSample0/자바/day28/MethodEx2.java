package day28;

class MethodEx{
	int var/*�����忡���� �� �Ʒ��� ���� var�� ��������*/;		//����� 1000�� ������ �˾Ҵµ� 0�� ����. ��?
					//�������� �켱������ �ִ�. -> ��������>��������
					//�ᱹ ��� �ѹ��� ������ �ȵ� ��! �ڹٿ����� int ���·� �����س��� ���� �ȵ��� �׳� 0���� �ʱ�ȭ(����ȭ)��
	public void setInt(int var) //���⼭���� ���۵Ǿ��µ� �Ʒ��� ������ var�� ������������ ���� ����Ѱ�. �ٽ� �����غ���...
	{
		this.var = var; //�̷����ϸ� 1000�� ��µ� 
		
		/*this�� ����
		 * */
		
		//var/*�����忡���� �� ���� var�� ��������*/ = var; 
	}
	
	public int getInt()
	{
		return var;
	}
}

public class MethodEx2 {

	public static void main(String[] args)
	{
		MethodEx me2 = new MethodEx();
		me2.setInt(1000);
		System.out.println("var : "+me2.getInt());
	}
}
