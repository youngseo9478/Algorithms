package com.ex;

public class OperationEx8 { //���ǿ�����
	public static void main(String[] args)
	{
		int a =5;
		int b=3;
		
		char c =a>b? 't':'f';	//�������ǽ� a��b���� Ŀ�� ���̹Ƿ� 't'������ ���� c���� �־��ְԵ�
		System.out.println(c);		//������ �������ǽ��� �������� �������⶧���� ��������Ʈ������ ���� �ʴ�...(���߱���..)
		
		c = a<b? 't': 'f'; 
		System.out.println(c);
	}
}
