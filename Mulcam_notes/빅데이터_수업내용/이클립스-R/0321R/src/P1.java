
import org.rosuda.JRI.REXP;
import org.rosuda.JRI.RList;
import org.rosuda.JRI.RVector;
import org.rosuda.JRI.Rengine;

public class P1 {

   public static void main(String[] args) {

      String[] aa = { "--vanilla" };
      // --save
      // --no save
      // --vanilla(--no 통합형:Combine --no --save,
      // --no -init -file, --no -environ
      // vanilla쓰면 all no 설정됨.)
      // R 엔진 가동시 주는 옵션으로 R 세션 종료시
      // 데이터 셋 저장여부를 의미함.

      // JRI의 패키지
      // Rengine , REXP

      // Rengine이란 R-java간 인터페이스를 담당.
      Rengine ren1 = new Rengine(aa, false, null);
      // R interface - JAVA VM interface
      if (!ren1.waitForR()) {
         //R 정상가동하면 TRUE 리턴
         System.out.println("R ERR");
      }else{
         System.out.println("Hi R");
      }
      
      //REXP re1=ren1.eval("seq(1:5)");
      //eval : R 코드 파싱
      //REXP 클래스 : R을 자바형으로 
      
      //int[] iBae=re1.asIntArray(); //R의 seq를 java의 array로
      
      
      //System.out.println(iBae[1]);
      
      ////////////////////////////
      //rJava : seq() --> asIntArray() -> 자바 int []
      
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