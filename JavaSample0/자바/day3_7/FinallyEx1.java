package day3_7;
/*������ ���� ���α׷��� ����Ǵ��� �� ������ �� �ȿ� �ִ� ������� ó�����ִ� ��.
 * ���� ��� ������ �������� �� �ݾƾ��ϴµ� �������ϰ� ���α׷��� �״� ��Ȳ���� finally�� �̿��ؼ� �� ó���� ���� �� �ִ�.
 * �Ǵ� �����ͺ��̽������� �����ϴ�.
 * �������� �� �������ִ� �κ�!! */

import static java.lang.System.out;

public class FinallyEx1 {

	public static void main(String[] args) {
		int[] var = { 10, 200, 30 };
		for (int i = 0; i <= 3; i++) {
			try {
				out.println((i + 1) + "��°");
				out.println("var{" + i + "] :" + var[i]); // var[3]���� ������
															// �߻��ϱ⶧���� �ٷ� catch��
															// ���� �Ʒ� ~~~~��
															// ��¾ȵǰ� �迭�� �Ѿ����ϴٺ���
															// ��µ�.�׸���
															// return�Ǳ⶧����
															// finally���ǹ��常��
															// �����ϰ� for���� ������
															// ���α׷����̶�� ������ �������
															// �ʴ´�.
				out.println("~~~~~~~~~~~~");
			} catch (ArrayIndexOutOfBoundsException ae) {
				out.println("�迭�� �Ѿ����ϴ�.");
				return; // ���⼭ ���α׷� ����Ǵ� ��. �Ʒ� ���嵵 ���� ���ϰ�! �ٵ� finally���� ������
						// ����Ǵ��� ������ �� ������!
			} finally {
				out.println(":::::finally:::::");// ������return�ϰ� ������ �̹����� ��µ� ��.
			}
		} // for�� ��
		out.println("���α׷� ��!"); // catch���忡�� return�ع��ȱ⶧���� �� ������ ������� ����.
	}
}
