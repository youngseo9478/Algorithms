package day27;

public class ControllerEx2 {	// if���ǹ� Ȯ�� ->else if
	public static void main(String[] args)
	{
		int subjectNumber =94;
		 if(subjectNumber>90)
		 {
			 if(subjectNumber>97)	//if�� �ȿ� if���� �����ϴ� ->������ȭ�� �б� ������ 2depth
			 {	//2depth�̻��� �Ⱦ��°� ���� �򰥸��� �Ѵ��� ������ �ʴ´�.
			 System.out.println("����� ������ A+�Դϴ�.");
			 } 
			 else if(subjectNumber>93)
			 {
			 System.out.println("����� ������ A0�Դϴ�.");
			 } 
			 else
			 {
			 System.out.println("����� ������ A-�Դϴ�.");
			 } 
		}
		 else if(subjectNumber>80)
		 {
			 System.out.println("����� ������ B�Դϴ�.");
		 }
		 else if(subjectNumber>70)
		 {
			 System.out.println("����� ������ C�Դϴ�.");
		 }
		 else if(subjectNumber>60)
		 {
			 System.out.println("����� ������ D�Դϴ�.");
		 }
		 else
		 {
			 System.out.println("����� ������ F�Դϴ�.");
		 }	
	}
}
