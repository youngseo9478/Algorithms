
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class CalendarAWTEx extends Frame {

	Panel pDate = new Panel();
	Panel pUp = new Panel();

	Button btnPrevMon = new Button("<=");
	Button btnNextMon = new Button("=>");
	Label lblYearMon = new Label();

	Button[] btnArr = new Button[42];

	Calendar curMon = Calendar.getInstance();

	public CalendarAWTEx(String title) {
		super(title);
		pUp.setBackground(Color.yellow);
		pUp.setLayout(new FlowLayout(FlowLayout.CENTER));
		pUp.add(btnPrevMon);
		pUp.add(lblYearMon);
		pUp.add(btnNextMon);
		pDate.setLayout(new GridLayout(6, 7));
		for (int i = 0; i < btnArr.length; i++) {
			btnArr[i] = new Button("");
			pDate.add(btnArr[i]);
		}
		btnPrevMon.addActionListener(new BtnEventHandler());
		btnNextMon.addActionListener(new BtnEventHandler());
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				we.getWindow().setVisible(false);
				we.getWindow().dispose();
				System.exit(0);
			}
		});
		add(pUp, "North");
		add(pDate, "Center");
		setBounds(200, 200, 500, 300);
		setDays(curMon);
		setVisible(true);

	}

	void setDays(Calendar date) {
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH);
		lblYearMon.setText(year + "�� " + (month + 1) + "�� ");
		Calendar sDay = Calendar.getInstance(); // ������
		// 1. (sDay) 1 . ������ �� �ش� ���� ���� ���Ե� �Ͽ��Ϸ� �����Ѵ�
		sDay.set(year, month, 1); // 1 . �Է¿��� �Ϸ� �����Ѵ�
		sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK) + 1);
		// 2. sDay 1 . �ݺ����� ����ؼ� �� ���� �� ������Ű�鼭 ��ư�� ��¥�� �ִ´�
		for (int i = 0; i < btnArr.length; i++, sDay.add(Calendar.DATE, 1)) {
			int day = sDay.get(Calendar.DATE); // sDay day ���� ���ڸ� �̾Ƽ� �� ����
			btnArr[i].setLabel(day + "");
			// 3. (Color.white) ���� ��¥�� �ش� ���� ���ϸ� ��ư�� ������ ��� ���� �ϰ� �׷��� ������ ���� ȸ��
			// ���� �����Ѵ� (Color.lightGray) .
			if (sDay.get(Calendar.MONTH) != month) {
				btnArr[i].setBackground(Color.lightGray);
			} else {
				btnArr[i].setBackground(Color.white);
			}
		}
	} // setDays(Calendar date)

	class BtnEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			Button src = (Button) ae.getSource();
			if (src == btnPrevMon) {
				curMon.add(Calendar.MONTH, -1);
			} else if (src == btnNextMon) {
				curMon.add(Calendar.MONTH, 1);
			}
			setDays(curMon);
			repaint();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CalendarAWTEx("�޷�");
	}

}
