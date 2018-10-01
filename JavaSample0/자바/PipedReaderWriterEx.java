package day11_7;
/*ByteI/O�� �ٸ� ����
 * 2byte¥���̰� 
 * input output��ſ� reader writer��� ���� ���̸� ����
 * 
 * 
 *������ ����� ��Ʈ���� �ַ� ��Ƽ������ ó���� ����� �ϴµ�, �ϳ��� �����尡 �о� ���� ������ �ٸ� �����忡�� �����ϰ��� �� �� ��������Ʈ���� ����� �̿��ϴ� ���̴�.
 *
 *1. PipedInputStream
 
PipedInputStream() : ���� ������� ���� PipedInputStream�� ����.
PipedInputStream(PipedOutputStream src) : PipedOutputStream�� �����ϴ� PipedInputStream�� ����.
 
void connect(PipedOutputStream src) : PipedInputStream�� ������ PipedOutputStream src�� ����
 
�⺻�����ڸ� �̿��ؼ� PipedInputStream�� �����Ѵٸ� �ݵ�� �� �Լ��� ����ؼ� PipedOutputStream�� ������ �ΰ� �ؾ� �Ѵ�.
 
2. PipedOutputStream
 
PipedOutputStream() : ���� ������� ���� PipedOutputStream�� ����.
PipedOutputStream(PipedInputStream src) : PipedInputStream�� �����ϴ� PipedOutputStream�� �����մϴ�.
 
void connect(PipedInputStream snk) : PipedOutputStream�� ������ PipedInputStream�� ����.
*/

import java.io.*;

public class PipedReaderWriterEx {

	public static void main(String[] args)
	{
		/*InputThread�� OutputThread��� �̸��� �����ָ� ��ü�� ��������*/
		InputThread inThread = new InputThread("InputThread");
		OutputThread outThread = new OutputThread("OutputThread");
		
		//PipedReader�� PipedWriter�� �����Ѵ�. connect�� ������ �ȿ� �ִ� ��. �׷��� ������ �ȿ��� �� �ٽ� �ѹ��� �������� ��.������!
		inThread.connect(outThread.getOutput());
		
		//�Ѵ� ������۵����� ���ôٹ����ΰ� �ƴ϶� output�� ��� input�� �޾Ƽ� �д� ���� =>����ȭ�Ǿ�����
		inThread.start(); //���۵Ǹ� �������� run()���� ���� �����ϰԵ�
		outThread.start();
	}//main
}


class InputThread extends Thread
{
	PipedReader input = new PipedReader();
	StringWriter sw = new StringWriter();
	
	InputThread(String name)
	{
		super(name); //Thread(String name);
	}
	
	public void run()
	{
		try{
			int data = 0;
			
			//inThread�� �ٷ� ���۵Ǵ°Ծƴ�. �о�� ���� ���⶧���� output�� ���� �������� ���� connect�� �޾Ƽ� ���⼭ ���� �� �ְ� ��
			while((data=input.read())!=-1)
			{
				//data�� �޾Ƽ� ���ڿ��� ����������� StringWriter�� ��ü�� ����� ������
				sw.write(data); 
			}
			System.out.println(getName()+"received : "+sw.toString());
		}catch(IOException e){e.printStackTrace();}
	}//run
	

	public PipedReader getInput()
	{
		return input;
	}
	
	
	public void connect(PipedWriter output)
	{/**connect�ؼ� input�� output�� �޾ƿ��� ��**/
		try{
			input.connect(output);
		}catch(IOException e){e.printStackTrace();}
	}//connect
}

class OutputThread extends Thread
{
	PipedWriter output = new PipedWriter();
	
	OutputThread(String name){
		super(name); // Thread(String name)
	}
	
	public void run()
	{
		try{
			String msg = "Hello";
			System.out.println(getName()+" sent : "+msg);
			output.write(msg);
			output.close();
		}catch(IOException e){e.printStackTrace();}
	}//run
	
	public PipedWriter getOutput()
	{
		return output;
	}
	
	public void connect(PipedReader input)
	{
		try{
			output.connect(input);
		}catch(IOException e){e.printStackTrace();}
	}//connect
}