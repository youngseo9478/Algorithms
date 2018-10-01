package day5_7;
import java.util.*;
public class HashMapEx4 {

	static HashMap phoneBook = new HashMap();
	
	public static void main(String[] args)
	{
		addPhoneNo("ģ��","���ڹ�","010-111-1111");
		addPhoneNo("ģ��","���ڹ�","010-222-2222");
		addPhoneNo("ģ��","���ڹ�","010-333-3333");
		addPhoneNo("ȸ��","��븮","010-444-4444");
		addPhoneNo("ȸ��","��븮","010-555-5555");
		addPhoneNo("ȸ��","�ڴ븮","010-666-6666");
		addPhoneNo("ȸ��","�̰���","010-777-7777");
		addPhoneNo("��Ź","010-888-8888"); //�����ε��صξ����Ƿ� �Ű����� �ΰ�¥���� �޼ҵ�� 

		printList();
	}//main
	
	//�׷��� �߰��ϴ� �޼ҵ�
	static void addGroup(String groupName)
	{
		if(!phoneBook.containsKey(groupName))
			phoneBook.put(groupName, new HashMap());//<k,v>�� v�� �ؽ������� ���� ��.
	}
	
	//�׷쿡 ��ȭ��ȣ�� �߰��ϴ� �޼ҵ�
	static void addPhoneNo(String groupName, String name, String tel)
	{
		addGroup(groupName);
		HashMap group = (HashMap)phoneBook.get(groupName); //get(groupName)�Ѱ��� <k,k,v>���·λ����غ���  <k,v>�� ���ϴ� ��. �� HashMap�� ������
		group.put(tel, name); //�̸��� �ߺ��� �� ������ ��ȭ��ȣ�� key�� �����Ѵ�.
	}
	//addPhoneNo �����ε� ->�Ű����� ������ 2��¥���� �����
	static void addPhoneNo(String name, String tel)
	{
		addPhoneNo("��Ÿ",name,tel);
	}
	
	//��ȭ��ȣ�� ��ü�� ����ϴ� �޼ҵ�
	static void printList()
	{
		Set set = phoneBook.entrySet();//ó�������� entrySet()�� <k,|k,v>�� �ѵ���� ���� �� =>�׷�� �������� ������ ��.
		Iterator it = set.iterator();//�����Ҽ��ִ����·� ����ְ�
		
		while(it.hasNext()) //�׷�� ����ϴ� �ݺ���
		{
			Map.Entry e = (Map.Entry)it.next(); //�� ���� ������ �ƴ϶� entry�������̽��� �����ǰ��ִ� ���� �ּҰ��� ����
			
			Set subSet = ((HashMap)e.getValue()).entrySet(); 
			//e�� �׷��������� ���� �����Ϳ��µ� ���⼭ getValue()���ϸ� <k,|k,v>�� �ڿ�<k,v>�� �ǹ���, �� tel, name
			//�̰� �ٽ� entrySet()���� �����ָ� ���� ��ȭ��ȣ�� �������� �ѵ���� ���°�. '010-111-1111,���ڹ�'�� �ѵ��
			Iterator subIt = subSet.iterator();
			
			//�׷��� �׷쿡 ���� ������ ������ ���
			System.out.println("*"+e.getKey()+"["+subSet.size()+"]");
			//e.getKey()�� �׷���� ��Ÿ�� -> ������ e.getValue()�� tel,name����� ��Ÿ��
			//subSet�� �ش��ϴ� e.getKey�ȿ� ���� e.getValue() ��, '��ȣ,�̸�'����� ����( e.getKey���� �����ִ� ������ �ٸ��� �˱�)
			while(subIt.hasNext())//�׷���� ����(����ó ����)�� ����ϴ� �ݺ���
			{
				Map.Entry subE = (Map.Entry)subIt.next();
				String telNo = (String)subE.getKey();//subE.getKey()�� tel�� ��(���ڿ�)
				String name = (String)subE.getValue(); //subE.getValue()�� name�� �ǹ�(���ڿ�)
				System.out.println(name+" "+telNo); //�̸��� ��ȣ ������ ��µ�
			}
		}
	}//printList()
}//class
