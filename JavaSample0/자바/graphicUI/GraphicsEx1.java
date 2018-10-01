package graphicUI;

/**********Canvas************/
/* paint()->�׸����׸����ֵ�������->�����ӿ��� �ִ� �޼ҵ�� ȭ�鿡 �ѷ����� ������ ����Ǵ� �޼ҵ�
 * update()->
 * drawString() ���ڸ� �׸��� ��
 * drawOval() ���׸��°�
 * setColor() ��
 * fillOval() ���ǻ����� ä�� ��
 * drawLine() ���׸���
 * fillRoundRect(a,b,c,d,e,f) (a,b)����Ʈ�� (c,d)ũ���� �簢���׸��� (e.f)��ġ���� ���� �׸��� ->�𼭸����ձٻ簢��
 * polygon �迭 �ΰ� �Ἥ �ٰ��� �׸��� �� 
 * fillArc
*/
import java.awt.*;//awt������ �������°����� ���������� �������� ���� 
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GraphicsEx1 extends Frame {

	public static void main(String[] args) {
		new GraphicsEx1("GraphicsEx1");
	}

	//���� �ʷϻ� �ﰢ�� ǥ�ô� �������̵��� �ǹ� Frame�� ���� paint()�����ִµ� �ٽ� ������ �� 
	//���� Visible()��� ������ paint()����Ǽ� �׸��׷���
	public void paint(Graphics g) {
		g.setFont(new Font("Serif", Font.PLAIN, 15));
		g.drawString("Graphics�� �̿��ؼ� �׸��� �׸��ϴ�.", 10, 50);

		g.drawOval(50, 100, 50, 50);
		
		g.setColor(Color.blue); //���� �ѹ� �����ָ� ���� ���ǵǱ��������� ���� ������ �׸��� �׸���.
		g.fillOval(100, 100, 50, 50);

		g.setColor(Color.red);
		g.drawLine(100, 100, 150, 150);
		g.fillRoundRect(200, 100, 120, 80, 30, 30);
		
		g.setColor(Color.orange);
		g.fillPolygon(new int[] { 50, 100, 150, 200 }, new int[] { 250, 200, 200, 250 }, 4);
		
		g.setColor(Color.cyan);
		g.fillArc(250, 200, 100, 100, 0, 120);
	}

	// �������� X��ư������ ������ �ʾҴ��� �������ϴ� �� =>�̺�Ʈó�� ���߿� ����
	public GraphicsEx1(String title) {
		super(title);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		setBounds(100,100,400,300);
		setVisible(true);
	}
}
