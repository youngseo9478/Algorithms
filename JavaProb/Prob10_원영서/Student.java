package prob_inheitance;

public class Student extends Person {

	private int id;
	
	public Student(int id) {
		super();
		this.id = id;
	}

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * �л� ������ ����ϱ����� �޼ҵ�
	 */
	public void print(){
		System.out.printf("�̸� : %s  ���� : %d  ��    �� : %d%n",super.getName(),super.getAge(),id);
	}
	
}
