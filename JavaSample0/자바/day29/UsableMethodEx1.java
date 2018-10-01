package day29;

/*String�� �Լ���!!*/

public class UsableMethodEx1 {

	public static void main(String[] args)
	{
		String s1 = "have a good day";	//���ڿ��� s1�� ����
		
		//indexOf�� �Ұ�ȣ �ȿ� �ִ� ������ ��ġ�� ��Ÿ����.
		int index = s1.indexOf('a');
		System.out.println("�� ó�� ���� a�� ��ġ : "+index);
		
		//indexOf�� �����ε�Ǿ��־ ���ڿ��� ��ġ�� �˾Ƴ��� �͵� �����ϴ�.
		index = s1.indexOf("ood");
		System.out.println("���� ood�� ��ġ :" +index);
		
		//lastIndexOf�� �Ұ�ȣ ���� ���ڰ� �����ϴ� ������ ��ġ�� ��Ÿ����.
		index = s1.lastIndexOf('a');
		System.out.println("������ ���� a�� ��ġ : "+index);
		
		//charAt�� �Ұ�ȣ���� �ε���(��ġ)�� �ش��ϴ� ���ڸ� ��Ÿ����.
		char c = s1.charAt(index);
		System.out.println("������ ���� :"+c);
		
		//substring�� �Ұ�ȣ ���� ��ġ�������� ������ �κ��� �߶󳻴� ���ε�
		//���⼭�� g�� ��ġ�� �ε��������� �����ϰ� �� ��(g�� ��ġ��)�� �̿��ؼ� g���� �������κ��� �߶󳽴�.
		index = s1.indexOf('g');
		String str = s1.substring(index);
		System.out.println("g�κ��� ������ �߶󳻱� : " +str);
		
		//�Ű������� �ΰ��־ �߶� ù��°��ġ�� ������ �߶󳾰������� �������� �� �ִ�.
		str = s1.substring(index, index+3);
		System.out.println("g�κ��� 3�ڸ����� �߶󳻱� :"+str);
		
		//length�� ���ڿ��� ����(ũ��)�� ���ϴ� �Լ��̴�.
		int length = s1.length();
		System.out.println("s1�� ���� : "+length);
		
		//toUpperCase�Լ��� ����� ���ĺ��� ��� �빮�ڷ� ��Ÿ���ش�.
		String str2 = s1.toUpperCase();
		System.out.println("uppercase ��� : "+str2);
		
		//toLowerCase�� ���ĺ��� ��� �ҹ��ڷ� ��Ÿ���ش�.
		str2 = s1.toLowerCase();
		System.out.println("lowercase ��� ;"+str2);
		
		//split�� ���ڿ��� �Ұ�ȣ�ȿ� �ִ� ���ڸ� �������� �߶��ִ� ���̴�. ���⼭�� ������ �������� �߶�
		//�̰��� ��Ʈ�� Ÿ���� �迭�� ����ȴ�.-->����̰ź��� �׳� StringTokenizer class�� �� ���� ����Ѵ�.
		String[] arr = s1.split(" ");
		for(int i=0; i<arr.length; i++)	//�ɰ��� ������ length���� ��
		{
			System.out.println("arr["+i+"] :"+arr[i]);
		}
		
		//�и��� arr�� ���̴� �Լ�
		String joinStr = String.join("-", arr);
		System.out.println("Join method : "+joinStr);
		
		//String format�� ����� ��� �ϴ� ��.
		String str3 = String.format("%d ���ϱ� %d �� %d �Դϴ�.", 3,5,3+5);
		System.out.println("string format : "+str3);
	}
}
