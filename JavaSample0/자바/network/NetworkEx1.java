package network;

import java.net.*;
import java.util.*;

public class NetworkEx1 {

	public static void main(String[] args)
	{
		//InetAddress ��ü�� �̾ƿ��¾�
		InetAddress ip = null;
		//ȣ��Ʈ�� �����ϴ� InetAddress �迭�� ��ȯ�Ѵ�.
		//������ �����̳� ���̹����� ū ����Ʈ�� ������ ������ �׷��� �迭�� �޾ƿ��� ��
		//�����ǳ� ȣ��Ʈ�ּҸ� �̾ƿ� �� ����
		InetAddress[] ipArr = null;
		
		/* getByName() : �־��� �����γ����� ���ؼ� IP�ּҸ� ��ȯ�Ѵ�.
		 * toString() : IP�ּҸ� ���ڿ��� ��ȯ�Ͽ� �������ش�.
		 *  ->The string returned is of the form: hostname / literal IP address.
		 * 
		 * getAdress() : ����Ʈ�� ����(-128~127)������ ���� �ּҰ��� ������
		 *  ->�׷��� ������ ������ ��찡 �߻� ->������ ���°͸� +256�ؼ� ���� ���� ����
		 *    getHostAddress()�� ���� IP�ּҰ� ������ Ȯ���� �� �ִ�.
		 *    
		 * Arrays.toString() : �迭�� ����� ���� ���ڿ� ���·� ������ �� ����ϴ� �޼ҵ�
		 * ->The string representation consists of a list of the array's elements, enclosed in square brackets ("[]").
		 */
		try{
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName() : " + ip.getHostName());
			System.out.println("getHostAddress(); : "+ip.getHostAddress());
			System.out.println("toString(); " +ip.toString());
			
			byte[] ipAddr = ip.getAddress();
			System.out.println("getAddress(); : "+Arrays.toString(ipAddr));
			
			String result = "";
			for(int i=0; i<ipAddr.length;i++)
			{
				// ()? a: b; =>�Ұ�ȣ���� ���ǹ��� ������(true) a�� �����ϰ� Ʋ����(false) b�� ���� 
				result +=(ipAddr[i]<0)? ipAddr[i]+256:ipAddr[i];
				result +=".";
			}
			System.out.println("getAddress()+256 : "+result);
			System.out.println();
			//ȣ��Ʈ�� ��ã������ ����ó���� �� ���ִ� ���� ����
		}catch (java.net.UnknownHostException e) {
			e.printStackTrace();
		}
		
		/*ȣ��Ʈ(����������ǻ��)�� �̸��� �ּҸ� �˰���� ��
		 * 
		 * getLocalHost() : ���� ����ϰ� �ִ� ��ǻ���� �ּҸ� ��ȯ�Ѵ�.
		 * getHostName() : ȣ��Ʈ ��ǻ���� �̸��� ��ȯ�Ѵ�.
		 * getHostAddress() : ���ڿ��� ǥ���� IP�ּҸ� ��ȯ�Ѵ�.*/
		try{
			ip = InetAddress.getLocalHost();
			System.out.println("getHostName() : "+ip.getHostName());
			System.out.println("getHostAddress(); : "+ip.getHostAddress());
			System.out.println();
		} catch (java.net.UnknownHostException e) { //�Ʒ��� ĳġ�����̶� ������~ import��Խ����ֳĿ����� �ٸ���!
			e.printStackTrace();
		}
		
		try{
			/*���̹��Ͱ��� ������ IP�ּҸ� ������ ������ �ִ�.
			 * 
			 * getAllByName() : �Ű������� ���� �������� �����ִ� IP�ּҸ� ��� �����´�. 
			 * ipArr : InetAddress[]�� ���� ��ü�� �ּҸ� �迭���·� �޴´�.  */
			ipArr = InetAddress.getAllByName("www.naver.com");
			
			//���ٰ����� �������� IP�� ������ŭ length�� ���� ��.
			for(int i=0; i<ipArr.length; i++)
			{
				System.out.println("ipArr["+i+"] :"+ipArr[i]);
			}
		}catch (UnknownHostException e) { //import java.net.*;���� ���� import���༭ �̷��Ը� �ᵵ ������
			e.printStackTrace();
		}
	}
}
