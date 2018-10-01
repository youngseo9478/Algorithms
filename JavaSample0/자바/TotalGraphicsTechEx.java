package graphicUI;
import java.awt.*;
import java.awt.event.*;

public class TotalGraphicsTechEx extends Frame implements ActionListener{
	
	Point first_point, last_point, old_point;
	MenuItem menu_tool_pen, menu_tool_line, menu_tool_circle, menu_tool_rect;
	String str="��"; //�ʱⰪ�� ������ �س��� ��  
	
	public TotalGraphicsTechEx() {

		super("Graphics �׽�Ʈ");
	
		//�켱 �޴��ٸ� ����� ���� �޴��� ��ü�� ����
		MenuBar mb = new MenuBar();

		//�޴��ٿ� "����"��� �޴��� �߰��ϱ����� �޴� ��ü�� ����
		Menu menu_tool = new Menu("����");

		//�޴� �ȿ��� �޴������۵��� �ִµ� ������ �̸� �����ص� �޴������۰�ü�鿡�� �޴��������̸��� �������ش�.
		menu_tool_pen = new MenuItem("��");
		menu_tool_line = new MenuItem("��");
		menu_tool_circle = new MenuItem("��");
		menu_tool_rect = new MenuItem("�簢��");
		
		//������� �޴��� ��,��,��,�簢�� ���� �޴� �������� �߰����ش�.
		menu_tool.add(menu_tool_pen);
		menu_tool.add(menu_tool_line);
		menu_tool.add(menu_tool_circle);
		menu_tool.add(menu_tool_rect);

		//�޴��ٿ� �޴��� �߰����ش�.
		mb.add(menu_tool);
		//�����ӿ� �޴��ٸ� �߰����ش�.
		setMenuBar(mb);

		//BorderLayout���� 5���� ������ �ִµ� Center�� �����ϰ� �ٸ������鿡 �ƹ��͵� ���� ������ Center�� �� ������ ��� �����Ѵ�. 
		add(new GrimPanCanvas(), BorderLayout.CENTER);
		
		//��ġ�� ũ�⸦ ���ÿ� �������ִ� �޼ҵ�
		setBounds(200,200,400,400);
		
		//ȭ�鿡 ��Ÿ��
		setVisible(true);
		
		//������ �޴������ۿ� ���� �̺�Ʈ�� �߻��ϸ� �̺�Ʈ �����ʰ� ������ �����ؼ� actionListener�� �ڵ鷯 �޼ҵ�� �����ִ� ��
		//this ->���������ϰ� �����Ƿ� �ڱ��ڽŰ�ü�� �ּҰ��� ����Ŵ (implements�س��ұ⶧���� �Ʒ��� ����Ϸ��� �޼ҵ带 �������̵��ؼ� ����Ѵ�.)
		//actionPerformed()�� ������
		menu_tool_pen.addActionListener(this);
		menu_tool_line.addActionListener(this);
		menu_tool_circle.addActionListener(this);
		menu_tool_rect.addActionListener(this);
		
	}

	//�޴��������� �̺�Ʈ�� ������ �޾Ƽ� �̺�Ʈ�� ó���ϴ� �ڵ鷯�޼ҵ�! (�������̵�)
	public void actionPerformed(ActionEvent ae){
		//ae�� �����ʰ� ������ �̺�Ʈ������ ���� ->getSource()�� �̿��� ���� �������µ� ����Ÿ���� ������Ʈ�̱⶧���� ĳ�����ؼ� ����
		MenuItem selected_menu = (MenuItem)ae.getSource();
		
		if(selected_menu.equals(menu_tool_pen)){
			str = menu_tool_pen.getLabel(); //getLabel()�ؼ� �ش��ϴ� �޴��������� �̸��� �������� ��
		}else if(selected_menu.equals(menu_tool_line)){
			str = menu_tool_line.getLabel();
		}else if(selected_menu.equals(menu_tool_circle)){
			str = menu_tool_circle.getLabel();
		}else if(selected_menu.equals(menu_tool_rect)){
			str = menu_tool_rect.getLabel();
		}
	}

	public static void main(String[] args) {
		new TotalGraphicsTechEx();
	}

	class GrimPanCanvas extends Canvas implements MouseMotionListener, MouseListener{

		public GrimPanCanvas() {
			addMouseListener(this);
			addMouseMotionListener(this);
		}
		//Adapter�� ���� �ʾƼ� ������ �����ϴ� �޼ҵ�鵵 ���ȣ ���·ζ� �����س��Ҵ�.
		public void mouseClicked(MouseEvent me){}
		public void mouseEntered(MouseEvent me){}
		public void mouseExited(MouseEvent me){}

		//���콺�� ������ ��
		public void mousePressed(MouseEvent me){
			first_point = me.getPoint(); //���콺�� ���� ����Ʈ�� �޾Ƽ� ù��° ����Ʈ�� ���� �������ش�. (PointŸ�� ��ü) 
			old_point=me.getPoint(); //�������¿��� ������ ����Ʈ
		}

		//���콺�� ���� ��
		public void mouseReleased(MouseEvent me){
			last_point = me.getPoint(); //���� ����Ʈ�� �޾Ƽ� ����������Ʈ�� ���� �������ش�. 
			repaint(); //���콺�� ������ ���� ���ο�����Ʈ���� ���� �׸� �� �ֵ��� ���ִ� �޼ҵ�
		}	
		
		//���콺�� �巡������ �� (���콺����̺�Ʈ�� �ش�)
		public void mouseDragged(MouseEvent me){
			last_point = me.getPoint();//�巡���� ������ ����Ʈ�� ���Թ޴´�.
			repaint(); //���� �巡�װ� ������ �������� �ٽ� ���� �׸� �� �ְ� ���ش�.
		}

		public void mouseMoved(MouseEvent me){}

		// paint()�޼ҵ尡 ����Ǽ� ĵ������ �׸��� �׷���
		public void update(Graphics g){
			paint(g);
		}
		
		//������ Ŭ�������� paint()��� �׸��� �׸��� �޼ҵ尡 ���ǵǾ����� (�������̵�)
		public void paint(Graphics g) {	
			if(first_point != null && last_point != null) {//�ƹ��͵� ���ѻ��� (Ŭ�����������ѻ���)
				if(str.equals("��")) {
					//������ �׸��� �޼ҵ� (�ʱ�x,y ,������ x,y)
					g.drawLine(first_point.x, first_point.y,
						last_point.x, last_point.y);
					first_point=last_point; //�׸��׸��°� �������� �巡���� ��������ġ�� ù��° ��ġ���ȴ�.

					return;
				}
				if(str.equals("��")) {
					g.setColor(Color.CYAN); //������� �Ǿ��������� ���� ������ ����
					g.drawLine(first_point.x, first_point.y,
						old_point.x, old_point.y); 
					//���������� �������̹Ƿ�->�����ؼ� ���׸��� �Դٰ����غ��� ���� �� �� ����.

					g.setColor(Color.BLACK);
					g.drawLine(first_point.x, first_point.y,
						last_point.x, last_point.y); //�巡������ ������ ����Ʈ
				}else if(str.equals("��")) {		
					g.setColor(new Color(255,255,255));//RGB�� �Ȱ��� ������ �༭ �ᱹ �Ͼ��
					//�巡���ϴµ����� ����Ʈ�� �����־ �׷��Ű� �̰� �Ͼ������ ó������� ���׶�̸� ����
					g.fillOval(first_point.x, first_point.y, 
						old_point.x-first_point.x, 
						old_point.y-first_point.y);

					g.setColor(new Color(250,150,250));	//B���� �����Ƿ� �Ķ���(250�� �ִ밪�̰� ���ڰ� Ŭ���� ä���� ����				
					g.fillOval(first_point.x, first_point.y, 
						last_point.x-first_point.x, 
						last_point.y-first_point.y);
					
				}else if(str.equals("�簢��")) {		
					
					//�巡�׸� �ϸ鼭 ũ�⸦ Ű��� ���̰� �� �� �ִµ� �� �巡�װ��� �� ��Ÿ���� ���������� ��������� �� ���� ���
					//�巡�׷� �Դٰ����ϴ� �κ��� �Ͼ������ ä���� �Ⱥ��̰� ���ذ�!
					g.setColor(new Color(255,255,255));					
					g.fillRect(first_point.x, first_point.y, 
						old_point.x-first_point.x, 
						old_point.y-first_point.y);
					

					g.setColor(new Color(20,250,200));					
					g.fillRect(first_point.x, first_point.y, 
						last_point.x-first_point.x, 
						last_point.y-first_point.y);
				}
				old_point=last_point;
			}
		}
	}
}