package graphicUI;
import java.awt.*;
public class MenuTest {

	public static void main(String[] args)
	{
		Frame f = new Frame("Frame with Menu");
		f.setSize(300,200);
		MenuBar mb = new MenuBar();
		Menu mFile = new Menu("File");
		MenuItem miNew = new MenuItem("New");
		MenuItem miOpen = new MenuItem("Open");
		Menu mOthers = new Menu("Others"); //Menu���� ����(Ȯ�����·� ����� ����)
		MenuItem miExit = new MenuItem("Exit");
		
		mFile.add(miNew); //�޴��� �޴������۵��� �߰��Ѵ�.
		mFile.add(miOpen);
		mFile.add(mOthers); //�޴��� �޴��� �߰��Ѵ�.(mFile�ȿ� Ȯ�������� �޴��� �Ǵ� �� ->�޴�������X, �޴�O)
		mFile.addSeparator(); //�޴� �и����� �ִ´�.
		mFile.add(miExit);
		
		MenuItem miPrint = new MenuItem("Print...");
		MenuItem miPreview = new MenuItem("Print Preview");
		MenuItem miSetUp = new MenuItem("Print SetUp");
		
		mOthers.add(miPrint);
		mOthers.add(miPreview);
		mOthers.add(miSetUp);
		
		Menu mEdit = new Menu("Edit");
		Menu mView = new Menu("View");
		Menu mHelp = new Menu("Help");
		CheckboxMenuItem miStatusbar = new CheckboxMenuItem("Statusbar"); //üũ�ǰ� Ǯ���� �Ǵ� �޴��������� ����� ���� �������� ��.
		mView.add(miStatusbar); //mView�� �޴�������(�߰����ִ� ��)
		mb.add(mFile);	//MenuBar�� Menu�� �߰��Ѵ�.
		mb.add(mEdit);
		mb.add(mView);
		//mb.add(mOthers); mOthers�� Ȯ�����·� ���� �޴��ٿ� �ٷ� �ø��Բ� ������ ������.
		mb.add(mHelp);
		f.setMenuBar(mb); 
		f.setVisible(true);
	}
}
