package com.my.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {
	private static SqlSessionFactory factory;
	static { // 생성자 함수보다도 먼저 수행된다.
		try {
			InputStream io = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(io);
			// 그러나 오토커밋은 위험한것!

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSession(boolean flag) {
		return factory.openSession(flag); //오토커밋할지 말지 그때그때 정해줄 수 있게
	}
	//파라미터없는 메소드도 오버라이딩 해둠
	public static SqlSession getSqlSession() {
		return factory.openSession(true); //오토커밋할지 말지 그때그때 정해줄 수 있게
	}
}
