package com.ex;

public class VariableEx2 {		// ������ ���� byte, short, int, long ����

	public static void main(String[] args)
	{
		byte bValue = 122; //1byte
		System.out.println("bValue="+bValue);
		
		/*bValue = 128;
		System.out.println("bValue="+bValue);*/  //�̰Ŵ� ������ 1����Ʈ�� -128~127������ ����! ������ ������� short���δ� ����
		
		short sValue = 128; //2byte
		System.out.println("sValue="+sValue);
		
		//sValue = 40000;	�̰ŵ� �Ұ��� short�� 2����Ʈ�ϱ�
		
		int iValue =40000;  //4byte
		System.out.println("iValue="+iValue);
		
		//iValue=50000L; ���⼭ �빮�� L�� ���� ���� iValue�� int���ε� ������ ǥ���϶���ϴϱ� ���� 
		
		long lValue = 50000L;  //8byte
		System.out.println("lValue="+lValue);
		
		short a = 10;
		short b = 20;
		//short c= a + b; //���� ����� �ʾҴµ� ������ ��.. ��Ģ������ �ϸ� int������ �ٲ� int�� �ٲ�� short�� ����������!! ����!
		
		short c = (short)(a+b); //�̷��� �ϸ� short������ ǥ���ϴ°ŷ� �ٲ��� ���� ->��ġ�� ������ �׳� int������ �����ϴ°� ����
	}
}
