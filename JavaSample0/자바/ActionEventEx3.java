package graphicUI;

import java.awt.*;
import java.awt.event.*;

public class ActionEventEx3 extends Frame implements ActionListener{

	Label lb;
	Button[] btn = new Button[7];
	Color[] color = {Color.black, Color.blue, Color.cyan, Color.green, Color.magenta,Color.orange, Color.red};
	String[] string = {"black","blue","cyan","green","magenta","orange","red"};
	
	public ActionEventEx3(String str)
	{
		super(str);
		setLayout(new FlowLayout()); //���� ũ�⸸ŭ�� ����� ������ �Ǿ��־ ��ư����� �ٲٷ��� ���������� �ٲ�����Ѵ�..��
		for(int i =0; i<7; i++)
		{ 
			//setForgeround�� ���ڻ��� �������ִ� �޼ҵ�
			btn[i] = new Button(string[i]);
			btn[i].setForeground(color[i]);
			btn[i].addActionListener(this);
			add(btn[i]);
		}
		setSize(200,200);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Button obj = (Button)e.getSource();
		for(int i= 0; i<7; i++)
		{
			if(obj==btn[i])
			{
				//setBackground�� ������ �������ִ� �޼ҵ�
				this.setBackground(color[i]); //���⼭ this�� Frame�� ���� ���� �Ƚ��൵ �ȴ�.
			}
		}
	}
	
	public static void main(String[] args)
	{
		new ActionEventEx3("Action �̺�Ʈ");
	}
}
