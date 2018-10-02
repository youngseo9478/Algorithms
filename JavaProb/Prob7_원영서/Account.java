package util;

public class Account {

	String name;
	String account;
	int balance;

	public Account() {
		this("OOO", "XXXXXX-XX-XXXXXX", 0);
	}

	public Account(String name, String acount, int balance) {

		this.name = name;
		this.account = acount;
		this.balance = balance;

	}

	public void deposit(int money) {

		if (money > 0) {
			this.balance += money;
			System.out.printf("========================================\n");
			System.out.printf("%d���� �ԱݵǾ����ϴ�.\n", money);
			System.out.printf("�ŷ� �� �ܾ� : %d��\n", this.balance);
			System.out.printf("========================================\n");
		} else {
			System.out.println("�߸��� �ݾ��Դϴ�. �ٽ� �Է����ּ���.");
		}
	}

	public void withdraw(int money) {
		if (money <= balance) {
			this.balance -= money;
			System.out.printf("========================================\n");
			System.out.printf("%d���� ��ݵǾ����ϴ�.\n", money);
			System.out.printf("�ŷ� �� �ܾ� : %d��\n", this.balance);
			System.out.printf("========================================\n");
		} else {
			System.out.println("�ܰ� �����Դϴ�.");
			System.out.printf("���� ������ �ܰ�� %d�� �Դϴ�.\n ", this.balance);
		}
	}

	public void transfer(String who, int money) {
		if (money <= balance) {
			this.balance -= money;
			System.out.printf("========================================\n");
			System.out.printf("%s�� ���·κ���  %s�� ���·� %d���� �ԱݵǾ����ϴ�.\n", this.name, who, money);
			System.out.printf("�ŷ� �� �ܾ� : %d��\n", this.balance);
			System.out.printf("========================================\n");
		}
		else{
			System.out.println("�ܰ� �����Դϴ�.");
			System.out.printf("���� ������ �ܰ�� %d�� �Դϴ�.\n ", this.balance);			
		}
	}

	public void accountInfo() {
		System.out.printf("=========== %s�� ���� ���� ==========\n", name);
		System.out.printf("�����ָ� : %s\n���¹�ȣ : %s%n�ܰ� : %d%n", name, account, balance);
		System.out.printf("========================================\n");

	}
}
