package day28;
/*capsulation
 * ĸ���� Ư¡
 * -����ȭ 
 *
 *���� ������ :���� ����� �� �ְ� ���ִ��ĸ� ����
 *public -> �ƹ��� ���ٽᵵ ok
 *private -> ���ο����� ����� �� ����
 *	->�־���? ���� �ܺο� �������� �ȵǴ� �͵��� ����. �̷��͵��� ���ο����� ������ �� �ְԲ� �ؾ��Ѵ�. �̰� �ٷ� '����'
 *	-->���еǾ������� ��� ����? '***����������!***'
 *
 **/

class AccessEx
{
	public String name;
	private int weight;
	
	public void setWeight(int w)
	{
		weight = w;
	}
	
	/*public int getWeight()	??���ֵ� �����̵Ǵµ�...����..	//���� ���������ϱ� �̷��� �����;��� '����������'�־��ִ� ����!!***
	{
		return weight;
	}*/
	
	public void printInfo()
	{
		System.out.println("name : "+name);
		System.out.println("weight : "+weight);
	}
}

public class Capsulation {

	public static void main(String[] args)
	{
		AccessEx ae = new AccessEx();
		ae.name = "�谡";
		ae.setWeight(90);
		//int getW=ae.getWeight();
		//ae.weight = 80;		//������ �� ����  The field AccessEx.weight is not visible
		ae.printInfo();
	}
}
