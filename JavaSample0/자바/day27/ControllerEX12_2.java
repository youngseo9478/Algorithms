package day27;

public class ControllerEX12_2 {//3.6.9���� �����Ѱ�
	
	public static void main(String[] args)
	{
		for(int i=1;i<=100;i++)
		{
			System.out.print(i);	//¦�� ���� �ܶ��� ǥ���ϱ� ���ؼ� ���� print�� ���!
			int tmp = i;
			
			do{
				if((tmp%10)%3==0 && tmp%10!=0)
					System.out.print(" ¦!"); //println�� �ƴ϶� print�Ἥ �ܶ��� �ٲ��� ����
			}while((tmp/=10)!=0);	//33.36������ ¦ �ι��ľ��ϴ� �� �Ÿ��� ����! 33/10�� 3�̱⶧���� �̰� �ٽ� do while�Ἥ ¦!
			System.out.println();
		}
	}

}
