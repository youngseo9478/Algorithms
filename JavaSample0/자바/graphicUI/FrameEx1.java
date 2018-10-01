package graphicUI;
/*********GUI**********
 * �� �߿��� Frame (���帹�̾��̴�Ŭ����)*/
import java.awt.Frame;
class InheritFrame extends Frame //Frame ���
{
	public InheritFrame(String str)
	{
		//super�� ���������� �� �θ�����ڸ� ȣ���ϴ� ��.
		super(str); //str(Ÿ��Ʋ)�� Frame���� �Ѱ��ִ� ��
		
		setSize(300,300);
		setLocation(500,500); //��ġ����
		setVisible(true);
	}
}
public class FrameEx1 {

	public static void main(String[] args)
	{
		Frame f = new Frame("First Frame");//"First Frame"�� Ÿ��Ʋ�� 
		f.setSize(400,200); //setSize(width, height) ->������ �ȼ�  400X200�ȼ�
		f.setVisible(true); //�����Ѱ� �� ��
		
		new InheritFrame("InheritFrame"); //���⼭ ��ü�� ��������� InheritFrame�� ������ �Ǵ� ��.
	}
}
