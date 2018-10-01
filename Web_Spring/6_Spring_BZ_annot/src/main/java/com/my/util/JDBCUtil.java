package com.my.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection con = null;
		
		//String fileName = "c://file/dbinfo.txt";
		String fileName = "src/main/resources/dbinfo.properties";
		
		Properties p = new Properties();	

		try {
			p.load(new FileInputStream(fileName));	

			Class.forName(p.getProperty("driver"));
			
			con = DriverManager.getConnection(p.getProperty("url"),
											p.getProperty("user"),
											p.getProperty("pw"));
			
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return con;
	}

	public static void close(ResultSet rs, Statement st, Connection con) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (st != null) {
				st.close();
				st = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
