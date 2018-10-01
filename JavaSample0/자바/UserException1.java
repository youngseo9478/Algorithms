package day3_7;

class UserException extends Exception {
	int port;

	public UserException(String msg) {
		super(msg); // UserException�� ������ Exception���� �����߻���Ų ��ü�� ������ ��..?
	}

	public UserException(String msg, int port) // �����ε����� ��.(��������)
	{
		super(msg);
		this.port = port;
	}

	public int getPort() {
		return port; // ��Ʈ �ѹ��� �Ѱ��ִ� �޼ҵ�
	}
}

public class UserException1 {
	public void testException(String str) throws UserException // ���ܰ� �߻��Ǿ����� �긦
																// ȣ���� �޼ҵ忡�� ������
																// �������� ��.
	{
		if (str.length() >= 1) {
			System.out.println("���޹��� ���ڿ� : " + str);
		} else {
			throw new UserException("���޹��� �Է� ���� �����ϴ�.", 8989); // throw�� ���ܸ�
																// �߻���Ű�� ���̰� ó����
																// try catch����
																// ã�µ� ������
																// throwsã��
		}
	}

	public static void main(String[] args) {
		UserException1 ue = new UserException1(); // ���� ���� Ŭ���� ��ü�� ���� �� ���� 1!
		try {
			ue.testException(""); //���⼭ ������ ���°� �ƴϰ� testException���� ������ �߻��Ѱ�
									// ���⼭ ó���ϴ� ��. ������ ���ܰ� �߻��Ѱ����� ����ó���� �ؾ��ϴµ� ��
									// �κп��� try catch�� �����⶧���� throws�̿��� å�������Ѱ�
		} catch (UserException e) {
			System.out.println(e.getMessage()); // UserException�� ����Ŭ������
												// Exception�� ���� �ִ� �޼ҵ�
			System.out.println(e.getPort());
		}

	}
}
