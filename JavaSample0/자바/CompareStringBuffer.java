package day29;

public class CompareStringBuffer {

	public static void main(String[] args) {

		long start, end;

		String str1 = new String("1~1000�� �� : "); //���� �Ű����� ĭ�� ������ ���� ��ԵǴ°���...?
		StringBuffer str2 = new StringBuffer("1~1000�� �� : ");

		start = System.currentTimeMillis();
		for (int i = 1; i <= 10; i++) {		//���Ʒ��� �� ������ ũ�Ⱑ Ŀ������ ���̰� ���� �� Ŀ����.
			str1 += i;
			str1 += "+";		//��� �����°���...?
		}
		end = System.currentTimeMillis();
		System.out.println("String : " + (end - start));
		System.out.println(str2);
		
		start = System.currentTimeMillis();
		for (int i = 1; i<= 1000; i++) {
			str2.append(i);
			str2.append("+");
		}
		end = System.currentTimeMillis();
		System.out.println("StringBuffer : " + (end - start));
	}
}
