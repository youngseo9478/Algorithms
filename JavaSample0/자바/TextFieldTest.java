package graphicUI;
import java.awt.*;
public class TextFieldTest {

	public static void main(String[] args)
	{
		Frame f = new Frame("Login");
		f.setSize(400,400);
		f.setLayout(new FlowLayout()); //LayoutManager�� FlowLayout���� �Ѵ�.
		
		Label lid = new Label("ID : ", Label.RIGHT); //������ ����������
		Label lpwd = new Label("Password : ",Label.RIGHT);
		
		TextField id = new TextField(10); //�� 10���� ���ڸ� �Է��� �� �ִ� TextField ����
		TextField pwd = new TextField(10);
		pwd.setEchoChar('*');//�Է°���� '*'�� ���̵��� �Ѵ�.
		
		//TextArea(String text, int rows, int columns, int scrollbars)
		TextArea comments = new TextArea("�ϰ� ���� ���� ��������.",10,50,TextArea.SCROLLBARS_VERTICAL_ONLY);
		//TextArea���� ��ũ�ѹٴ�  ����Ʈ�ε� ����/���� �� �ϳ��� �ϰ�Ͱų� �Ѵ� ���ϰ� �������� ������� �༭ �������� �� �ִ�.
		f.add(lid);
		f.add(id);
		f.add(lpwd);
		f.add(pwd);
		f.add(comments);
		f.setVisible(true);
	}
}
