package graphicUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ActionEventC extends Frame implements ActionListener
{
	Label outputLabel = new Label();
	Button leftBtn = new Button("<=Button");
	Button rightBtn = new Button("Button=>");

	
	public ActionEventC(String title){
		super(title); //Ÿ��Ʋ ����
		Panel p =new Panel();
		p.add(leftBtn);
		p.add(rightBtn);
		outputLabel.setBackground(Color.ORANGE);
		//��ư�̿ö��ִ��г��� north�� �ø���.
		add(p, "North");
		add(outputLabel, "South");
		
		/*�����ʴ� �̺�Ʈ�� �߻��̵Ǿ����°� Ȯ���ϰ� , �̺�Ʈ�߻������������ ������, ������ ������ �� �ڵ鷯�� �θ���.
		�ڵ鷯�޼ҵ带 �����ִ� ��ü�� ���Ѵ�.
		�ڵ鷯�޼ҵ�� ���δ� �������̽��� �Ǿ����� �׷��� �� �������̽��� �����ϰ� �ִ� ��ü�� �Ұ�ȣ�ȿ� �־��־�� �Ѵ�.*/
		
		
		/*/*****1. �̺�Ʈó���ϴ� ù��° ���(��ϸӽ��������̽�(�ַλ���ϴ¹��))->������������(�ٷ� ��޼ҵ�ξ�Լ���Ǵ��� �� �� �����ϱ�)**
		 * �̰� ���Ǿ����� ���� ��ü�� ������ .ActionListener ��ü�� �����ִ� �ڵ鷯�� �ּҸ� ��������
		 * 2������� ����ϱ����� implements�� �س��Ƽ� ��� �ᱹ �ڵ鷯�޼ҵ� ��ü�� �ΰ������ִ°ǵ� ���°� ���λ����� ��ü�� �̿��ϰ� ��
		leftBtn.addActionListener(new ActionListener(){ //�̱����Ȱ��� ���⼭ �������̵�
			public void actionPerformed(ActionEvent e){
				outputLabel.setText("<=Button click");
			}
		}); */ 
		
		
		/****2. this�� �̿��� ���(��������) ->implements�ؼ� ���ο� �޼ҵ带 �����ϴ� ���***
		 * ���⼭ ��ü�� ���������� ���̱⶧���� �ڱ��� ��ü �ּҸ� ��������
		 * ->>>�������� ������ ->>>�ٰ��� �۾��Ҷ��ַ� ���
		leftBtn.addActionListener(this);
		rightBtn.addActionListener(this);
		/*�ڵ鷯�޼ҵ带 �����̾� ��ü�� this�� �Ѱ����. ->�ڵ鷯�޼ҵ尡 ���ο� �ִٴ� ��
		 * this�� ���������Ҷ� �ڱⰡ �ִ� ��ü�� �ּҰ��� �������� �׷��ϱ� �� ��ü�ȿ� �̰� ������ �޼ҵ尡 �־��
		 * ����� �� �ִ� ���! ���� Ŭ������ implements ActionListener (�������̽�)�ϸ� 
		 * actionPerformed() (abstract �޼ҵ�)�� ������ �� �ִ�. 
		 * �������ϰ� ������ ������ �� ->�Ʒ��� actionPerformed()�� �����ϰ� �ִ�. */
		
		
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
		
		leftBtn.addActionListener(actionHandler);
		rightBtn.addActionListener(actionHandler);
		
		setBounds(100,100,300,200);
		setVisible(true);
	}
	
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
}

public class ActionEventEx {

	public static void main(String[] args)
	{
		new ActionEventC("ActionEventTest1");
	}
}
