package book.ver02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 *
 */
public class BookMgr {

	ArrayList<Book> bookList = new ArrayList<Book>();
	ArrayList<Book> books = new ArrayList<Book>();
	int count = 0;

	public BookMgr() {
	}

	public BookMgr(ArrayList<Book> bookList) {
		super();
		this.bookList.addAll(bookList);
	}

	/**
	 * 1.���� ����� ����ϴ� �޼ҵ�
	 */
	public void printBookList() {
		System.out.println();
		System.out.println("============ ���� ���============");
		for (int i = 0; i < bookList.size(); i++) {
			System.out.printf("[%d	%s]%n", i + 1, bookList.get(i).getTitle());
		}
		System.out.println();
		System.out.println();
	}

	/**
	 * 2.Book��ü�� bookList�� ����ϴ� �޼ҵ�
	 * 
	 * @param book
	 */
	public void addBook(Book book) {

		bookList.add(book);
		System.out.println();
		System.out.printf("��%s �԰�", book.getTitle());
		System.out.println();
		System.out.println();
	}

	/**
	 * 3.�Ű� ���� ����Ʈ�� ����ϴ� �޼ҵ�
	 * 
	 * @param booklist
	 *            : �߰��� ���� ����Ʈ
	 */
	public void addBookList(String fileName) {

		System.out.println();
		System.out.println("���Ű� ����Ʈ �԰�");
		try (Scanner book = new Scanner(new File(fileName))){
			while(book.hasNextLine()){
				String readLine = book.nextLine().trim();
				String[] datas = readLine.split("/");
				books.add(new Book(datas[0],Integer.parseInt(datas[1])));
				System.out.println(datas[0]);
			}
			bookList.addAll(books);
			books.removeAll(books);
			
		} catch (FileNotFoundException e) {
			System.out.println("������ �������� �ʽ��ϴ�.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally{
			printBookList();
		}
	}

	/**
	 * 4.�˻��� ������ ���������� ����ϴ� �޼ҵ�
	 * 
	 * @param title
	 *            : �˻��� ������
	 */
	public void printPrice(String title) {

		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getTitle().equalsIgnoreCase(title)) {
				System.out.printf("���˻��Ͻ� ���� : %s%n������ ���� : %d%n",title,bookList.get(i).getPrice());
			}
			if(i==bookList.size()&&bookList.get(i).getTitle().equalsIgnoreCase(title)){
				System.out.printf("�ذ˻��Ͻ� ����  %s��/�� �������� �ʽ��ϴ�.",title);
				return;
			}
		}
		System.out.println();
		System.out.println();
	}

	/**
	 * 5.���ϴ� å ����� �����ϴ� �޼ҵ�
	 * 
	 * @param title
	 */
	public void removeBook(String title) {
		for (int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getTitle().equalsIgnoreCase(title)){
				bookList.remove(i);
			}
			if(i==bookList.size()-1&&bookList.get(i).getTitle().equalsIgnoreCase(title)){
				System.out.println("�������� �ʴ� �����Դϴ�.");
				return;
			}
		}
		System.out.printf("�� %s ���� �Ϸ� ��",title);
		printBookList();
	}

	/**
	 * �������� ������ ���� �հ�
	 */
	public void printTotalPrice() {
		int sum = 0;
		for (int i = 0; i < bookList.size(); i++) {
			sum += bookList.get(i).getPrice();
		}
		System.out.println("___________________________");
		System.out.printf("å ������ ���� :	%d%n",sum);
		System.out.println();
		System.out.println();
	}
	

}
