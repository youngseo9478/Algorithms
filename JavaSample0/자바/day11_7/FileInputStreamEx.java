package day11_7;
/*��ĳ�ʴ� ���ڿ� ���·� �޾��ִµ� 
 * byte�� �迭�� ���� �׸��� byte�� 1����Ʈ���б⶧���� �ѱ��� �Է¸�����
 * �׷������ ��ĳ�ʰ� ���� .
 * �׳� �̷��� �ѹ���Ʈ�� �޴� ����� �ִٴ°� �˾Ƶα�
 * �������� �Ʒ��� ���� ���� ����*/
/******���ϸ� : c:/java_study/test.txt*****
*******hi everyone!!********************/
import java.io.*;
public class FileInputStreamEx {

	public static void main(String[] args)
	{
		FileInputStream fis = null;
		byte _read[] = new byte[100];
		byte console[] = new byte[100]; //�ѹ���Ʈ�� �б�����
		
		try{
			
			//read()�� ���̻� ���� ���� ������ -1���� �ƽ�Ű�ڵ�� -1�� NULL�� ���� -1�� �ٸ��� ǥ����
			System.out.print("���ϸ� : ");
			System.in.read(console); //�ѹ���Ʈ�� �о�� -> read()�� hasNext(),next() ���� ����� ��� �����ִ� �޼ҵ�.
			String file = new String(console).trim();
			fis = new FileInputStream(file); //ĳ����I/O�� ���Ⱑ FileReader�� �ٲ�� ���̸� ����~
			fis.read(_read,0,_read.length);//_read���ٰ� 0�������� _read.length��ŭ�� �аڴ� ��
			System.out.println(new String(_read).trim());
		}catch(FileNotFoundException fnfe){ //�������� ������ ���� ����� ����ó�� -> catch�� ������������ ����ش�. 
			fnfe.printStackTrace();
		}catch(IOException ie){ //������ ������ �� �� �ִ� ����� ����ó��->ó������ ū�ɷ� ������ �� ���⿡ �ɷ������� ����ȭ�� �ȵ�.
			ie.printStackTrace();
		}finally{ //finally�� ���ΰ� �� �����ؾ� �ϴ� ��. ������ �������� �� �ݾƾ���
			try{//�׷��� �� ������ ����������������->try catch�̿��ؼ� ����ó�����־����
				if(fis != null) fis.close();
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
}
