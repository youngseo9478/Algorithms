package graphicUI;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;

/*********Check Box***********
 * üũ�ڽ� �������� �׷����� ������ 
 * �� �׷쳻�� �Ӽ� �� �Ѱ������� ������ �� �ִ¶�����ư���� �ٲ��.
 * (Label�� �ܼ��ϰ� �̸� �ִ� �� 
 * ���ı���� �־ ����ϸ� ��)*/

public class CheckBoxEx1 {

	public static void main(String[] args)
	{
		Frame f = new Frame("Questions");
		//��ġ�� ���������ָ� (0,0)���� ������
		f.setSize(250,250); //����� ������ ���̾ƿ��̶� ũ�⿡ ���� �׸��� ������ �����ȴ�.->���߿� �Ұ�
		
		//Frame�� LayoutManager�� FlowLayout���� �����Ѵ�.
		f.setLayout(new FlowLayout());
		
		//�׷��� �������� �ʾұ� ������ ������ ������ �����ϴ�
		Label q1 = new Label("1. ����� ���� �оߴ�?(������ ���ð���)");
		//üũ�ڽ� ������ ������
		Checkbox news = new Checkbox("new",true); //true�� üũ�Ȼ��·� �дٴ� ��. default �� false->�ƹ��͵� üũ�Ǿ������ʴ� ����
		Checkbox sports = new Checkbox("sports");
		Checkbox movie = new Checkbox("movie");
		Checkbox music = new Checkbox("music");
		
		f.add(q1); //f�����ӿ� �׸��� �߰��ϴ� ��.
		f.add(news);
		f.add(sports);
		f.add(movie);
		f.add(music);
		
		//�׷��� ������ָ� üũ�ڽ����� ������ư���� �ٲ�Եǰ� �� �׷�ȿ� ���� ��ư�߿� �ϳ��� üũ�� �� �ִ�.
		Label q2 = new Label("2.�󸶳� ���� ���忡 ���ʴϱ�?");
		CheckboxGroup group = new CheckboxGroup();
		Checkbox movie1 = new Checkbox("�� �޿� �� �� ���ϴ�.",group,true);
		Checkbox movie2 = new Checkbox("�����Ͽ� �� �� ���ϴ�.",group,false);
		Checkbox movie3 = new Checkbox("�����Ͽ� �� �� ���ϴ�.",group,false);
		
		f.add(q2); //�׳� �޼����� �̸������� �����ӿ� ��Ÿ���ִ°� Label�� �ϴ� ��
		f.add(movie1);
		f.add(movie2);
		f.add(movie3);
		
		Label q3 = new Label("3.�Ϸ翡 �󸶳� ��ǻ�͸� ����Ͻʴϱ�?");
		CheckboxGroup group2 = new CheckboxGroup();
		Checkbox com1 = new Checkbox("5�ð� ����",group2,true);
		Checkbox com2 = new Checkbox("10�ð� ����",group2,false); 
		//^������ ������ư�� �Ѱ����� ������ �� �ֱ⶧���� ���⿡�� �� true�� �ϸ� 5�ð� ���Ͽ��� üũ�� Ǯ����.->���߿������ѰԿ켱��������
		Checkbox com3 = new Checkbox("15�ð� ����",group2,false);
		
		f.add(q3);
		f.add(com1);
		f.add(com2);
		f.add(com3);
		
		f.setVisible(true);
	}
}
