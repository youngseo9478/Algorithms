
import org.rosuda.JRI.REXP;
import org.rosuda.JRI.RList;
import org.rosuda.JRI.RVector;
import org.rosuda.JRI.Rengine;

public class P2 {

   public static void main(String[] args) {

      String[] aa = { "--vanilla" };
      Rengine ren1 = new Rengine(aa, false, null);
      if (!ren1.waitForR()) {
         System.out.println("R ERR");
      }else{
         System.out.println("Hi R");
      }
      
      REXP re1=ren1.eval("seq(1:5)");
      
      int[] iBae=re1.asIntArray();
      System.out.println(iBae[1]);
      ren1.end();
      ren1.eval("jpeg(filename=\"./rtest.jpg\")");
      ren1.eval("jpeg(filename=\"c:/rtest.jpg\")");
      ren1.eval("plot(rnorm(100))");
      ren1.eval("dev.off()");
      ren1.end();
   }
}