package rClient;

import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RClientTest {
	public static void main(String[] args) {
		RConnection conn = null; //try-catch쓸거니까 참조변수 먼저 만들기
		try {
			conn=new RConnection("127.0.0.1",6311); 
			//자기 ip주소(70.12.109.64)는 게이트 웨이를 들러서 50번을 찾아서 돌아오는 과정에서 방화벽에 의해 짤린다.
			//왜냐면 6311은 잘 안알려진 포트라서 게이트웨이가 이를 거절함... 근데 8080도 안됨^^ 뭐지
			//근데 127.0.0.1은 나가보는척하다가 다시 돌아와서 사실상 게이트 웨이로 안나감 그래서 6311포트여도 잡히는 것
			
			// String vector = "c(1,2,3,4,5)";
			// conn.eval("meanVal <- mean("+vector+")");
			// System.out.println(conn.eval("meanVal").asDouble());
			
			
			// mtcars
			// mcor <- cor(mtcars)
			// library(corrplot)
			// png('result.png')
			// corrplot(mcor)
			// dev.off()
			// 이 명령을 자바코드로 바꿔보면 아래와 같다
			
			 conn.eval("mtcars");
	         conn.eval("mcor <- cor(mtcars)");
	         conn.eval("library(corrplot)");
	         conn.eval("png('C://Users/student/workspace/rClient/client.png')");
	         conn.eval("corrplot(mcor)");
	         conn.eval("dev.off()");
			
			
			
		} catch (RserveException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null && conn.isConnected()) //&&연산은 앞에 하나만 false면 뒤에 검사안함 
				//그래서 앞에서 conn이 null이었어도 , 뒤에 conn.isConneted()에서 nullpointerexception발생안한다
				conn.close();
		}
	}
}
