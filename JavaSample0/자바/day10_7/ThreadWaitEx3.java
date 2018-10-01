package day10_7;
//��Ƽ������� ���ÿ� �������� �����尡 ����ǰ��ִ°��̶�°� ����ϱ�! 
//�����췯�� ���ؼ� run������ �������⶧���� ��� ����� �޶��� sleep�س��� �ð��� wait notify�Ǵ� ������
//�� �׻��̿� sleep�Ǿ����� ���̰� �ƴ� Ÿ�̹� �� ���� ����� �޶��� 
//�ð����� ���ؼ� ���̴°� �޶����� �� �� ������ ������� �ڽ��� sleep�ð��� ���缭 �ൿ�ϰ��ִ� ��!
//wait�Ǿ��ٰ� notify�Ǵ� ���� �ٽ� �����....


/**************Wait�� Notify�޼ҵ� ����ϴ� ���***************
 * ��Ƽ�������̸鼭 �Ӱ迵���� �������� ����� ��쿡�� �ߺ������� ���� ����/����
 * �ǰų� Ȥ�� ���̴� ������ ����ϰ� �߻��Ѵ�.
 * �̸� �����ϰ����ؼ� synchronized�� ����ؼ� Lock�� �ɾ��ְԵǴµ�
 * �ϳ��� �����尡 ��� ������ �����Ҷ����� ����ִ� ��� ���ϴ� ���� ���� ���ϰ� 
 * �Ǵ� ��찡 ����. �׷��� wait�� notify�� �̿��ؼ� ������ ���� ������
 * �ڵ尡 ����ǵ��� ����� �� �� �ִ�.*/

/**************************************
 * ���ĵ����͸� ���ڿ� Ÿ���� �迭����Ʈ�� ���� ���̴�.*
 * ************************************/
import java.util.ArrayList;



/********************************
 * <Customer1 : ��>
 * Table : ������ �÷����� �뵵
 * food : ���̺� �ø����°� � ��������
 ********************************/
class Customer1 implements Runnable {
	private Table table;
	private String food;

	Customer1(Table table, String food) {
		this.table = table;  
		this.food  = food;
	}

	/***�����尡 � �ൿ�� �� �� �������ִ� �޼ҵ�***/
	public void run() {
		while(true) { //�Դ� ���ݿ� 0.1�� ������ �ְ� ������⶧���� �ѹ��԰� cook�̿ü����ְ� �ٸ� ���� ���� ���� �ִ� ��...�ð��������� �������ٸ����
			try { Thread.sleep(100);} catch(InterruptedException e) {}
			/*���� �������� �������� �̸��� name�� ����*/
			String name = Thread.currentThread().getName();
			
			/*���̺� ��ü�� remove�޼ҵ带 �̿��Ͽ� ������ food�� �Ծ� ����*/
			table.remove(food);
			System.out.println(name + " ate a " + food);
		} // while
	}
}


/********************************
 * <Cook : �丮��>
 * Table : ������ �÷����� �뵵
 * food : ���̺� �ø����°� � ��������
 ********************************/
class Cook implements Runnable {
	private Table table;
	
	Cook(Table table) {	this.table = table; }

	public void run() {
		while(true) {
			int idx = (int)(Math.random()*table.dishNum());
			table.add(table.dishNames[idx]);
			try { Thread.sleep(10);} catch(InterruptedException e) {}
		} // while
	}
}



/********************************
 * <Table : �մԲ� ������ �ø��� ��>
 * Table : ������ �÷����� �뵵
 * food : ���̺� �ø����°� � ��������
 ********************************/
class Table {
	String[] dishNames = { "donut","donut","burger" }; // donut�� Ȯ���� ���δ�.
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();

	public synchronized void add(String dish) {
		while(dishes.size() >= MAX_FOOD) {
				String name = Thread.currentThread().getName();
				System.out.println(name+" is waiting.");
				try {
					wait(); // COOK�����带 ��ٸ��� �Ѵ�.
					Thread.sleep(500);
				} catch(InterruptedException e) {}	
		}
		dishes.add(dish);
		notify();  // ��ٸ��� �ִ� CUST�� ����� ����.
		System.out.println("Dishes:" + dishes.toString());
	}

	public void remove(String dishName) {

		synchronized(this) {	
			String name = Thread.currentThread().getName();

			while(dishes.size()==0) {
					System.out.println(name+" is waiting.");
					try {
						wait(); // CUST�����带 ��ٸ��� �Ѵ�.
						Thread.sleep(500);
					} catch(InterruptedException e) {}	
			}

			
			while(true) {
				for(int i=0; i<dishes.size();i++) {
					if(dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						notify(); // ���ڰ� �ִ� COOK�� ����� ���� 
						return;
					}
				} // for���� ��

				try {
					System.out.println(name+" is waiting.");
					wait(); // ���ϴ� ������ ���� CUST�����带 ��ٸ��� �Ѵ�.
					Thread.sleep(500);
				} catch(InterruptedException e) {}	
			} // while(true)
		} // synchronized
	}

	public int dishNum() { return dishNames.length; }
}

class ThreadWaitEx3 {
	public static void main(String[] args) throws Exception {
		Table table = new Table();

		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer1(table, "donut"),  "CUST1").start();
		new Thread(new Customer1(table, "burger"), "CUST2").start();
	
		Thread.sleep(10000); //�� ���α׷��� ���ư��� �ð��� 10�ʷ� �а�
		System.exit(0);
	}
}
