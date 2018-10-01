package day30;

interface MouseInterface
{
	static final float CLICK = 0.02f;
	public void rightClick();
}

class FileC implements MouseInterface
{
	String fileName;
	
	public void rightClick()
	{
		System.out.println("File class���� ���콺 ��Ŭ���� �Ͽ����ϴ�.");
		System.out.println("File�� �̸� : "+fileName);
	}
}

class ImageC implements MouseInterface
{
	String imageName;
	int width, height;
	
	public void rightClick()
	{
		System.out.println("Image class���� ���콺 ��Ŭ���� �Ͽ����ϴ�.");
		System.out.println("image�� �̸� : "+imageName);
		System.out.println("image�� ������ => ��:"+width+", ���� : "+height);

	}
}

public class InterfaceEx2 {

	public static void main(String [] args)
	{
		FileC fc = new FileC();
		fc.fileName="education.txt";
		fc.rightClick();
		
		System.out.print("=========================");
		System.out.println();
		
		ImageC ic = new ImageC();
		ic.imageName = "study_image.bmp";
		ic.width=400;
		ic.height=200;
		ic.rightClick();
	}
}
