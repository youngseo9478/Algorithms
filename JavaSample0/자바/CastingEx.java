package com.ex;

public class CastingEx {
	public static void main(String[] args)
	{
		int aValue = 10;
		float fValue = 3.3f;
		int result = (int)(aValue + fValue); //������ 13.3�ε� int������ ǥ���ؾ��ؼ� .3�սǵ�
		System.out.println(result);
		
		short s1=5;
		short s2=7;
		short s3=(short)(s1+s2);	//��Ģ�����ġ�� ���� int������ �ٲ�ϱ� short���� ���� �� ��� �տ�(short)���̶�� casting���ִ°�!
		System.out.println(s3);
	}

}
