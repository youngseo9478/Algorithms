package com.ex;

public class OperationEx4 { //�������ڴ� ������ �����Ѵ�.

	public static void main(String[] args)
	{
		int a=22;
		int b=20;
		int c=10;
		
		boolean d  = a>b && a>c;
		System.out.println(d);
		
		d = b>c && a<c;
		System.out.println(d);
		
		d = b>c || a<c;
		System.out.println(d);
		
		d = a<b || a<c;
		System.out.println(d);
		
		System.out.println(!d);	//!�� �ݴ밪�� �ǹ�
	}
}
