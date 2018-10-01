package com.my.biz.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.my.biz.user.dao.UserDAO;
import com.my.biz.user.vo.UserVO;

@Component("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	//@Qualifier("userJdbc")
	//@Qualifier("userSpring")
	@Qualifier("userMybatis1")
	//@Qualifier("userMybatis2")
	UserDAO dao = null;
	
	public UserServiceImpl() {	}
	
	public UserServiceImpl(UserDAO dao) {
		this.dao = dao;
	}
	
	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

	@Override
	public UserVO login(String id, String pw) {
		if(id.equals("") || id==null) {
			throw new RuntimeException("로그인 파라미터 필요");
		}
		System.out.println("login()수행");
		//System.out.println(3/0);
		return dao.login(id, pw);
	}

	@Override
	public int addUser(UserVO user) {
		return dao.addUser(user);
	}

	@Override
	public UserVO getUser(String uid) {
		return dao.getUser(uid);
	}

	@Override
	public List<UserVO> getUserList() {
		System.out.println("getUserList() 수행");
		return dao.getUserList();
	}
	
	@Override
	public int removeUser(String uid) {
		return dao.removeUser(uid);
	}

	@Override
	public int updateUser(UserVO user) {
		return dao.updateUser(user);
	}

	@Override
	public List<UserVO> searchUser(String condition, String keyword) {
		return dao.searchUser(condition, keyword);
	}

}
