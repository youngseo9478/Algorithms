package day11_7;

import java.io.File;
import java.io.IOException;

/*C����̺꿡�� ������ �Ժη� ������ �� ���Բ� �����ִ°�찡 ������
 * �̸� �ذ��ϴ� ����� ��ŷ�� ������ �ֱ⶧���� ������ �׳� 
 * ������ ������ ���ٴ� �� ������ �˰� �ֱ�*/
public class FileEx {

	public static void main(String[] args) throws IOException
	{
		String filePath = "c:\\";
		File f1 = new File(filePath);
		String list[] = f1.list();
		for(int i = 0; i<list.length; i++)
		{
			File f2 = new File(filePath, list[i]);
			if(f2.isDirectory())
			{
				System.out.printf("%s : ���丮 %n",list[i]);
			}
			else
			{
				System.out.printf("%s : ���� (%,dbyte)%n", list[i], f2.length());
			}
		}
		
		File f3 = new File("c:\\java_study\test.txt");
		//System.out.println(f3.createNewFile());
		System.out.println(f3.getAbsolutePath());
		//System.out.println(f3.getCannoicalPath());
		System.out.println(f3.getPath());
		System.out.println(f3.getName());
		System.out.println(f3.getParent());
		File f4 = new File("c:\\java_study\test.txt");
		File f5 = new File("c:\\java_study\test1.txt");
		System.out.println(f4.renameTo(f5));
	}
}
