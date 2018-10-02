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
				//앞이 뒤보다 작으면 안바꿈. 근데 앞에가 o2+01이므로 우리 배열기준으로는 자리를 바꿨을 때임.
				//자리를 바꿨을때 더 작으니까 그럴경우는 바뀌면 안되는 것.
				//이렇게 하면 앞이 붙인값이 큰것부터 정렬된다.(return 1일때 바꿈)
			}
		});
		
		for(String s: str){
			answer = answer + s;
            if(answer.equals("0")) return answer;
		}
        return answer;
    }
}


