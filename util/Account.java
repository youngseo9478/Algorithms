package util;

public class Account {
	// data , method
	String name;
	String num;
	int money;

	public Account() {
	}

	public Account(String name, String num, int money) {
		this.name = name;
		this.num = num;
		this.money = money;
	}

	// �Ա�
	public void deposit(int money) {
		this.money += money;
		System.out.println("�Ա�:" + money + " �ܰ�:" + this.money);
	}

	// ���
	public void withdraw(int money) {
		if (money > this.money) {
			System.out.println("�����ڵ� �ܰ� ����");
			return;
		}
		this.money -= money;
		System.out.println("���:" + money + " �ܰ�:" + this.money);
	}

	// �ܰ���ȸ
	public void display() {
		System.out.println("�����ȣ :" + num + "," + name + " �ܰ�:" + this.money);
	}

	// ������ü
	public void transfer(Account to, int money) {
		if(to == null){
			System.out.println("�������� Ȯ���ϼ���");
			return;
		}
		if (this.money < money) {
			System.out.println("�ܰ����");
			System.out.println("������ü ����");
			return;
		}
		System.out.println("��� ���� ����");
		display();
		System.out.println("�Ա� ���� ����");
		to.display();
		System.out.println("---- ������ü ���� �� ----");
		withdraw(money);
		to.deposit(money);
		System.out.println("---- ������ü �Ϸ� ----");
	}

	// ������ü
	public void transfer(Account from, Account to, int money) {
		if (from.money < money) {
			System.out.println("�ܰ����");
			System.out.println("������ü ����");
			return;
		}
		System.out.println("��� ���� ����");
		from.display();
		System.out.println("�Ա� ���� ����");
		to.display();
		System.out.println("---- ������ü ���� �� ----");
		from.withdraw(money);
		to.deposit(money);
		System.out.println("---- ������ü �Ϸ� ----");
	}
}
