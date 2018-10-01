package day30;
/*�����ε��� ����� �żҵ带 ���������� �����ؼ� �پ��� �Ű������� ���� �� �ְ� �س��� ���̰�
 * �������̵��� ����κ��� ��ӹ��� Ŭ������ ����� �߰��ϰ���� �� �����Ǹ� �س��� ���̴�.
 * 
 * <�������̵�>
 * �θ�Ŭ������ ���� ���� �Ϸ��� ����� ������ ������ ������ 
 * �׷��� �θ�� �ϴ��� �ϰ� ���� �ʿ��ѰŸ� �߰��ؼ� ����ϴ°�.*/

class Point2D
{
	int xPoint;
	int yPoint;
	
	public Point2D() //�������� ���µ� ����� ���ÿ� ȣ���� �ٷ� �̷������ �����غ��� �� ������ ������ ��
	{
		System.out.println("point2D ������"); 
	}
	
	public Point2D(int xPoint, int yPoint)
	{	
		this.xPoint = xPoint;
		this.yPoint = yPoint;
	}
	
	public void printPoint()
	{
		System.out.println("xPoint : "+ xPoint);
		System.out.println("yPoint : "+ yPoint);
	}
}

class Point3D extends Point2D //2D�� ��ӹ޾ұ⶧���� x,y���� ������ �ִ�.
{
	int zPoint;		//print3DPoint ��� �ϸ� ���߿� �򰥸��������� �׷��� �̸��� �����ϰ�!
	
	public Point3D() //�������� ���µ� ����� ���ÿ� ȣ���� �ٷ� �̷������ �����غ��� �� ������ ������ ��
	{
		System.out.println("Point3D ������");
	}
	
	public Point3D(int xPoint, int yPoint, int zPoint)	//���� �ٸ��� �Ű������� �ִ� ����. �Ű������� int�� 3���ϱ� �ؿ��� ��ü �����Ҷ��� ���� 3�� �־�g����!
	{
		//super.printPoint(); �̰� �ƴ϶�!!
		super(xPoint,yPoint); //�θ�Ŭ������ �ּҰ��� �����ϱ� �ű⼭ x,y�� ���� �ű⿡�� �޴°�..?
		this.zPoint =zPoint;
	}
	
	public void printPoint() //�̸��� ������ z��ǥ�� �߰���  ->�Ű������� ���°� �Ȱ��ƾ��� (������Ȱ��ƾ���)  ->�����ε������� �Ű������� Ÿ��,����,������ ���̰� �־���ߴ��Ű� �ٸ�!!
	{
		//System.out.println("xPoint : "+ xPoint);
		//System.out.println("yPoint : "+ yPoint);
		//�̷��� �ߺ��Ǽ� ���� �������ϱ� ->���� ��ɿ��ٰ� ���ο� ��ɸ� ������~ �ϴ� ��.
		super.printPoint();		//->�������� �� �� �θ��� �ּҸ� ����Ű�� ��. ->�̰͵� �ƿ� ���� z���� ��Ե�
		System.out.println("zPoint : "+ zPoint);
	}
}

public class OverridingEx2 {

	public static void main(String [] args)
	{
		/*��ü������ �ΰ� ���ذ�! �ϳ��� �Ű����� �ִ� ���� �ϳ��� �Ű����� ���� ���� ->�����ε�!! ��ü�� �����Ҷ� �پ��� ���·� �ʱ�ȭ�ϱ����ؼ��̴�.
		 * 1.��ü�̸��� ���� �ٸ��� ������ �־�� �Ѵ�.
		 * 2. ��µ� �ι� (��ü���� �ٸ��� ǥ���ؼ�) */
		Point3D p3 = new Point3D(); 
		Point3D p3d = new Point3D(50,50,50); //��ü ����! ���⼭ �Ʊ� ���� 3���� ������ �Ű����� �����ϱ� ���⿡ ������ 3�� �־��ִ� ��.
		System.out.print("==========�Ű����� ���� ��===========");
		System.out.println();
		p3.xPoint =100;	//�θ�Ŭ�����κ��� ��ӹ��� x�����ٰ� 100�� ������
		p3.yPoint=200;	//�θ�Ŭ�����κ��� ��ӹ��� y�����ٰ� 200�� ������
		p3.zPoint=300;	//�ڽ�Ŭ������ z�����ٰ� 300�� ������
		p3.printPoint();
		System.out.print("==========�Ű������� �������� ��===========");
		System.out.println();
		p3d.printPoint();
		
	}
}
