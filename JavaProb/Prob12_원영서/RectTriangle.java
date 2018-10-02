package day13.prob;

public class RectTriangle extends Shape {
	double width;
	double height;

	/**
	 * ����Ʈ ������
	 */
	public RectTriangle() {
		super();
	}

	/**
	 * �����ﰢ���� �غ��� ���̸� �ʱ�ȭ�ϴ� ������
	 * 
	 * @param width
	 * @param height
	 */
	public RectTriangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	/**
	 * �����ﰢ���� ���̸� ���ϴ� �޼ҵ�
	 */
	@Override
	double getArea() {
		return width * height * (0.5);
	}

}
