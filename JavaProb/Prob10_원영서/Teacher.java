package prob_inheitance;

public class Teacher extends Person{

	private String subject;

	public Teacher() {
		super();
	}

	public Teacher(String subject) {
		super();
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void print(){
		System.out.printf("�̸� : %s  ���� : %d  ������ : %s%n",super.getName(),super.getAge(),subject);
	}
}
