package com.ex;

public class OperationEx3 {	//�񱳿����ڴ� true, false�� return ����
	public static void main(String[] args)
	{
		boolean bValue;
		
		int a=10;
		int b=5;
		int c=5;
		
		bValue = a<b;
		System.out.println(bValue);

		bValue = a>b;
		System.out.println(bValue);
		
		bValue = c<=b;
		System.out.println(bValue);
		
		bValue = a>=b;
		System.out.println(bValue);
		
		bValue = a==b;
		System.out.println(bValue);
		
		bValue = a!=b;	//a,b�� ���� �ٸ��ĸ� ���� �� 
		System.out.println(bValue);
	}

}
