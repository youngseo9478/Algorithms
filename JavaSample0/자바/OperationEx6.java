package com.ex;

public class OperationEx6 {	//shift ������ (���� �� ���ϴ� ��) ����Ʈ�ϰ� ������� 0���� ä��� ��. �ᱹ 2�ǹ�� ���ϱ� ������� ����
	
	public static void main(String[] args)
	{
		int d =1;
		
		int e= d<<3;	//1���ϱ� 2^3�ѰŶ� ������! ������ �ѹ���Ʈ �����̴�(��ũ���ϴ� ����� �ִ�)
		System.out.println(e);
		
		d=4;
		e=d>>1;	//4�� 2^1�� ������ ��! 4/2�� 2
		System.out.println(e);
		
	}
}
