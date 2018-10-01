package network;
/***********SOCKET-CLIENT**************/
import java.io.*;
import java.net.*;

public class EchoClient {

	private String ip;
	private int port;
	private String str;
	BufferedReader file;
	
	public EchoClient(String ip, int port) throws IOException
	{
		this.ip = ip;
		this.port = port;
		Socket tcpSocket = getSocket();
		OutputStream os_socket = tcpSocket.getOutputStream();
		InputStream is_socket = tcpSocket.getInputStream();
		
		BufferedWriter bufferW = new BufferedWriter(new OutputStreamWriter(os_socket));
		BufferedReader bufferR = new BufferedReader(new InputStreamReader(is_socket));
		
		System.out.print("�Է� : ");
		file = new BufferedReader(new InputStreamReader(System.in));
		
		str = file.readLine();
		str += System.getProperty("line.separator");
		
		bufferW.write(str);
		bufferW.flush();
		
		//�����κ��� �ԷµȰ� ���������� ���⼭ ���
		str = bufferR.readLine();
		System.out.println("Echo Result : " + str);
		
		file.close();
		bufferW.close();
		bufferR.close();
		tcpSocket.close();
	}
	
	public Socket getSocket(){
		Socket tcpSocket = null;
		try{
			//server�� ip,port �ּҸ� �Ű������� �޾Ƽ� ���� ���ϰ�ü ����
			//������ Ŭ���̾�Ʈ�� �������� ����Ǵ� ��
			tcpSocket = new Socket(ip,port);
		}catch(IOException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
		return tcpSocket; //���ϰ�ü�� ������
	}
	
	public static void main(String[] args) throws IOException
	{
		new EchoClient("localhost",3000);
	}
}
