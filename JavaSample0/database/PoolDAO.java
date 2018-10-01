package com.ex.database;
/***�ǹ����� ����ϴ� SELECT/INSERT����� Pool�� �̿��� ��***/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbcp.BasicDataSource;
public class PoolDAO {

	BasicDataSource ds;
	
	public PoolDAO(){
		ds = new BasicDataSource();
		/*����̹��� �� ���·� �����ؼ� ���->��������� �����������ͼҽ��� �㿡�� ����ϰ� �Ǵ� ��
		 * Ŀ�ؼ��� ������ ����Ҷ����� �������� �ʿ� ����
		 * �̷��� �����ؼ� ����ϸ� Ŀ�ؼ��� �̸� ����� ���� ���� �� �� �־ ����*/
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("java01");
		ds.setPassword("java01");
		//Ŀ�ؼ� 4�������� ���� �� �ִ� ��
		ds.setInitialSize(4);
	}
	
	//SELECT�ϸ� �������� ���� ��µǱ� ������ �迭����Ʈ ���·� ����
	public ArrayList<ExDTO> select(){
		ArrayList<ExDTO> list = new ArrayList<ExDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			/*Ŀ�ؼ�������ؼ��ϰ����� ��ȿ���� 
			 * Connection Pool�� �̿��ϸ� ȿ������
			 * �ѹ��� ���� �״� �� �� �ִ� ��
			 * �ּҰ��� �˸� ��� ������ �ʿ���� �ѹ��� �����صθ� ��
			 * �׸��� Ŀ�ؼ� ������ �����������
			 * 
			 * �� ���� �ڹٿ��� �����ϴ� ���̺귯���� �ƴ�
			 * http://jakarta.apache.org/���� ����� ���� ���̺귯����!
			 * */
			
			//Ŀ�ؼǿ� �Ʊ� �����ص� ����̹��� ���� Ŀ�ؼ��� ����=>�ѹ��� �����ϸ� �ȴٴ°� ū ����
			con = ds.getConnection();
			String query = "SELECT * FROM dept";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				ExDTO dto = new ExDTO();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
				list.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}//end select
}
