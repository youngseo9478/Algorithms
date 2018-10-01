package day29;
/*���
 * ��ü������ �ٽ�
 * ����� �����ִ� �ֿ� ����� �޴� �ְ� �ִ�.
 * �����ִ¾ָ� -> ����Ŭ���� (=�θ�Ŭ����)
 * ������޴¾ֵ� -> ����Ŭ����(=�ڽ�Ŭ����)
 * 
 * ����� �� �� ����ϴ� ���� �ִ�!
 * 	-> �ڽ�Ŭ���� extends �θ�Ŭ����
 * ������ ����� ���� ���� �״�� ���鼭 �ش��ϴ� ��ɸ� �߰��� �� �ְԵ�
 *  ->���ڵ��� �� �ʿ䰡 ����  **���꼺�������� �������� ��������
 * 
 * ��ü�� �����Ҷ� �� �ȿ� �θ𿵿��� �ڽĿ����� �и��Ǿ� �ְ� �ѿ��� ���⿡ �ϳ�ó�� �ൿ�ؼ� 
 * �ᱹ �ϳ��� ��ü�� ����ȴ�. --> Mp3Phone Ŭ������ ������ ���� ��ü���� call, sendSMS�� ��Ÿ�� �� �ִ°� ��ġ ���� Mp3PhoneŬ������ �ִ°�ó��!!
 * 
 * �ڹ��� ���� ���ϻ�Ӹ� ����
 * C++�� ��� ���߻�ӵ� ����
 * 
 * ��� �� ������? ���ϻ��, ���� �ǹ������� ���߻�� ���� �Ⱦ�
 * 
 * ���߻���� ������ �ʹ� ���Ƽ� �����
 * -���� ����� ������ �� �� �ִٴ°� ������ ...(����� �ϴ� ������ �ڵ��� ������ ����)->��ӹ��� �Ӽ��� �״�� �����ؾ��ϴµ� ���߻���ϸ� �� �Ӽ��� ����������
 * -������ �����ؾ��ϴ��� ������� �����ؾ��ϴ��� �򰥸��Ե� (�����ƿ�����������)
 * 
 * */

class CellPhone //��ȭ���� ����� ���� Ŭ����
{
	String maker;
	String number;
	
	public void call(String number)
	{
		System.out.println(number+"���� ��ȭ�� �մϴ�.");
	}
	
	public void sendSMS(String num, String message)
	{
		System.out.println(num+"���� '"+message+"' �޼����� �����ϴ�.");
	}
	
}

class Mp3Phone extends CellPhone  //��ȭ���� ����� ��ӹ��� ���Ǿ�������� �߰��� ����� ���� Ŭ����
{
	String musicName;
	
	public void playMp3(){
		System.out.println(musicName+"�� ����մϴ�.");
	}
}

class SmartPhone extends Mp3Phone //��ȭ,����,������� ����� ��� ��ӹ��� ����Ʈ�� Ŭ����
{
	int pixel;
	
	public void takePictur()
	{
		System.out.println(pixel+"ȭ���� ������ ����ϴ�.");
	}
}
public class Inheritance {

	public static void main(String[] args)
	{
		Mp3Phone m3 = new Mp3Phone();
		//Mp3Phone���� ���ǵ��� ���� �޼ҵ��ε� ���⼭ ����� ����
		m3.call("010-7878-8989");
		//���� ���ǵ��� ���� �޼ҵ��ε� ����� ���� -->����� �̷�����⶧���� Mp3Phone class�� ���Ǿ����� ���ؼ��� ������ �� ������ ����� CellPhone���κ��� �޾Ҵ�.
		m3.sendSMS("010-4545-5656", "hello");
		m3.musicName = "it has to be you";
		m3.playMp3();
		
		System.out.println("=========================================");
		
		SmartPhone sp = new SmartPhone();
		sp.pixel = 10000; //�ȼ����� �����ִ� ��.
		sp.call("010-5580-8707"); // ��ȭ�� �ϰ�
		sp.sendSMS("010-8485-1407", "I love you"); //���ڵ� �ް�
		sp.musicName = "my way"; //�뷡 ������ ������
		sp.playMp3(); //�� �뷡�� �����
		sp.takePictur(); //������ ����
	}

}
