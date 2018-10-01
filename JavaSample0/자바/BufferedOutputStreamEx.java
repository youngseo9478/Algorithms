package day11_7;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamEx {

	public static void main(String[] args)
	{
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try{
			//���⼭�� ���� true���ָ� �̾��, ���ָ� ����Ⱑ ����Ʈ!
			fos = new FileOutputStream("c:/java_study/bufferOut.txt",true);
			bos = new BufferedOutputStream(fos);
			String str = "BufferedOutputStream test �Դϴ�.";
			bos.write(str.getBytes());
			//bos.flush() ������ �̰� �����൵ �� ������ �� �־ ���� ������ ���� �ٸ�����!
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally{
			try{
				//���� ������ Output�� ���� �� ������ü���� �ݾ�����Ѵ�.
				if (bos != null) bos.close();
				if (fos != null) fos.close();
				//if (bos != null) bos.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
