package day11_7;
/************����ȭ*****************
 * Serialize(����ȭ) : ��ü ������ ��Ʈ���� ���ؼ� �����ϴ� ��
 *��ü ������ ���Ͽ� ������ �� �ְ� ��Ʈ��ũ�� ���ؼ� ������ �� �ֵ��� ���ݴϴ�.
 *�ڹٿ����� Serializble �������̽��� �� ������ �����մϴ�.


<<<����ȭ�� ������ ��ü�� ����>>>
(1) �⺻�� Ÿ��(boolean, char, byte, short, int, long, float, double)�� ����ȭ�� ����
(2) Serializable �������̽��� ������ ��ü���� �Ѵ�. (Vector Ŭ������ Serializable �������̽�����)
(3) �ش� ��ü�� ����� �߿� Serializable �������̽��� �������� ������ �����ϸ� �ȵȴ�.
(4) transient �� ���� ����� ���۵��� �ʴ´�. (���� ���� : null ����)
 * 
 * ObjectOutputStream�� Serializble�������̽��� implements���־��� �͸� ����̰����ϴ�.
 * //ArrayList�� serializable�� implements�ϰ� �ֱ⶧���� ��밡���� ��*/
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
//����ȭ�ؼ� ������Ʈ��Ʈ���� ���� ��!!
//����ȭ ��Ű�� ���� Ŭ����(�ش絥����)�� �ø������������ ������ ���ƾ���
/**/
public class SerialEx1 {

	public static void main(String[] args)
	{
		try{
			String fileName = "UserInfo.ser";
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			ObjectOutputStream out = new ObjectOutputStream(bos);
			
			//���θ����ξ��� UserInfo Ŭ������ ��ü�� ���� ��
			UserInfo u1 = new UserInfo("JavaMan","1234",30);
			UserInfo u2 = new UserInfo("JavaWoman","4321",24);
			
			//UserInfo ������ ������ list�� ����� UserInfo�� ��ü���� list�� �߰�����
			ArrayList<UserInfo> list = new ArrayList<>(); 
			list.add(u1);
			list.add(u2);
			
			//writeObject�޼ҵ尡 ��ü�� ����ȭ�Ѵ�.=>Specified by: writeObject(...) in ObjectOutput
			out.writeObject(u1); //u1 ��ü�� ������Ʈ��Ʈ���� ����. 
			out.writeObject(u2);
			out.writeObject(list); //u1,u2�� �߰���Ų list�� ����ȭ���ָ� ������ȭ�ؼ� ������ �迭����Ʈ ���·� ��µǴ°��� ��������!
			out.close();
			System.out.println("����ȭ�� �� �������ϴ�.");
		}catch(IOException e){e.printStackTrace();}
	}//main
}//class
