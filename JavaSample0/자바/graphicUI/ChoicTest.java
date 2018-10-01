package graphicUI;
/*
 * add�� �ٸ��� insert�� ���ϴ� index���� �ָ� ���ڸ��� �߰����ȴ�.
 * select�� ó���� ���õǾ��ִ� �׸��� �������� �� �ִ�. index�ε� �����ϰ� �����ε� �����ϴ�
 * setAlignment �̿��ؼ� ��ġ ���������� �� �ִ�.*/
import java.awt.*;
public class ChoicTest {

	public static void main(String[] args)
	{
		Frame f = new Frame("Choice - Select"); //���ڿ��� �������� �������� �̸��� ������
		f.setSize(300,300);
		f.setLayout(null);
		
		Choice day = new Choice(); //Choice��ü������ ����
		day.add("SUN"); day.add("MON"); day.add("WED"); day.add("THU"); day.add("FRI"); day.add("SAT");
		//day.add("TUE"); �̷����ϸ� ���� ���߿� �߰��Ǵµ�
		day.insert("TUE",2); //insert() �̷����ϸ� �ε��� 2�� �߰��Ǵ°� (����°)
		day.select("FRI"); //�̷������ָ� ���ڿ� ���� ���� ��� �ʱ� ���û��·� ���� �������ִ� ���̰�
		//day.select(2);�̷����ϸ� �ε��������� ��� �ʱ� ���û��·� ���� �����ϴ� ��
		
		day.setSize(100,50);
		day.setLocation(100,70);
		
		Label label = new Label("�ȳ��ϼ���");
		label.setBounds(50, 250, 150, 40);
		label.setBackground(Color.CYAN);
		label.setAlignment(Label.CENTER); //���̺�("�ȳ��ϼ���")�� ��ġ�� �������ִ� ��
		f.add(label);
		
		f.add(day);
		f.setVisible(true);
		
	}
}
