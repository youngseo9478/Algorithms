package day28;
/*Class
 * Ŭ������?
 * ex) String�� Ŭ���� -> ���ֻ���ؼ� ������������
 * */
public class ClassEx1 {

	public static void main(String[] args)
	{
		String[] arrStr = new String[3];
		
		arrStr[0]="�ȳ��ϼ���";
		arrStr[1]="���� �Ϸ� �Ǽ���";
		arrStr[2]="�ݰ����ϴ�";
		
		for(int i=0; i<arrStr.length;i++)
		{
			System.out.println(arrStr[i]);
		}
		
		String[] arrStr2 ={"hi","everyone"};
		
		for(int i=0; i<arrStr2.length; i++)
		{
			System.out.println(arrStr2[i]);
		}
	}
}
