package network;
/***********SOCKET-SERVER*************
 * �����Ҷ��� ������ ���������Ų������ Ŭ���̾�Ʈ�� ������Ѿ���*/

import java.io.*;
import java.net.*;

public class EchoServer {

	private BufferedReader bufferR;
	private BufferedWriter bufferW;
	private InputStream is;
	private OutputStream os;
	private ServerSocket serverS;
	
	public EchoServer(int port)
	{
		try{
			/*Ŭ���̾�Ʈ�� ������ �������� �̽��ϴ� ��������
			 * ��ü�� ������ �޾Ƽ� �����´�.*/ 
			serverS = new ServerSocket(port);
		}catch(IOException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
		
		while(true)
		{
			try{
				System.out.println("Ŭ���̾�Ʈ�� ��û�� ��ٸ��� ��");
				Socket tcpSocket = serverS.accept();
				//accept()���� ����ϴٰ� Ŭ���̾�Ʈ������ Write�ϴ� ���� �Ʒ� �ڵ���� ������
				
				System.out.println("Ŭ���̾�Ʈ�� IP�ּ� : "+tcpSocket.getInetAddress().getHostAddress());
				
				//����� ���Դ��� Ȯ���ϸ鼭 ���°� ������ �ް�, ���ɹް�..��
				is = tcpSocket.getInputStream();
				os = tcpSocket.getOutputStream();
				
				//���۷� �޾Ƶ�
				bufferR = new BufferedReader(new InputStreamReader(is));
				bufferW = new BufferedWriter(new OutputStreamWriter(os));
				
				//Ŭ���̾�Ʈ�κ��� ���� �޼����� �о message�� ����
				String message = bufferR.readLine();
				System.out.println("���� �޼��� : "+message);
				
				//���������� ���⿡�ٰ� �߰��� write�ؼ� �Է��� �ϰԵǸ� Ŭ���̾�Ʈ�������� read�ؼ� �аԵȴ�.
				message = message+", �߰��� ����"+System.getProperty("line.separator");
				
				bufferW.write(message); //�������� �߰��� �ۼ��� �޼����� �ٿ��� �ٽ� Ŭ���̾�Ʈ�� ����
				bufferW.flush();
				bufferR.close();
				bufferW.close();
				tcpSocket.close();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)
	{
		new EchoServer(3000);
	}
}
