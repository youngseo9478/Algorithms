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
            int min = (int)Math.min(citations[i], citations.length - i); //��� �̷� ������ ����...?
            //���� �Ű������� ���������� ���°�� �ش��ϴ� ��, �ڿ� ������ H�ε����ΰ�. H�ε��� ���� �ش簪�� ũ�ų� ������ ������ OK�ΰ�
            //H���� ���� Ŀ���� ���̾���, ���� �Ű������� ���� �۾�����. �׷��� ������ ���� ���� ����Ʈ �� ���� ū ���� H��.(�ֳĸ� ���� �Ű������� ������ H���ٴ� ũ�ų� ����)
            if(max < min) max = min;
            //max = Math.max(max, min); �̷��� �ص� ��...
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
	} �׽�Ʈ ���̽� 11 �ϳ��� �ڲ� ������... �ֱ׸��� ��*/
}
