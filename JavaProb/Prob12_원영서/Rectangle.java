package day13.prob;

public class Rectangle extends Shape implements Resizable {

	double width;
	double height;

	/**
	 * ����Ʈ ������
	 */
	public Rectangle() {
		super();
	}

	/**
	 * ���簢���� �غ��� ���̸� �ʱ�ȭ�ϴ� ������
	 * 
	 * @param width
	 * @param height
	 */
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	/**
	 * �簢���� ���̸� ���ϴ� �޼ҵ�
	 */
	@Override
	double getArea() {
		return width * height;
	}

	/**
	 * ����� �����ϴ� �޼ҵ�
	 */
	@Override
	public void resize(double s) {
		width *= s;
		height *= s;
	}

}
