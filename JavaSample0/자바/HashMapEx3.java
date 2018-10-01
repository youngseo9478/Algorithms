package day5_7;
import java.util.*;
public class HashMapEx3 {

	public static void main(String[] args)
	{
		//�Ϲ�ȭ �����༭ ������ ��
		HashMap map = new HashMap();
		map.put("���ڹ�", new Integer(90));
		map.put("���ڹ�", new Integer(100));//Ű�� �ߺ��̴ϱ� ���� ���ŵǾ ���ڹ�,100�ȴ�.
		map.put("���ڹ�", new Integer(100));
		map.put("���ڹ�", new Integer(80));
		map.put("���ڹ�", new Integer(90));
		
		Set set = map.entrySet();//entrySet()�ϸ� ������ ����Ǿ��ִ��� �ϳ��� ����ó�� �𿩼� SetŸ���� �ȴ�.
		Iterator it = set.iterator(); //������ ����� iterator()����ϸ� ������ �� �ִ� ���·� �ٲ��.
		
		while(it.hasNext())//iterator���� ¦��ó�� ���̴� �޼ҵ� ���� Ŀ���� ������ �����Ͱ� �ִ��� ������ Ȯ���ϴ� �޼ҵ�
		{
			Map.Entry e; //e�� ��ü�� �ƴ϶� �������� �˾ƾ��Ѵ�. Map.Entry��� �������̽��� �����ϰ��ִ� ��ü�� �ּҰ��� ������ �ִ� ����.
			e = (Map.Entry)it.next();//casting
			System.out.println("�̸� :"+e.getKey()+", ���� :"+e.getValue());//Map.Entry�� ����ִ� method
			//getKey() ->Ű����������, getValue()->value�� ��������
		}
		//������������ set�̶�� ���� �ȿ� entrySet()���·�  Ű���� ������ ����Ǿ��־��µ�
		set = map.keySet(); //keySet()�� �ʿ� ����� Ű���� �������� ������ ���� Ű��(�̸�)�� �����ϰԵ�.
		System.out.println("������ ��� : "+set);//�׷��� set�� ����ؼ� ����ϸ� �̸��� ���� ����
		//Set�� toString �޼ҵ�� []�� �����ؼ� ����ϵ��� �����Ǿ�����
		
		//map�� value�� Collection����, key�� Set���´ϱ� ���⼭�� Collection���� �޴°�.
		Collection values = map.values();//���� �޾Ƽ� values�� ����(Collection)
		it = values.iterator();//iterator �̿��ؼ� �޸𸮿� ����� ���¿��� ���� ������ ������ ���°� �ǵ��� �������
		
		int total = 0;
		
		while(it.hasNext())
		{
			Integer i = (Integer)it.next();
			total += i.intValue();
		}
		
		System.out.println("���� : "+total);
		System.out.println("��� : "+(float)total/set.size()); //��Ģ�����ġ�� �Ǽ����� default�� double�ε� �װ� float�� ĳ�����ؼ� float�� ��Ÿ���� ��.
		System.out.println("�ְ����� : "+Collections.max(values)); //max�� CollectionŬ������ ���ԵǾ��ִ� �޼ҵ�
		System.out.println("�������� : "+Collections.min(values));// ����������
	}
}
