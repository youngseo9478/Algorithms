package day27;

public class ControllerEx4 {	//switch case�� ->if���� �б������� switch case���� ã�ư��� ��
								//case�� ����� �ְ� ���� �������� ���⶧���� if���� �� �ٸ���.
								//������ �������� ������ ���ſ� ���̶� ���� ����ϸ� ����ð��� �����ɸ���.
	public static void main(String[] args)
	{
		int score = 3;
		switch(score*100)	//��ȣ�ȿ� ����, ĳ����, ���ڿ� ���� �� �ִ�. ->���ڿ��� 1.8�������͸� ����
		{
		case 100:		//�����ݷ� �ƴϰ� �ݷ�!
			System.out.println("����� ������ 100�̰�, ��ǰ�� ������ �Դϴ�.");
			break;		//�ϳ��� ���̽��� �����ϰ� switch���� ��ĥ ���� break�� �ʿ��ϴ�.
						//���������� �����Ϸ��� case���������� break�� �� �������.
		case 200:		//break�� ���� ������ switch ���� ���������� �ʰ� ��� ���̽��� ����ȴ�.
			System.out.println("����� ������ 200�̰�, ��ǰ�� TV �Դϴ�.");
			break;
		case 300:
			System.out.println("����� ������ 300�̰�, ��ǰ�� ��Ʈ�� �Դϴ�.");
			break;
		case 400:
			System.out.println("����� ������ 400�̰�, ��ǰ�� �ڵ��� �Դϴ�.");
			break;
		default:	//switch case �� ��� ������ ������ �ʴ� ��� ����Ǵ� ����
			System.out.println("�˼������� ����� ������ �ش� ��ǰ�� �����ϴ�.");
		}
	}
}
