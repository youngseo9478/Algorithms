package graphicUI;
/*�̹� ������ ���������� 5������.
 * */
import java.awt.*;
public class BorderLayoutTest {

	public static void main(String[] args)
	{
		Frame f = new Frame("BorderLayoutTest");
		f.setSize(200, 200);
		//Frame�� �⺻������ �������̾ƿ��� ����Ʈ�� ���������Ƿ� ���� �������� �ʾƵ� ��
		f.setLayout(new BorderLayout());
		Button north = new Button("North");
		Button south = new Button("South");
		Button west = new Button("West");
		Button east = new Button("East");
		Button center = new Button("Center");
		
		//Frame�� 5���� �� ������ ��ư�� �ϳ��� �߰��Ѵ�.
		f.add(north, "North"); //f.add("North",north);�� ���� �� ���� �ִ�.
		f.add(south, "South");	//South�� ��ҹ��� ��Ȯ��
		f.add(west, "West");	//East ���, BorderLayout.EAST ��� ����
		f.add(east, "East");
		f.add(center,"Center");
		
		f.setVisible(true);
	}
}
