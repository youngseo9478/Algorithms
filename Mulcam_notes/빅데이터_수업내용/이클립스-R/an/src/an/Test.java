package an;

import java.util.HashSet;

public class Test {
   static int tmp = 0;
   static int count = 0; // ��� ���Ҵ°�
   static int val = 0; //�����
   static int c = 10; // � �����ΰ�
   static HashSet<Integer> set = new HashSet<>();
   static int data[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
   static int k = 13;
   public static void main(String[] args) {
      search();
   }

   static void search() {

      if (count < c) {
    	 System.out.println(set);
         if (set.contains(k - data[count])) {
            val++;
            System.out.println("�߰�");
         }
         set.add(data[count]);
         count++;
         search();
         
      }else {
         System.out.println(val+"�� ã�ҽ��״�. �ݺ� Ƚ�� "+count);
      }      
   }
}