import java.sql.*;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class Test1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, RserveException, REXPMismatchException {
		RConnection rconn = null;
		rconn = new RConnection("127.0.0.1");
		System.out.println("I lobe winjavarhive");
		
		rconn.eval("source('c:/winjavarhive.R')");
		RList list = rconn.eval("rhive2()").asList();
		
		int cntCol = list.size();
		System.out.println(cntCol);
		
		String [] colName = list.keys();
		
		int i =0;
		while(i<colName.length) {
			System.out.println(colName[i]);
			list.at(colName[i]).asString();
			i++;
		}
	}
}
