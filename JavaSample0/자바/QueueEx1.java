package day5_7;
/**********LinkedList***********/
/*���ð� �ٸ��� ������� ������� ��µȴ�.*/
import java.util.LinkedList;
public class QueueEx1 {
	public static void main(String[] args)
	{
		String[] strArr = {"��Ʈ��","�ڵ���","TV","����Ʈ��"};
		LinkedList<String> llist = new LinkedList<String>();
		
		for(String item : strArr)
		{//�迭�� �־��� ������ ��ũ�帮��Ʈ�� �ϳ��� �־��ִ� ����
			llist.offer(item);// �������� �߰��ϴ� �޼ҵ�
		}
		System.out.println("queue size : " + llist.size());
		String data = ""; //data ���� �����ϸ鼭 �ʱ�ȭ
		while((data=llist.poll())!=null) //���� �ϳ��� ������ �޼ҵ�
		{//�������� �����ʴٸ� ��� �ݺ��ϴ� ��. ->ť���� ��� ������ �������� break�Ѵٴ� ��
			System.out.println(data);
		}
		System.out.print("======��� poll()�� ��======\n");
		System.out.println("queue size : "+llist.size());
	}
}
