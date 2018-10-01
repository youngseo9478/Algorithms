package graphicUI;
/*******List**********
 * List(6,true) ->true�� ��Ƽ���� �����ϴ°�
 * �׸��� �� ���ڴ� int row�� �ش��ϴµ� ����� �켱������ ��.
 *  �׷��� 6����߾ �Է°��� 7���̸� 7���� ��Ÿ��
 * replaceItem�� ���õ� �������� ���� �ƿ� �ٲ��ִ� ��*/
import java.awt.*;

public class ListTest {

	public static void main(String[] args)
	{
		Frame f = new Frame("List - Select");
		f.setSize(300,200);
		f.setLayout(null);
		
		List selectOne = new List(0); //6���� ����� ������ �� �ִ� ũ���� List�� �����.
		selectOne.setLocation(20,40);
		selectOne.setSize(100,200);
		selectOne.add("student");
		selectOne.add("Teacher");
		selectOne.add("Driver");
		selectOne.add("Computer Programmer");
		selectOne.add("Sales Man");
		selectOne.add("Musician");
		selectOne.add("Director");
		selectOne.replaceItem("Programmer",2); //2�� �ε��� ���� Programmer�� �ٲٴ� �޼ҵ�
		
		//�������� �ι�° ���ڰ��� true�� �����ؼ� List�� ��Ͽ��� ���� ���� ������ �� �ְ� �ߴ�.
		List selectMany = new List(6,true);
		selectMany.setLocation(150,40);
		selectMany.setSize(100,120);
		selectMany.add("student");
		selectMany.add("Teacher");
		selectMany.add("Driver");
		selectMany.add("Computer Programmer");
		selectMany.add("Sales Man");
		selectMany.add("Musician");
		selectMany.add("Director");
				
		f.add(selectOne);
		f.add(selectMany);
		f.setVisible(true);
	}
}
