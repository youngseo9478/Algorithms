package day29;
//��������
public class Example2 {

	public static void main(String[] args)
	{
		int random = 0;
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			random = (int) (Math.random() * 10);
			arr[i] = random;
		}
		System.out.println("���� �߻���Ų �迭");
		for (int i = 0; i < arr.length; i++) {
			//System.out.print("arr[" + i + "] = " + arr[i]);
			System.out.print(arr[i]);
		}
		System.out.println();
		System.out.println("==========");
		
		int tmp =0;
		//i�� ���ǽ��� �߿��ѵ� ������ �ȳ����� <arr.length���ϸ� j�� arr[10]���� ���ع����Ƿ� 
		//i<arr.length-1**********�߿�
		for(int i=0; i<arr.length-1; i++)
		{
			for(int j=i+1; j<arr.length; j++)
			{
				if(arr[j]<arr[i])
				{
					tmp=arr[j];
					arr[j]=arr[i];
					arr[i]=tmp;
				}
			}
		}
		
		System.out.println("������������ ���ĵ� �迭");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}

	}
}
