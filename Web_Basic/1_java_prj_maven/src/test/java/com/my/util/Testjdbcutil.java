package com.my.util;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Testjdbcutil {
	Connection con;
	@Before
	public void setUp() throws Exception {
		con =  JDBCUtil.getConnection();
		
	}

	@After
	public void tearDown() throws Exception {
		 JDBCUtil.close(null,null,con);
	}

	@Test
	public void test() {
		assertNotNull(con);
	}

}
