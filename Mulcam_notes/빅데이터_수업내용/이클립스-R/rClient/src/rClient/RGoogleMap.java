package rClient;

import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RGoogleMap {
	public static void main(String[] args) {
		RConnection conn = null;
		try {
			conn = new RConnection("127.0.0.1", 6311);
			conn.eval("library(ggmap)");
			conn.eval("cctv <- read.csv('C://R/_project_gangbuk_data.csv')");
			conn.eval("g_m <- get_map('gangbukgu',zoom=13,maptype = 'roadmap')");
			conn.eval("cctv.map <- ggmap(g_m) + geom_point(data = cctv, aes(x=LON, y=LAT),size = 2, alpha = 0.7, color = '#980000')");
			conn.eval("cctv.map");
			conn.eval("ggsave(file='C://Users/student/workspace/rClient/map_result_java.png')");
		} catch (RserveException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null && conn.isConnected())
				conn.close();
		}
	}
}
