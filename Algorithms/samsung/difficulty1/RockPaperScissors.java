package difficulty1;

import java.util.Scanner;
//A와 B가 가위바위보를 하였다. 
//
//가위는 1, 바위는 2, 보는 3으로 표현되며 A와 B가 무엇을 냈는지 입력으로 주어진다.
//
//A와 B중에 누가 이겼는지 판별해보자. 단, 비기는 경우는 없다.
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
