package day3_7;
/*try catch�� ������ ����ϴ� ���*/

public class ExceptionEx2 {

	public static void main(String[] args) {
		// String strNum = "10";
		// String strNum = "a"; //Exception in thread "main"
		// java.lang.NumberFormatException: For input string: "a"
		String strNum = "0";
		int result = 0;
		try {// strNum�� ���ڰ��������� ����ó�� �κ�
			int num = Integer.parseInt(strNum);// ���ڿ��� ������ �ٲ㼭 �޴�
			result = 100 / num;
		}/*catch(Exception e){//���������� ������ �ڽ��� ������ ������ �� ����. exception�� ����Ŭ�����̱⶧���� Number...,Arith..���� �ٲ���Ȱ� ó�� �ϰ� ��
		// ����Ŭ������ ����ó���� �ϰԵǴ� ��.
			//����ȭ�ؼ� ����ó���� �� ���� ����Ŭ�������� �־��־�� �ϰ� �׳� ��°�� ó���ϰ���� �� ��ó�� ����Ŭ������ ����������.  
			System.out.println("��� exception ó��");
		} */catch (NumberFormatException ne) {//catch�� �Ұ�ȣ �ȿ� �ִ� ���� ������ �߻��Ǿ����� �����Ǵ� ��ü �̸�
			System.out.println("�Է��Ͻ� ���� ������ �ƴմϴ�. �ٽ� �Է��� �ּ���");
		} catch (ArithmeticException ae) { //multi catch
			System.out.println("���ڴ� 0���� ���� �� �����ϴ�.");
		}
		System.out.println("result : " + result);
	}
}
