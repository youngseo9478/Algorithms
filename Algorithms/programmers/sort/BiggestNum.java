package sort;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNum {
	public static void main(String[] args) {
		int num[] = {3,30,34,5,9};
		System.out.println(solution(num));
	}
	public static String solution(int[] numbers) {
        String answer = "";
		String[] str = new String[numbers.length];
		for (int i = 0; i < str.length; i++) {
			str[i] = Integer.toString(numbers[i]);
		}
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2); 
				//���� �ں��� ������ �ȹٲ�. �ٵ� �տ��� o2+01�̹Ƿ� �츮 �迭�������δ� �ڸ��� �ٲ��� ����.
				//�ڸ��� �ٲ����� �� �����ϱ� �׷����� �ٲ�� �ȵǴ� ��.
				//�̷��� �ϸ� ���� ���ΰ��� ū�ͺ��� ���ĵȴ�.(return 1�϶� �ٲ�)
			}
		});
		
		for(String s: str){
			answer = answer + s;
            if(answer.equals("0")) return answer;
		}
        return answer;
    }
}


