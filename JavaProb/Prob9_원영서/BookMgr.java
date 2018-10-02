package prob;

/**
 * 
 * @author ������
 * @since 2017.11.09
 *
 */
public class BookMgr {

	Book[] bookList = new Book[50];
	int count = 0;
	// count : �迭�� �ε����� �����ϱ����� ������ ������ ������ ����

	/**
	 * �⺻ ������
	 */
	public BookMgr() {

	}

	/**
	 * bookList��� �迭 ������ �ʱ�ȭ�ϴ� ������ �޼ҵ�
	 * 
	 * @param booklist
	 */
	public BookMgr(Book[] booklist) {
		for (int i = count; i < booklist.length; i++) {
			this.bookList[i] = booklist[i];
		}
		count += booklist.length;
	}

	/**
	 * Book��ü�� bookList�� ����ϴ� �޼ҵ�
	 * 
	 * @param book
	 */
	public void addBook(Book book) {

		this.bookList[count] = book;
		count++;
	}

	/**
	 * �Ű� ���� ����Ʈ�� ����ϴ� �޼ҵ�
	 * 
	 * @param booklist
	 *            : �߰��� ���� ����Ʈ
	 */
	public void addBookList(Book[] booklist) {
		for (int i = count; i < booklist.length; i++) {
			this.bookList[i] = booklist[i];
		}
		count = count+ booklist.length;
	}

	/**
	 * ���� ����� ����ϴ� �޼ҵ�
	 */
	public void printBookList() {
		System.out.println();
		System.out.println("============ ���� ���============");
		for (int i = 0; i < count; i++) {
			System.out.println(bookList[i].getTitle());
		}
	}

	/**
	 * �˻��� ������ ���������� ����ϴ� �޼ҵ�
	 * @param title : �˻��� ������
	 */
	public void printPrice(String title) {
		if (count == 0) {
			System.out.println("����Ʈ�� �������� �ʽ��ϴ�.\n������ �߰����ּ���");
			System.out.println();
			return;
		} else {
			for (int i = 0; i < count; i++) {
				if (bookList[i].getTitle().equals(title)) {
					System.out.print("���˻��Ͻ� ���� : ");
					System.out.println(bookList[i].getTitle());
					System.out.print("������ ���� : ");					
					System.out.println(bookList[i].getPrice());
				}
			}
		}
	}
	
	public void removeBook(String title){
		for (int i = 0; i < count; i++) {
			if(bookList[i].getTitle().equals(title)){
				for (int j = i+1; j < count; j++) {
					bookList[i]=bookList[j];					
				}
				count--;
				break;
			}
		}
	}

	/**
	 * �������� ������ ���� �հ�
	 */
	public void printTotalPrice() {
		int sum = 0;
		for (int i = 0; i < count; i++) {
			sum += bookList[i].getPrice();
		}
		System.out.println();
		System.out.println("=== å ������ ���� ===");
		System.out.printf("����� å ������ �� : %d%n", sum);
	}

}
