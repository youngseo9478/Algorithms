package day28;

public class VariableArgumentsEx {

	/*public static int add(int num1, int num2)
	int result = 0;
	return result;*/ //static �ٿ��� ������� �ٷ� ������!//�̷����ϸ� �������� ���� ������
	public static int add(int ...num)
	{
		int result=0;
		for(int i=0; i<num.length;i++)	//�Ű������� ������ �����̵� �迭�μ� �޾Ƽ� ũ�⸦ �� �� ���� �̰� for�� ������ ��� ���� ���� �� �ְԵ�.
		{
			result += num[i];
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println(add(1,2));
		System.out.println(add(1,2,3));	//������ ->The method add(int, int) in the type VariableArgumentsEx is not applicable for the arguments (int, int, int, int, int, int, int)
		System.out.println(add(1,2,3,4));
		System.out.println(add(1,2,3,4,5));
		System.out.println(add(1,2,3,4,5,6));	//���⿡�� ������ �������� �Ű������� �ޱ����� for�������� �� ũ�⸸ŭ ����!
		System.out.println(add(1,2,3,4,5,6,7));		
	}
}
