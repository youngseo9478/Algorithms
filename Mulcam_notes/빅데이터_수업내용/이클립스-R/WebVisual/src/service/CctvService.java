package service;

import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.stereotype.Service;

@Service
public class CctvService {
	public static final
	String RESULT_DIR = "C://Users/student/workspace/rClient/";
	public String getCctvMap(String gu){
		RConnection conn = null;
		try {
			conn = new RConnection("127.0.0.1", 6314);
			conn.eval("library(ggmap)");
			
			conn.eval("cctv <- read.csv('C://R/_project_"+gu+"_data.csv',header=T)");
			if(gu.equals("songpa")){
				gu = "songpa-gu";
			}else if(gu.equals("gangbuk")){
				gu ="gangbuk-gu";
			}
			conn.eval("g_m <- get_map('"+gu+"',zoom=13,maptype = 'roadmap')");
			conn.eval("cctv.map <- ggmap(g_m) + geom_point(data = cctv, aes(x=LON, y=LAT),size = 2, alpha = 0.7, color = '#980000')");
			conn.eval("cctv.map");
			conn.eval("ggsave(file='C://Users/student/workspace/rClient/"+gu+".png')");
			return gu+".png";
		} catch (RserveException e) {
			e.printStackTrace();
		} finally{
			if(conn!=null && conn.isConnected())
				conn.close();
		}
		return "noname.png";
	}
}
