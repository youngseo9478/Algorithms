package com.my.biz.user.dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.my.biz.user.vo.UserVO;
import com.my.util.SqlSessionFactoryBean;

@Component("userMybatis1")
public class UserDAO_MyBatis implements UserDAO{
	
	//@Inject	//둘다 가능
	@Autowired
	SqlSession mybatis;	//mybatis framework에서 관리
	
	public UserDAO_MyBatis() {
		//mybatis = SqlSessionFactoryBean.getSqlSession(true);
	}
	
	public UserDAO_MyBatis(SqlSession mybatis) {
		super();
		this.mybatis = mybatis;
	}
	
	public SqlSession getMybatis() {
		return mybatis;
	}

	public void setMybatis(SqlSession mybatis) {
		this.mybatis = mybatis;
	}

	@Override
	public UserVO login(String id, String pw) {
		UserVO vo = new UserVO();	//파라미터가 2개 이상일 경우 객체화 필요 (반드시)
			vo.setId(id);
			vo.setPw(pw);
		return mybatis.selectOne("user.login", vo);
	}

	@Override
	public int addUser(UserVO user) {
		//return mybatis.insert("user.adduser",user);	//insert도 가능
		//보통 update 구문이 insert, update, delete 모두 처리
		//return mybatis.update("user.adduser", user);
		int row = mybatis.update("user.adduser", user);
		//mybatis.commit(); 커밋은 이제 트랜잭션 매니저가 관리할 것임
		return row;
	}

	@Override
	public UserVO getUser(String uid) {
		return mybatis.selectOne("user.getuser", uid);
	}

	@Override
	public List<UserVO> getUserList() {
		return mybatis.selectList("user.userlist");	//키값 입력
	}

	@Override
	public int removeUser(String uid) {
		//return mybatis.update("user.deleteuser",uid);
		return mybatis.update("user.deleteuser",uid);
	}

	@Override
	public int updateUser(UserVO user) {
		return mybatis.update("user.updateuser", user);
	}

	@Override
	public List<UserVO> searchUser(String condition, String keyword) {
		//방법1. condition과 keyword를 UserVO에 박아버리기. (교재참고. 가장 흔한 방법)
		//방법2. map구조로 설계 바꾸기 -> 실습
		Map<String, String> map = new HashMap<String, String>();
		map.put(condition, keyword);
		//xml, parameterType HashMap 추가
		
		return mybatis.selectList("user.searchuser", map);
	}

}
