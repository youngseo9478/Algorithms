package day28;

import java.util.Scanner;

public class ArrayEx8 {

	public static void main(String[] args) {
		String[][] words = { 
								{ "chair", "����" }, 
								{ "computer", "��ǻ��" }, 
								{ "integer", "����" } 
							};
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<words.length;i++)
		{
			System.out.println("Q"+(i+1)+". "+words[i][0]+"�� ����?");
			String tmp = sc.nextLine().trim(); //���ڿ� �Է¹޴°�.
			if(tmp.equals(words[i][1]))
			{
				System.out.println("�����Դϴ�.");
			}
			else
			{
				System.out.println("Ʋ�Ƚ��ϴ�. ������ "+words[i][1]);
			}
		}
		sc.close();
	}
}
