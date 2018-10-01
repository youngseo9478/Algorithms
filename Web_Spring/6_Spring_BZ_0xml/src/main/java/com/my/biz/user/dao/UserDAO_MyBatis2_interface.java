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

import com.my.biz.mybatis.mapper.UserMapper;
import com.my.biz.user.vo.UserVO;
import com.my.util.SqlSessionFactoryBean;

public class UserDAO_MyBatis2_interface implements UserDAO{
	SqlSession mybatis;
	UserMapper mapper; //인터페이스라 직접 객체 생성 불가
	
	public UserDAO_MyBatis2_interface() {
		mybatis = SqlSessionFactoryBean.getSqlSession(true);
		mapper = mybatis.getMapper(UserMapper.class);
	}

	@Override
	public UserVO login(String id, String pw) {
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPw(pw);
		//파라미터가 두개 이상일 때에는 꼭 객체화해서 넘겨줘야한다.
		return mapper.login(vo);
	}

	@Override
	public int addUser(UserVO user) {
		int row = mapper.adduser(user);//insert도 가능함 똑같이 동작ㅎㅏ나봄
		return row;
	}

	@Override
	public UserVO getUser(String uid) {
		return mapper.getuser(uid);
	}

	@Override
	public List<UserVO> getUserList() {
		System.out.println("mybatis의 인터페이스 기반 동작");
		return mapper.userlist();
	}

	@Override
	public int removeUser(String uid) {
		return mapper.deleteuser(uid);
	}

	@Override
	public int updateUser(UserVO user) {
		return mapper.updateuser(user);
	}

	@Override
	public List<UserVO> searchUser(String condition, String keyword) {
		//컨디션과 키워드를 담을 객체가 없는데 어떻게 객체화?
		/*1. UserVO에 condition과 keyword를 추가하는 방법(가장 쉽고 흔한 방법)
		 *2. Map구조로 설계를 바꿔서 넘기는 방법*/
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("condition", condition);
		map.put("keyword", keyword);
		return mapper.searchuser(map);
		// UserVO vo = new UserVO();
		// vo.setCondition(condition);
		// vo.setKeyword(keyword);
		// return mapper.usersearch2(vo);
	}
	
}
