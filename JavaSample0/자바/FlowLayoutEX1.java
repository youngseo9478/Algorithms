package graphicUI;
import java.awt.*;
public class FlowLayoutEX1 {

	public static void main(String[] args)
	{
		Frame f = new Frame("FlowLayout �׽�Ʈ");
		Panel p = new Panel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER)); //�������� �г��� �÷ο췹�̾ƿ��� ����Ʈ
		
		Button b1 = new Button("��ư1");
		Button b2 = new Button("��ư2");
		Button b3 = new Button("��ư3");
		Button b4 = new Button("��ư4");
		Button b5 = new Button("��ư5");
		
		//add�� �־��ִ� ������ ���� �ڸ��� ��������
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		
		f.add(p);
		
		f.setLocation(300,300);
		f.setSize(200, 100);
		f.setVisible(true);
	}
}
