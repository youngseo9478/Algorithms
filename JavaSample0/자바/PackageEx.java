package day3_7;
/*��Ű��
 * static import��
 * 
 * system.out. ġ�� ��Ű������ �ҷ����� ��.
 * import static[package path.class name.*]
 * �̷��� ����ϸ� out.print���ص���
 * ������ �������⶧���� ������ �����ϰ� 
 * �ϴ� ��*/

import static java.lang.Math.*;
import static java.lang.System.out;

public class PackageEx {

	public static void main(String[] args)
	{
		int i = (int)(random()*26+65);
		out.println((char)i);
	}
	
}
