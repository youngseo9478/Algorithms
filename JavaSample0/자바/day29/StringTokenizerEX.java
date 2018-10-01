package day29;

import java.util.StringTokenizer; //��Ʈ����ũ������ ������ �־���ϴ� ��ƿ��Ƽ

public class StringTokenizerEX {

	//printToken�̶�� �޼ҵ带 static���� �������. �ۺ� Ŭ������ ��ü�� ���������� �ʾ����ϱ� static..?
	public static void printToken(StringTokenizer st)
	{ //���⼭�� StringTokenizerEx�� ��ü�� ������ ���� ����->static���� �ϸ� 1.�޸𸮿� ������ �ȴ�. (2.�������� ���� ��)
		
		//hasMoreTokens�� Ŀ�� ���� ��ġ�� �����Ͱ� �ִ��� Ȯ���ϴ� �޼ҵ�.(APIȮ��)
		//���� ��ġ�� �����Ͱ� ������ ��� while�� �ݺ� ������ ������
		while(st.hasMoreTokens())
		{
			String tokenStr = st.nextToken();
			System.out.println(tokenStr)
;		}
	}
	public static void main(String[] args)
	{
		StringTokenizer st1 = new StringTokenizer("Have a good day");
		StringTokenizer st2 = new StringTokenizer("2017/6/29", "/");
		StringTokenizer st4 = new StringTokenizer("2017/6/29", "/",true);
		StringTokenizer st3 = new StringTokenizer("19+28+78+45","+",true);
		
		printToken(st1);
		System.out.println("===============");
		printToken(st2);
		System.out.println("===============");
		printToken(st3);
		System.out.println("===============");
		printToken(st4);
		System.out.println("===============");
	}
}
