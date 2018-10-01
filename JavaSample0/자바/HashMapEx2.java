package day5_7;
import java.util.*;
public class HashMapEx2 {

	public static void main(String[] args)
	{
		//generic�����༭ ������
		HashMap map = new HashMap();
		map.put("myId", "1234");
		map.put("asdf", "1111"); //Ű���� Set���¶� �ߺ������� �Ұ���
		map.put("asdf", "1234"); //���� Ű���� �������Ƿ� ���� ����. �׷��� �ڿ� value�� ����(����)
		//���Ͱ��� �����߱⶧���� asdf�� ��й�ȣ�� 1234���� �´°�.

		Scanner s = new Scanner(System.in); //ȭ�����κ��� ���δ����� �Է¹޴´�.
		
		while(true)
		{
			System.out.println("id�� password�� �Է����ּ���. ");
			System.out.print("id : ");
			String id = s.nextLine().trim();
			
			System.out.print("password : ");
			String password = s.nextLine().trim();
			System.out.println();
			
			if(!map.containsKey(id)) //����Ǿ��� ���� ���̵� �Է����� ���
			{
				System.out.println("�Է��Ͻ� id�� �������� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
				continue; //�Ʒ������� ���������ʰ� �ٽ� while���� ó���κк��� ������
			}
			else
			{//���̵�� �����ϳ�
				if(!(map.get(id)).equals(password)) //map.get(id)���ϸ� id�� �ش��ϴ� �� �� ��й�ȣ�� ����
				{//��й�ȣ�� �߸��� ���
					System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
				}
				else
				{//��й�ȣ�� �´� ���
					System.out.println("id�� password�� ��ġ�մϴ�.");
					break; //��ġ�ϴ� ���̵�� �н����� �Է¹����� while�� ����
				}
			}
		}//while ��
	}//main ��
}
