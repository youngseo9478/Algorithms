package prob_inheitance;

public class Test_Inheritance {
	public static void main(String[] args) {
		
		Student s = new Student(200201);
		s.setName("ȫ�浿");
		s.setAge(20);
		s.print();
		
		Teacher t = new Teacher("JAVA");
		t.setName("�̼���");
		t.setAge(30);
		t.print();
		
		Employee e = new Employee();
		e.setDept("������");
		e.setAge(40);
		e.setName("������");
		e.print();
		
		
		
	}
}
