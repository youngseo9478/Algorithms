package day4_7;
import java.util.*;
import static java.lang.System.out;
public class StackEx1 {

	public static void main(String[] args)
	{
		String[] groupA = {"���Ű��ź","�����Ʈ","����","���ѹα�"};
		
		Stack<String> stack = new Stack<String>();//���ڿ��� �� �� �ִ� Stack ��ü�� ����
		for(String n : groupA)
		{
			stack.push(n); //groupA�� ����ִ� ���ڿ����� �ϳ��ϳ� ���ÿ� ����
		}
		while(!stack.isEmpty()) //isEmpty()�� ������� Ȯ���ϴ� �� ������� true, �������� false�ϱ� while�� ���ǹ��� ! �ٿ���
		{
			out.println(stack.pop()); //���ÿ��� ������ ������ �� �����ʹ� ���ÿ��� ���� => ���������� �ݴ�� ���� ##LIFO##
		}
	}
}
