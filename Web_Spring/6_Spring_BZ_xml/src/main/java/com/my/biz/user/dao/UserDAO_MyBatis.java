package com.my.biz.user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.my.biz.user.vo.UserVO;
import com.my.util.SqlSessionFactoryBean;

public class UserDAO_MyBatis implements UserDAO{
	SqlSession mybatis;
	
	public UserDAO_MyBatis() {
		//mybatis = SqlSessionFactoryBean.getSqlSession(true); 이제 스프링이 관리할 것
		
	}
	
	public UserDAO_MyBatis(SqlSession mybatis) {//생성자
		this.mybatis = mybatis;
	}

	public SqlSession getMybatis() {
		return mybatis;
	}

	public void setMybatis(SqlSession mybatis) {//setter
		this.mybatis = mybatis;
	}

	@Override
	public UserVO login(String id, String pw) {
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPw(pw);
		//파라미터가 두개 이상일 때에는 꼭 객체화해서 넘겨줘야한다.
		return mybatis.selectOne("user.userlogin",vo);
	}

	@Override
	public int addUser(UserVO user) {
		int row = mybatis.update("user.useradd", user); //insert도 가능함 똑같이 동작ㅎㅏ나봄
		mybatis.commit();
		return row;
	}

	@Override
	public UserVO getUser(String uid) {
		return mybatis.selectOne("user.userget", uid);
	}

	@Override
	public List<UserVO> getUserList() {
		return mybatis.selectList("user.userlist");
	}

	@Override
	public int removeUser(String uid) {
		return mybatis.update("user.userdel", uid);
	}

	@Override
	public int updateUser(UserVO user) {
		return mybatis.update("user.userupdate", user);
	}

	@Override
	public List<UserVO> searchUser(String condition, String keyword) {
		//컨디션과 키워드를 담을 객체가 없는데 어떻게 객체화?
		/*1. UserVO에 condition과 keyword를 추가하는 방법(가장 쉽고 흔한 방법)
		 *2. Map구조로 설계를 바꿔서 넘기는 방법*/
		Map<String, String> map = new HashMap<String,String>();
		map.put(condition, keyword);
		
		return mybatis.selectList("user.usersearch", map);
	}
	
}
