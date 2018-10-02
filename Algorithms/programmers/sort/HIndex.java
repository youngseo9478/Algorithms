package sort;

import java.util.Arrays;

public class HIndex {
	public static void main(String[] args) {
		int[] citations = { 3, 0, 6, 1, 5 };
		System.out.println(solution(citations));
	}
	public static int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i); //어떻게 이런 생각을 하지...?
            //앞의 매개변수는 끝에서부터 몇번째에 해당하는 값, 뒤에 변수는 H인덱스인것. H인덱스 보다 해당값이 크거나 같으면 무조건 OK인것
            //H값은 점점 커지는 쪽이었고, 앞쪽 매개변수는 점점 작아졌음. 그렇기 때문에 작은 값들 리스트 중 가장 큰 값은 H값.(왜냐면 앞쪽 매개변수는 무조건 H보다는 크거나 같음)
            if(max < min) max = min;
            //max = Math.max(max, min); 이렇게 해도 됨...
        }

        return max;
    }

	/*public static int solution(int[] citations) {
		Arrays.sort(citations);
		int answer = 0;
		for (int i = citations[citations.length - 1]; i > 0; i--) {
			int h = 0;
			for (int j = 0; j < citations.length; j++) {
				if (i <= citations[j])
					h++;
			}
			if (i == h) {
				answer = h;
				return answer;
			}
		}
		return 0;
	} 테스트 케이스 11 하나가 자꾸 실패함... 왜그르지 ㅠ*/
}
