package hive_client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HiveJdbcTest {
	public static void main(String[] args) {
		// JDBC짜기....
		// 1. JDBC연결에 필요한 정보를 준비 url, username,password
		String JDBC_DRIVER = "org.apache.hive.jdbc.HiveDriver";
		String url = "jdbc:hive2://192.168.111.201:10000";
		String username = "";
		String password = "";
		// 2. Connection객체 빌드(드라이버적재, 커넥션빌드)
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(url, username, password);

			// 3. 날리고자 하는 SQL문을 Statement객체로 준비
			String sql = "SELECT deptno, SUM(sal) as sum_sal"
					+ " FROM emp GROUP BY deptno";
			stmt = conn.prepareStatement(sql);

			// 4. 결과값을 회수하고자 한다면 ResultSet객체 핸들링
			rs = stmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("deptno")+"\t");
				System.out.print(rs.getInt("sum_sal") + "\n");
//				System.out.println(rs.getString("dloc"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//다 닫아주기
		}

	}
}
