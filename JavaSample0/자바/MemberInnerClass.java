package day4_7;

public class MemberInnerClass {

	int a = 10;
	private int b = 100;
	static int c =200;
	
	class Inner{//Inner class definition
		public void printData(){
			System.out.println("int a : "+a);
			System.out.println("private b: "+b);
			System.out.println("static int c : "+c);
		}
	}
	
	public static void main(String[] args)
	{
		//MemberInner outer = new MemberInner(); ->�̷��� �����ϸ� �ȿ� InnerŬ������ ���� ��ü�� �����ȴ�.
		//MemberInner.Inner inner = outer.new Inner();->���� ����� ��ü�� ������ �� ������ ��ü outer�� �̿��ؼ� Inner�� ��ü�� ���� �� �ִ�.
		//�̷��� �ϸ� �ι� ���ľ� �ϹǷ� ���ŷο��� �Ʒ��� ���� �ѹ��� ���� ����� �ַ� ����Ѵ�.
		MemberInnerClass.Inner inner = new MemberInnerClass().new Inner();
		inner.printData();
	}
}
