package day4_7;
/*�޼��� ����
 * �����͸� ������ ��Ŀ� �°� ����� �� �ֵ��� �����ִ� Ŭ�����Դϴ�.
�����Ͱ� �� �ڸ��� ������ ���� ����� �̸� �ۼ��ϰ� ���α׷��� �̿��ؼ� �ټ��� �����͸�
���� ������� ����� �� ����ϸ� �����ϴ�.
*/

import java.text.MessageFormat;
import java.text.ParseException;
//import java.util.*;

public class MessageFormatEx1 {

	public static void main(String[] args)
	{
		//���� ���� �ִ� ��.
		String tableName = "CUST_INFO";
		String msg = "INSERT INTO "+tableName+" VALUES(''{0}'',''{1}'',{2},''{3}'');"; //����(�����ͺ��̽����)������ ' '�� ���ڿ�
		
		Object[][] arguments = {
				{"���ڹ�","02-123-1234","27","07-09"},
				{"������","032-333-1234","33","10-07"}
		};
		
		for(int i=0; i<arguments.length;i++) //arguments.length�� 2�ϱ� 0,1����
		{
			String result = MessageFormat.format(msg,arguments[i]); //���ʿ� ������ ���� �������ִ°�...?
			System.out.println(result);
		}
		
		//���� ��Ÿ���� ��(���� �� �Ľ�)->�����̿��� ���
		String[] data = {//�ε��� 0,1
				"INSERT INTO CUST_INFO VALUES('���ڹ�','02-123-1234',27,'07-09');",
				"INSERT INTO CUST_INFO VALUES('���ڹ�','02-123-1234',27,'07-09');"
		};
		
		String pattern = "INSERT INTO CUST_INFO VALUES({0},{1},{2},{3});"; //0,1,2,3�� ���� ���� ������ ��.
		MessageFormat mf = new MessageFormat(pattern);
		
		for(int i=0; i<data.length; i++) //date.length=2�ϱ� i=0,1 ���� ����
		{
			Object[] objs = null;
			try{
				objs = mf.parse(data[i]);
			}catch(ParseException e){
				e.printStackTrace();
			}	
			for(int j=0; j<objs.length;j++)
			{
				System.out.print(objs[j]+",");
			}
			System.out.println();
		}
	}
}
