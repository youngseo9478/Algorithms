package com.ex;

public class VariableEx1 {
	public static void main(String[] args)
	{
		char c = 'a';	//������ ���� ����
		System.out.println(c);
		System.out.println("c : "+c); //�ڹٿ��� +�� ���ڿ��� ���̴°�. �ڹٿ����� ������ �Է°������� �̰��� ���ڿ��� ���ο��� �ٲٰ� ��(���ڵ���������)
		int b =22;	//������ ���� ����
		System.out.println("c:"+c+", b:"+b);

		System.out.printf("%d",  b);  //c���� ���� ���ĵ� �����ϴ�
		
		char c2 = 65 ;//�������ε� �� ���ڸ� �ֳ�? -> 65�� �ƽ�Ű�ڵ�� A�� ��Ÿ����. 
		System.out.println("c : " +c2);
		
		boolean bValue;	//���� ���� ����
		bValue = true;
		System.out.println(bValue);
		bValue = false;
		System.out.println(bValue);
	}

}
