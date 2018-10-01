package day11_7;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx {

	public static void main(String[] args) 
	{
	
		FileOutputStream fos = null;
		try{
			//�̾�� ���ؼ��� �ι�° �Ű�����(append)�ڸ��� true�� �־�����Ѵ�.
			//�׸��� ������ �ִ� �����̾ƴϴ��� ������� test2.txt���൵ �� ������ �����ǰ� �����Ͱ� ��µȴ�.
			fos = new FileOutputStream("c:/java_study/test1.txt",true);
			//("c:/java_study/test1.txt")-> �����. 
			String message = "Hello java";
			fos.write(message.getBytes());
			//fos.close();
		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally{
			try{
				if (fos!=null) fos.close();
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
}
