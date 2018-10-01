package graphicUI;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

/*****Container*****
 * ������ �ȿ� �� �������� ���̷��� �� �� ����ϴ� ��*/
public class PanelEx1 {

	public static void main(String[] args)
	{

		Frame frame = new Frame("Panel Ex"); 
		frame.setLayout(null);
		frame.setBounds(1000, 100, 500, 500); //setSize, setLocation���ÿ� ���ִ� �޼ҵ� (x,y,width,height)
		//��ġ�� ������� ���̴�. �θ� ������ ���� 
		Panel panel = new Panel();
		panel.setBounds(50,50,150,150);
		panel.setBackground(Color.GREEN);
		
		Button btn = new Button("O  K");
		btn.setSize(50,20);
		panel.add(btn); //panel���ٰ� ��ư�� �߰����� �� panel2���� ��ư ����
		
		Panel panel2 = new Panel();
		panel2.setBounds(200, 50, 150, 250);
		panel2.setBackground(Color.YELLOW);
		
		//panel, panel2�� frame�� �߰����ִ� ��.
		frame.add(panel); 
		frame.add(panel2);
		
		frame.setVisible(true);
	}
}
