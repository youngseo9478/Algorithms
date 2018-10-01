package day4_7;

/*���̽�����
 * ������ Ŭ���� �� �ϳ�
 * ChoiceFormat�� Ư�� ������ ���ϴ� ���� ���ڿ��� ��ȯ���ش�. 
 * ������ �Ǵ� �ҿ������� ������ ������ ó���ϴµ� �־ if���̳� switch���� �������� ���� ��찡 ����. 
 * �̷��� ChoiceFormat�� �� ����ϸ� �����ϰ� ó���� �� �ۿ� ������ �ڵ带 �����ϰ� ���������� ���� �� �ִ�.*/
//import java.util.*;
import java.text.*;

public class ChoiceFormatEx1 {

	public static void main(String[] args) {
		double[] limits = { 60, 70, 80, 90 }; // ���� ������ ū ���� ������ ������Ѵ�.
		String[] grades = { "D", "C", "B", "A" };// limits�� grades���� ������ ������ �����
													// �Ѵ�.

		int[] scores = { 100, 95, 88, 70, 52, 60, 70 };
		// ���̽� ������ limit�� grade�� �޾Ƽ� ������ ��� �� ��ü�� ���Ե� format�޼ҵ带 �̿��ؼ� ���Ͽ� �����
		// �ű� �� �ִ�.
		ChoiceFormat form = new ChoiceFormat(limits, grades);

		for (int i = 0; i < scores.length; i++) {
			System.out.println(scores[i] + " : " + form.format(scores[i]));
		}
		System.out.print("===================");
		System.out.println();
		// ��Ʈ��ŷ������ ����ó�� ������ ������ ����ֱⰡ �򰥷��� ������������ ���� �����.
		String patter = "60#D|70#C|80#B|90#A"; // ���ڿ� ������ ����� ������ ������ ����� ����
		ChoiceFormat form2 = new ChoiceFormat(patter);
		for (int i = 0; i < scores.length; i++) {
			System.out.println(scores[i] + " : " + form2.format(scores[i]));
		}
	}
}
