package graphicUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ActionEventC2 extends Frame //implements ActionListener
{
	Label outputLabel = new Label();
	Button leftBtn = new Button("<=Button");
	Button rightBtn = new Button("Button=>");
	
	
	/********3.�������� ����� ����(��ϸӽ�)************/
	//�׼Ǹ����ʸ� ����� ����� ������ (��ϸӽ��� �̷��� �ص� ��)->���⼭ ���� �����ϴ� ��
	ActionListener actionHandler = new ActionListener(){
		//�����ʿ� ���ؼ� ȣ��Ǵ� �ڵ鷯
		public void actionPerformed(ActionEvent e) //���⼭ �������̵�
		{//e�� �����ʰ� ������ ������ �ڵ鷯���� ������ �͵��� �������
			Button eventBtn = (Button)e.getSource(); //getSource()�� ������ƮŸ���� �����ϱ⶧���� ĳ���� �ʿ�
			if(eventBtn ==leftBtn)
			{
				outputLabel.setText("<=Button click");
			}
			else
			{
				outputLabel.setText("=>Button click");
			}
		}
	};
	
	public ActionEventC2(String title){
		super(title); //Ÿ��Ʋ ����
		Panel p =new Panel();
		p.add(leftBtn);
		p.add(rightBtn);
		outputLabel.setBackground(Color.ORANGE);
		//��ư�̿ö��ִ��г��� north�� �ø���.
		add(p, "North");
		add(outputLabel, "South");
		
	
		leftBtn.addActionListener(actionHandler);
		rightBtn.addActionListener(actionHandler);
		/*�ڵ鷯�޼ҵ带 �����̾� ��ü�� this�� �Ѱ����. ->�ڵ鷯�޼ҵ尡 ���ο� �ִٴ� ��
		 * this�� ���������Ҷ� �ڱⰡ �ִ� ��ü�� �ּҰ��� �������� �׷��ϱ� �� ��ü�ȿ� �̰� ������ �޼ҵ尡 �־��
		 * ����� �� �ִ� ���! ���� Ŭ������ implements ActionListener (�������̽�)�ϸ� 
		 * actionPerformed() (abstract �޼ҵ�)�� ������ �� �ִ�. 
		 * �������ϰ� ������ ������ �� ->�Ʒ��� actionPerformed()�� �����ϰ� �ִ�. */
		
		setBounds(100,100,300,200);
		setVisible(true);
	}
}

public class ActionEventEx2 {

	public static void main(String[] args)
	{
		new ActionEventC2("ActionEventTest1");
	}
}
