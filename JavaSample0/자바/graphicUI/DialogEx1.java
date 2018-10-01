package graphicUI;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;

/******Dialog*******
 * �˸��� ���� confirm�� ���� ��
 * 
 * Dialog(Dialog owner) 
 * -> owner�� Frame�� ��ü 
 * modal���� true�̸� �տ�â��� ���ᰡ�Ǿ�� �ڿ��ִ°� ��밡��
 *  ->�� ��������� confirm�� �޾ƾ��ϴ°� Modal�� true�� �� �����ؾ��Ѵ�. 
 * */
public class DialogEx1 {
	public static void main(String[] args)
	{
		Frame f = new Frame("Parent"); //info ���̾�α׸� ó���ϱ� ������ f �������� �ǵ� �� ����.
		f.setSize(300,200);
		
		//Parent Frame�� f���ϰ�, modal���� true�� �ؼ� �ʼ� ���� Dialog�� ��.
		Dialog info = new Dialog(f,"Information",true); //true�� ������ modal�� �����Ǿ� ���� ó���Ǿ�� �ڿ� �ִ� �������� �ǵ� �� �ִ�.�ڿ�������Ŭ���ϸ� info�������� �����Ÿ���.
		//Dialog info = new Dialog(f,"Information",true);//true�ڸ��� �ƹ��͵� �ȳ����� ����� �ƴ� ��. �켱�������� �����Ӿƹ��ų� ���� ����� �� ����
		info.setSize(140,90);
		info.setLocation(50, 50); //parent frame�� �ƴ�, ȭ���� ��ġ�� ������ �ȴ�.
		info.setLayout(new FlowLayout());
		
		Label msg = new Label("This is modal Dialog", Label.CENTER); //���⼭�� �� �޼����� info �������� ����� ��ġ�ϰ� �ȴ�.
		Button ok = new Button("OK"); //���⼭�� info �����ӿ� OK��ư�� �߰��ߴ�.
		info.add(msg); //msg�� info�� �߰��Ѵ�.
		info.add(ok); //ok��ư�� info�� �߰��Ѵ�.
		
		f.setVisible(true);
		info.setVisible(true); //���̾�α׸� ȭ�鿡 ���̰� �Ѵ�.
		
	}
}
