package difficulty2;

import java.util.Scanner;

public class Game369 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 1; i <= num; i++) {
			int tmp = i;
			boolean flag = false;
			while(tmp/10!=0){
				if(tmp%10==3||tmp%10==6||tmp%10==9){ //�� ���ڸ��� �˻��ϴ� ��
					flag = true;
					System.out.print("-");
				}
				tmp /= 10; //���� ���ڸ��� ���������� ���� �������̴ϱ�
			}
			if(tmp==3||tmp==6||tmp==9){  //���⸦ i�� �ع����� ���� ��� 33�̾����� ���Ϸ����ȿ��� 10���� ����� 3�� �ǰ� ������ �������͹���. �ٵ� �̰� üũ�� ���ع����ϱ� 33�� - ��� ����
				System.out.print("-");
				flag = true;
			}
			if(!flag){
				System.out.print(i+" ");
			}else{
				System.out.print(" ");
			}
		}
		sc.close();
	}
}
