package graphicUI;
import java.awt.*;
import java.awt.event.*;
public class AdapterEx extends Frame implements ActionListener, MouseMotionListener {


	Label move = new Label("���콺 ����ٴϱ�", Label.CENTER);
	Button exit = new Button("����");
	
	public AdapterEx()
	{
		setTitle("MouseMotionEvent TEST");
		setLayout(null);
		move.setBounds(100, 50, 150, 20);
		exit.setBounds(250,500,50,30);
		move.setBackground(Color.cyan);
		add(move);
		add(exit);
		setBounds(300,100,500,600);
		setVisible(true);
		
		exit.addActionListener(this);
		addMouseMotionListener(this); //Frame�� ���� ��
		
		//addWindowListener(this); //�����ӿ�  ���� �� ->implements�ؼ� ����� �� �����Ƽ� ����͸� ����غ�
		
		addWindowListener(new WindowAdapter(){ 
			/*WindowAdapter�� implements WindowListener, WindowStateListener, WindowFocusListener �ϰ� �ִ� Ŭ����
			 * Closing�� ���� �޼ҵ常 �������̵��ؼ� ����ϸ� �Ⱦ��� �κ��� ���� ������ �ʿ䰡 ����*/
			public void windowClosing(WindowEvent e){
				super.windowClosing(e);
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args)
	{
		new MouseMotionEventEx();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
	
	public void mouseMoved(MouseEvent e)
	{
		Point p = e.getPoint();
		move.setLocation(p);
	}
	
	public void mouseDragged(MouseEvent e)
	{
	}

	/*WindowListener �߰��� implements���ָ� �����ؾ��ϴ� �ڵ鷯 �޼ҵ尡 �Ʒ�ó�� �� �����Ǵµ�
	 * �� �� �����ؾ��ϴ� ���� �ƴ� �߰�ȣ ���� ����θ� ���� ���ϴ� ��.
	 * 
	 * �ٵ� ����ϴ� �� �ܿ��� �ʹ� �����ϱ� �����ϴ� ->Event Adapter Class
	 * �̰� ���� �ʿ��� �͸� ������ ���°� �����ϴ� (�����ʴ� �������̽��ϱ�)
	 * public aa(){} ������ ���ϰ� ���ȣ�� �δ� ��.
	 * �ʿ��� ���̸� �������̵� ���Ѽ� ���� ��
	public void windowOpened(WindowEvent e) {		
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}*/
}