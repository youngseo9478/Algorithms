package day3_7;

/*throw�� ������ exception�� �߻���Ű�� ��ɾ�*/
public class Throw1 {
	public static void main(String[] args) {
		try {
			throw new NumberFormatException();
			// ������ ���ܹ߻���Ű�� �� throws�� ����ص� �̺κ��� �����Ȱ�.
		} catch (NumberFormatException ne) {
			System.out.println("^^");
		}
	}
}
