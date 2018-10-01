package day3_7;
/*����ó���� ������ ���ſ��� ->ó���� �� ���� ���Ƴ��� �ϴ� ��찡 ����
 * throw vs throws
 * 
 * throws: ������ �߻��ϸ� ���� �θ������� ���� ó���϶�� �ϴ� ��. =>å������
 * 
 *   ������ �߻��ϸ� try catch������ �ִ��� ã�� ������ ���� ȣ���� ������ ���� ������ ó���϶�� ���ñ� ->ó���ϴ� ���� ������ å������ ��*/ 
import static java.lang.System.out;
public class Throws1 {

	public void setData(String n) throws NumberFormatException{
		if(n.length()>=1){ //���ڿ��� �ԷµǾ������� Ȯ���ϴ� ��.
			String str = n.substring(0,1);// 0��°���� 1��° �� �տ��� �� ���ڸ� �ڸ��� ��
			printData(str);//abc�־����ϱ� �ڸ��� a�� ��
		}
	}
	public void printData(String n) throws NumberFormatException{
		int dan = Integer.parseInt(n); //a�� ���� ������ ������ �߻��� �� throw new NumberFormatException(); �� ��ü�� �����Ǵ� �� �����Ǿ�����
		out.println(dan+"��");
		out.println("-----------------");
		for(int i=0; i<9; i++){
			out.println(dan+"*"+(i+1)+"="+(dan*(i+1)));
		}
	}
	
	public static void main(String[] args) {
		Throws1 t1 = new Throws1();
		try{
			t1.setData("abc"); //���ڰ� �ƴ� ���ڰ� ��
		}catch(Exception e){
			out.println("ù ���ڰ� ���ڰ� �ƴմϴ�.");
		}
	}
}
