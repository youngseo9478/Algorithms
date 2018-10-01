package graphicUI;

/*�׸���鷹�̾ƿ��� 
 * ��ư ũ�⸦ �������� �� ���� 
 * �ణ �� ��ٷο� ��*/
import java.awt.*;

public class GridBagLayoutTest extends Frame {

	GridBagLayout grid = new GridBagLayout();
	GridBagConstraints con = new GridBagConstraints();

	public GridBagLayoutTest(String str) {
		super(str);
		setLayout(grid);
		// public int fill
		// This field is used when the component's display area is larger than
		// the component's requested size. It determines whether to resize the
		// component, and if so, how.
		// BOTH: Make the component fill its display area entirely.
		con.fill = GridBagConstraints.BOTH;
		con.weightx = 1.0;
		Button bt1 = new Button("��ư");
		grid.setConstraints(bt1, con);
		add(bt1);
		TextField txt = new TextField("GridBagLayout...", 15);
		txt.setBackground(Color.black);
		txt.setForeground(Color.green);
		grid.setConstraints(txt, con);
		add(txt);
		con.gridwidth = GridBagConstraints.REMAINDER;
		Button bt2 = new Button("��ư2");
		grid.setConstraints(bt2, con);
		add(bt2);
		con.gridwidth = 1;
		con.gridheight = 2;
		Button bt3 = new Button("��ư3");
		grid.setConstraints(bt3, con);
		add(bt3);

		con.gridwidth = GridBagConstraints.REMAINDER;
		con.gridheight = 1;
		con.weighty = 0.0;
		Button bt4 = new Button("��ư4");
		grid.setConstraints(bt4, con);
		add(bt4);

		Button bt5 = new Button("��ư5");
		grid.setConstraints(bt5, con);
		add(bt5);
		pack();
		setVisible(true);

	}

	public static void main(String[] args) {
		new GridBagLayoutTest("GridBagLayout����");

	}
}
