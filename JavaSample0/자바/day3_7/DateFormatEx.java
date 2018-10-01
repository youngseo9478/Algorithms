package day3_7;

import java.util.*;
import java.text.*;

public class DateFormatEx {

	public static void main(String[] args) {
		Date today = new Date(); // Date�� utilŬ����������. Calendar�ȿ� �ִ°� X Date Ŭ������
									// �̿��� today��� ��ü�� ����.
		//Date()�� Allocates a Date
		// object and initializes it so that it
		// represents the time at which it was
		// allocated, measured to the nearest
		// millisecond.
		SimpleDateFormat sdf1, sdf2, sdf3, sdf4; //text ��Ű���� �ִ� Ŭ����
		SimpleDateFormat sdf5, sdf6, sdf7, sdf8, sdf9;

		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("''yy�� MMM dd�� E����");
		sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		sdf5 = new SimpleDateFormat("������ �� ���� D��° ���Դϴ�.");
		sdf6 = new SimpleDateFormat("������ �� ���� d��° ���Դϴ�.");
		sdf7 = new SimpleDateFormat("������ �� ���� w��° ���Դϴ�.");
		sdf8 = new SimpleDateFormat("������ �� ���� W��° ���Դϴ�.");
		sdf9 = new SimpleDateFormat("������ �� ���� F��° E�����Դϴ�.");

		System.out.println(sdf1.format(today));// format(Date d)
		System.out.println(sdf2.format(today));
		System.out.println(sdf3.format(today));
		System.out.println(sdf4.format(today));
		System.out.println();
		System.out.println(sdf5.format(today));
		System.out.println(sdf6.format(today));
		System.out.println(sdf7.format(today));
		System.out.println(sdf8.format(today));
		System.out.println(sdf9.format(today));
	}
}
