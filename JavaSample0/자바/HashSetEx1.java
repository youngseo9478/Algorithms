package day4_7;
/*�ݷ��� �����ӿ�ũ
 * 
 * �ڹٿ��� �ڷᱸ���� ũ�� �� ���� Ÿ�� 
 * 1.collection<E>  *E : element->object  =>(�Ÿ���̵�)�ϳ��� �����͸� ����
 * 	-List : �迭���·� �̸� �Ҵ��ϰ� �ű⿡ ��ü�� ����
 * 	-queue : ��ũ���·� �ؼ� ����
 * 	-set : ��������
 * 
 * 2.map<k,v> *k : key, v : value =>�ΰ��� �����͸� ���ÿ� ����
 * 
 * */
import java.util.*;
import static java.lang.System.out;

public class HashSetEx1 {

	public static void main(String[] args)
	{
		String[] str = {"Java","Beans","Java","XML"};
		
		HashSet<String> hs1 = new HashSet<String>();
		HashSet<String> hs2 = new HashSet<String>();
		
		for(String n : str)
		{
			if(!hs1.add(n)) //���ǽ� �ȿ� !�� �����ϱ� true�� ������ if�� ������ϰ� false�� ������ �����ϴ� ��.
			{
				hs2.add(n);
			}
		}
		out.println("hs1 : "+hs1); //���ö��� ������� �ȳ����µ� ���� ������� ������ ��찡 ������=> �򰥸�������!
		hs1.removeAll(hs2); //remove(hs2)�� hs1�� hs2��� ��ü�� ���������� ������ ��. (hs2�ȿ��ִ� ������ ���ϴ°� �ƴ϶� hs2 �̸���ü)
		out.println("hs1 : "+hs1);
		out.println("hs2 : "+hs2);
		
	}
}
