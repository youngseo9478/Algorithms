package day28;
/*call by reference
 * */
public class CallBtReferenceEx1 {

	public static void increaseArr(int[] arr)	//�迭�� �ּҰ��� �޾��� ->���� �ذ� �ƴ϶� �ּҸ� �� ��.�� ���⼭ ������Ű�� �������� ������ ����.
	{
		for(int i=0; i<arr.length; i++)
		{
			arr[i]+=1; //�ּҸ� �޾ƿ� ���̱� ������ ���⼭ ������ ��Ű�� dataArr(����)�� ����.
		}
	}
	
	public static void main(String[] args)
	{
		int[] dataArr = {1,2,3,4,5,6,7,8,9};	//dataArr�� �ּҰ���
		increaseArr(dataArr); 	//�ּҰ��� ������
		
		for(int i=0; i<dataArr.length; i++)
		{
			System.out.println(dataArr[i]);	//�ּҰ��� ���� �Լ��� ���� dataArr�� ������ 1�� �����߱⶧���� 2,3,4,5,6,7,8,9,10���� ������ �ȴ�.
		}
	}	
}
