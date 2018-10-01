package day11_7;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
//�о�� �� ���ۿ��� �÷��� �������� ��
//���ۿ� �ø��� �� �ٸ���?
/*���۴� �޸��� �������� ���̸� �������� ��
 *������ �ϳ��� �������� �� ���� �� ������ ��� ��ǻ�Ϳ��� �������� ������ �ֱ⶧���� �ѱ��� ��Ƽ�
 *�˸��� ũ��� �ѹ��� �����ִ� ���� ��ǻ�����忡���� �� ȿ�����ΰ�. */
public class BufferedInputStreamEx {

	public static void main(String[] args)
	{
		FileInputStream fis = null;
		BufferedInputStream bis = null; //fis ��ü�� �޾Ƽ� bis�� ����Ŷ� FileInputStream�� �ʿ��� ��
		
		try{
			fis = new FileInputStream("c:\\java_study/test.txt");//���� ���� ��("c:/java_study/test.txt");
			bis = new BufferedInputStream(fis); //FileInputStream�� ��ü�� �޾Ƽ� �������½�Ʈ������ �����.
			int readbyte = 0;
			while((readbyte = bis.read())!=-1) //-1�� �Ǵ� �� ���̻� �о�� �����Ͱ� ���ٴ� ��! read()�Լ��� ������ ������ -1������
			{
				System.out.print((char)readbyte); //���ڷ� �ޱ����ؼ� char�� ĳ���� ����
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally{
			try{
				if(fis != null) fis.close(); //fis�� �ݰ�
				if(bis != null) bis.close(); //fis�� �����ؼ� ���� bis�� �ݾ������
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
}
