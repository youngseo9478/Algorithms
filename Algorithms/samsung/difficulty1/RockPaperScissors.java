package difficulty1;

import java.util.Scanner;
//A�� B�� ������������ �Ͽ���. 
//
//������ 1, ������ 2, ���� 3���� ǥ���Ǹ� A�� B�� ������ �´��� �Է����� �־�����.
//
//A�� B�߿� ���� �̰���� �Ǻ��غ���. ��, ���� ���� ����.
public class RockPaperScissors {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		if((A==1&&B==3)||(A==2&&B==1)||(A==3&&B==2)){
			System.out.println("A");
		}
	}
}
