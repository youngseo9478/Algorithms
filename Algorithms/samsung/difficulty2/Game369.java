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
				if(tmp%10==3||tmp%10==6||tmp%10==9){ //맨 끝자리만 검사하는 것
					flag = true;
					System.out.print("-");
				}
				tmp /= 10; //가장 끝자리를 날려버리기 위함 정수형이니까
			}
			if(tmp==3||tmp==6||tmp==9){  //여기를 i로 해버리면 예를 들어 33이었으면 와일루프안에서 10으로 나뉘어서 3이 되고 루프를 빠져나와버림. 근데 이건 체크를 안해버리니까 33이 - 라고 나옴
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
