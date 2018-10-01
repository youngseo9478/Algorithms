package day11_7;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/*print����ó�� ����� �� �ְ� ���ִ� �� =>���� ���� �� ���� ������� ����! ���� �����͸� �� �� ����ϴ� ���
 * ������͸� �ᵵ ���ڿ��� �޴°� 
 * =>��ü ��ü�� ���̰� �� ���ڿ��� �ޱ⶧���� ���α׷��� ���ſ� �� �ʿ��Ҷ��� ����ؾ��Ѵ�.
 * �̰� ������ �ι� ���ְ� �Ǵ� ��.*/
public class PrintStreamEx {

	public static void main(String[] args)
	{
		//PrintStream�� ���۸� ������ �ӵ��� �������� ������ �ι� ������ ��. �� ���۷� �����ؾ��Ѵ� ���� �ƴϰ� outputStream�̸� ���� �����ϱ� ��
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		PrintStream ps = null;
		
		try{
			//FILE�� ���� �⺻���̰� ȿ���������� ��Ʊ� ������ ������ �����ؼ� �����ϰ� ����ϴ� ��
			//���� ���۱��� �����ؼ� ����ϴ� ���� ���� ���� �� �Ť�
			//����Ʈ�� ���� �����͸� �� ���� ������
			fos = new FileOutputStream("c:/java_study/printStream.txt");
			bos = new BufferedOutputStream(fos);
			ps = new PrintStream(bos, true);
			
			ps.println("������");
			ps.println(1234);
			ps.println(true);
			ps.println('a');
		}catch(IOException e)
		{ e.printStackTrace();}
		finally
		{
			try{
				if(ps!=null) ps.close();
				if(bos!=null) bos.close();
				if(fos!=null) fos.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
