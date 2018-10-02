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
                list = new LinkedList<Integer>();  //여기서 다시 생성하는게 포인트!!
                // 왜냐면 앞에 2개는 서로 같은데 3번 수포자가 더 많이 맞춰서 max가 변경되면 list에는 3만 있어야 하는데 앞에 1,2가 쌓여 있기 때문!!
                //새로운 맥스가 나타났을 때에는 아예 리스트를 다시 만들어 줘야하는 것임
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
