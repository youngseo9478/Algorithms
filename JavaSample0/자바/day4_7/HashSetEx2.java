package day4_7;

import java.util.*;

public class HashSetEx2 {

	public static void main(String[] args) {
		Object[] objArr = { "1", new Integer(1), "2", "2", "2", "3", "3", "4", "4", "4" }; // new
																							// Integer(1)��
																							// ����������ϻӸ��ƴ϶�
																							// ������
																							// ��Ÿ���⶧����,"1"(���ڿ�)����
																							// �ٸ�
																							// hash����
																							// ���´�.(����
																							// �ٸ���)
		Set set = new HashSet(); // Set�� �������̽��� set���� �޾Ƶ� �ǰ� hashset���� �޾Ƶ� �ǰ�
									// �������
		
		for(int i=0; i<objArr.length; i++)
		{
			set.add(objArr[i]); //HashSet�� objArr�� ��ҵ��� �����Ѵ�.
		}
		
		//HashSet�� ����� ��ҵ��� ����Ѵ�.
		System.out.println(set);
	}
}
