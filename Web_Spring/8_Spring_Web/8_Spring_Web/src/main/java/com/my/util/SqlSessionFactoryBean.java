package com.my.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {
	static SqlSessionFactory factory;
	static {
		try{
			InputStream io = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(io);
					
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} 
	}
	
	public static SqlSession getSqlSession(boolean flag) {
		return factory.openSession(flag);
	}
	
	public static SqlSession getSqlSession() {
		return factory.openSession();
	}
}
