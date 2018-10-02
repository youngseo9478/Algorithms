
import org.rosuda.JRI.REXP;
import org.rosuda.JRI.RList;
import org.rosuda.JRI.RVector;
import org.rosuda.JRI.Rengine;

public class P1 {

   public static void main(String[] args) {

      String[] aa = { "--vanilla" };
      // --save
      // --no save
      // --vanilla(--no ������:Combine --no --save,
      // --no -init -file, --no -environ
      // vanilla���� all no ������.)
      // R ���� ������ �ִ� �ɼ����� R ���� �����
      // ������ �� ���忩�θ� �ǹ���.

      // JRI�� ��Ű��
      // Rengine , REXP

      // Rengine�̶� R-java�� �������̽��� ���.
      Rengine ren1 = new Rengine(aa, false, null);
      // R interface - JAVA VM interface
      if (!ren1.waitForR()) {
         //R ���󰡵��ϸ� TRUE ����
         System.out.println("R ERR");
      }else{
         System.out.println("Hi R");
      }
      
      //REXP re1=ren1.eval("seq(1:5)");
      //eval : R �ڵ� �Ľ�
      //REXP Ŭ���� : R�� �ڹ������� 
      
      //int[] iBae=re1.asIntArray(); //R�� seq�� java�� array��
      
      
      //System.out.println(iBae[1]);
      
      ////////////////////////////
      //rJava : seq() --> asIntArray() -> �ڹ� int []
      
      ren1.eval("driveload1 <- JDBC(\"oracle.jdbc.driver.OracleDriver\",\"C:/ojdbc6.jar\")");
      ren1.eval("dbCon1 <- dbConnect(driveload1, \"jdbc:oracle:thin:@localhost:1521:xe\", \"hr\", \"hr\")");
      ren1.eval("emp <- dbGetQuery(dbCon1, \"Select * from employees\")");
      
      REXP re2=ren1.eval("emp");
      System.out.println(re2);
      ren1.end();
      //ren1.eval("jpeg(filename=\"./rtest.jpg\")");
      /*ren1.eval("jpeg(filename=\"c:/rtest.jpg\")");
      ren1.eval("plot(rnorm(100))");
      ren1.eval("dev.off()");
      ren1.end(); */
   }
}