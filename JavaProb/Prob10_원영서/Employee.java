package prob_inheitance;

public class Employee extends Person{

	private String dept;
 
	public Employee() {
		super();
	}

	public Employee(String dept) {
		super();
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public void print(){
		System.out.printf("�̸� : %s  ���� : %d  ��    �� : %s%n",super.getName(),super.getAge(),dept);
	}
}
