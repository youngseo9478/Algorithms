package com.my.biz.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.my.biz.mybatis.mapper.UserMapper;
import com.my.biz.user.vo.UserVO;
import com.my.util.SqlSessionFactoryBean;

@Component("userMybatis2")
public class UserDAO_MyBatis_Interface implements UserDAO{
	
	@Autowired	//set메소드 없어도 동작 가능
	SqlSession mybatis;	//mybatis framework에서 관리
	
	UserMapper mapper;
	
	public UserDAO_MyBatis_Interface() {
		/*
		try{
			//inputstream 객체 열어서 config 파일 가져오기
			//java.io.InputStream;
			InputStream io = Resources.getResourceAsStream("mybatis-config.xml");
								//org.apache.ibatis.io.Resources;
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(io);
			//mybatis = factory.openSession();
			mybatis=factory.openSession(true);	//auto commit setting
			
		
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		
		//mybatis = SqlSessionFactoryBean.getSqlSession(true);
		//mapper = mybatis.getMapper(UserMapper.class);
	 
	}
	
	public UserDAO_MyBatis_Interface(SqlSession mybatis) {
		this.mybatis = mybatis;
	}
	
	
	
	public SqlSession getMybatis() {
		return mybatis;
	}

	public void setMybatis(SqlSession mybatis) {
		this.mybatis = mybatis;
	}

	@PostConstruct
	public void init() {
		mapper = mybatis.getMapper(UserMapper.class);
	}

	@Override
	public UserVO login(String id, String pw) {
		UserVO vo = new UserVO();	//파라미터가 2개 이상일 경우 객체화 필요 (반드시)
			vo.setId(id);
			vo.setPw(pw);
		//return mybatis.selectOne("user.login", vo);
		return mapper.login(vo);
	}

	@Override
	public int addUser(UserVO user) {
		//return mybatis.insert("user.adduser",user);	//insert도 가능
		//보통 update 구문이 insert, update, delete 모두 처리
		//return mybatis.update("user.adduser", user);
		//int row = mybatis.update("user.adduser", user);
		int row = mapper.addUser(user);
		//mybatis.commit();
		return row;
	}

	@Override
	public UserVO getUser(String uid) {
		//return mybatis.selectOne("user.getuser", uid);
		return mapper.getuser(uid);
	}

	@Override
	public List<UserVO> getUserList() {
		//return mybatis.selectList("user.userlist");	//키값 입력
		System.out.println("MyBatis Interface 기반 동작");
		return mapper.userlist();
	}

	@Override
	public int removeUser(String uid) {
		//return mybatis.update("user.deleteuser",uid);
		//return mybatis.update("user.deleteuser",uid);
		return mapper.deleteuser(uid);
	}

	@Override
	public int updateUser(UserVO user) {
		//return mybatis.update("user.updateuser", user);
		return mapper.updateuser(user);
	}

	@Override
	public List<UserVO> searchUser(String condition, String keyword) {
		//방법1. condition과 keyword를 UserVO에 박아버리기. (교재참고. 가장 흔한 방법)
		//방법2. map구조로 설계 바꾸기 -> 실습
		HashMap<String, String> map = new HashMap<String, String>();
/*		map.put(condition, keyword);*/
		map.put("condition", condition);
		map.put("keyword", keyword);
		//xml, parameterType HashMap 추가
		
		//return mybatis.selectList("user.searchuser", map);
		return mapper.searchuser(map);
	}

}
