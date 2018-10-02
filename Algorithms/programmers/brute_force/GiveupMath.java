package brute_force;

import java.util.LinkedList;
import java.util.List;

public class GiveupMath {
	public int[] solution(int[] answers) {
        int[] m = new int[3];
        int[] supo1 = {1,2,3,4,5};
        int[] supo2 = {2,1,2,3,2,4,2,5};
        int[] supo3 = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == supo1[i%5]){
                m[0]++;
            }
            if(answers[i] == supo2[i%8]){
                m[1]++;
            }
            if(answers[i] == supo3[i%10])
                m[2]++;
        }
        
        int max = 0;
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=0; i<3; i++){
            if(m[i]>max){
                list = new LinkedList<Integer>();  //���⼭ �ٽ� �����ϴ°� ����Ʈ!!
                // �ֳĸ� �տ� 2���� ���� ������ 3�� �����ڰ� �� ���� ���缭 max�� ����Ǹ� list���� 3�� �־�� �ϴµ� �տ� 1,2�� �׿� �ֱ� ����!!
                //���ο� �ƽ��� ��Ÿ���� ������ �ƿ� ����Ʈ�� �ٽ� ����� ����ϴ� ����
                list.add(i+1);
                max = m[i];
            }else if(m[i]==max){
                list.add(i+1);
            }
        }
        
        int[] result = new int[list.size()];
        for(int i = 0; i<result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
