package day10_7;

import javax.swing.JOptionPane;

//�Է��� �ϵ� ���� ī��Ʈ �ٿ����ϰ� �; ��Ƽ�����带 �̿��� ��
class CountThread extends Thread {
	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadEx1 {

	public static void main(String[] args) {
		CountThread cthread = new CountThread();
		cthread.start();
		String input = JOptionPane.showInputDialog("input string");
		System.out.println("inputed str : " + input);
	}
}
