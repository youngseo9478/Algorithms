package com.ex;

public class OperationEx7 {
	public static void main(String[] args)
	{
		int a=10;
		
		++a;
		System.out.println(a);
		a++;		//������ �Ŀ� a���� 12�� �ٲ�⶧���� ��°��� 11�̶�� ���������� �װԾƴ϶� (�̰��� �����!)
		System.out.println(a);		//���⼭ ����� ��û�ϱ⶧���� ��°��� 11�� �ƴ϶� 12��.
		--a;
		System.out.println(a);		//���� �����ϰ��� 11�ε�
		
		System.out.println(a++);	//���⼭�� 11�� ���� ���Ե� �� �ϳ� �����ؼ� 12�� �Ǵ� ���̹Ƿ� ����� �ϴ� 11
		System.out.println(++a);	//������ a�� 12�� �Ǿ��µ� �� �ϳ� 
		
		//*****************//�߿���!
		a=10;
		int b=++a;	//��ġ ���������ڴ� �켱������ ���� ���Ƽ� =���� ���� ����ȴ�.
		System.out.println(b);
		b= a++;	//��ġ ���������ڴ� �켱������ ���� ��������.�׷��� =�� ������ �Ŀ� ������ �̷������.
		System.out.println(b);
		System.out.println(a);	//()���� b���ƴ϶� a�� ���� ���� a�� 11�̾ƴ϶� 1������ 12���� �� �� �ִ�.
	}

}
