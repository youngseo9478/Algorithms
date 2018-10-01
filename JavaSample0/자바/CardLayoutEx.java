package graphicUI;
import java.awt.*;
import java.awt.event.*;
public class CardLayoutEx {

	public static void main(String[] args)
	{
		final Frame f = new Frame("CardLayoutTest");
		final CardLayout card = new CardLayout(10,10);
		f.setLayout(card);
		Panel card1 = new Panel();
		card1.setBackground(Color.orange);
		card1.add(new Label("Card 1"));
		Panel card2 = new Panel();
		card2.setBackground(Color.cyan);
		card2.add(new Label("Card 2"));
		Panel card3 = new Panel();
		card3.setBackground(Color.green);
		card3.add(new Label("Card 3"));
		
		f.add(card1, "1");		//Frame�� card1�� "1"�̶�� �̸� �ٿ� �߰��Ѵ�.
		f.add(card2, "2");
		f.add(card3, "3");
		

		class Handler extends MouseAdapter
		{ /*Handler Ŭ�������� MouseAdapter�� ��ӹ޾Ƽ� �ڵ鷯 �޼ҵ带 ����� �� �ְ�, 
		���ϴ� �׼��� ���ϵ��� �������̵� ���ְ� �ִ�.*/ 
			public void mouseClicked(MouseEvent e)
			{
				//���콺 ������ ������ ��
				if(e.getModifiers()==e.BUTTON3_MASK)
				{
					card.previous(f); //CardLayout�� ���� Panel�� �����ش�.
				}
				else
				{
					card.next(f); //CardLayout�� ���� Panel�� �����ش�.
				}
			}
		}// class Handler
		
		//��ӹ޾� �������̵� �����Ƿ� �ڵ鷯 Ŭ������ �������� ��ü�� �����ϸ� �ڵ鷯 �޼ҵ带 ����� �� �ִ�.
		card1.addMouseListener(new Handler());
		card2.addMouseListener(new Handler());
		card3.addMouseListener(new Handler());
		
		f.setSize(200,200);
		f.setLocation(200, 200);
		f.setVisible(true);
		card.show(f, "2"); //Frame�� �߰��� Component�� �̸��� "2"�� �ͺ��� �����ش�.
	}
}
