package rClient;

import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RClientTest {
	public static void main(String[] args) {
		RConnection conn = null; //try-catch���Ŵϱ� �������� ���� �����
		try {
			conn=new RConnection("127.0.0.1",6311); 
			//�ڱ� ip�ּ�(70.12.109.64)�� ����Ʈ ���̸� �鷯�� 50���� ã�Ƽ� ���ƿ��� �������� ��ȭ���� ���� ©����.
			//�ֳĸ� 6311�� �� �Ⱦ˷��� ��Ʈ�� ����Ʈ���̰� �̸� ������... �ٵ� 8080�� �ȵ�^^ ����
			//�ٵ� 127.0.0.1�� ��������ô�ϴٰ� �ٽ� ���ƿͼ� ��ǻ� ����Ʈ ���̷� �ȳ��� �׷��� 6311��Ʈ���� ������ ��
			
			// String vector = "c(1,2,3,4,5)";
			// conn.eval("meanVal <- mean("+vector+")");
			// System.out.println(conn.eval("meanVal").asDouble());
			
			
			// mtcars
			// mcor <- cor(mtcars)
			// library(corrplot)
			// png('result.png')
			// corrplot(mcor)
			// dev.off()
			// �� ����� �ڹ��ڵ�� �ٲ㺸�� �Ʒ��� ����
			
			 conn.eval("mtcars");
	         conn.eval("mcor <- cor(mtcars)");
	         conn.eval("library(corrplot)");
	         conn.eval("png('C://Users/student/workspace/rClient/client.png')");
	         conn.eval("corrplot(mcor)");
	         conn.eval("dev.off()");
			
			
			
		} catch (RserveException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null && conn.isConnected()) //&&������ �տ� �ϳ��� false�� �ڿ� �˻���� 
				//�׷��� �տ��� conn�� null�̾�� , �ڿ� conn.isConneted()���� nullpointerexception�߻����Ѵ�
				conn.close();
		}
	}
}
