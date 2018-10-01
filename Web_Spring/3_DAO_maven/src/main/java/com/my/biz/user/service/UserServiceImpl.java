package com.my.biz.user.service;

import java.util.List;

import com.my.biz.user.dao.UserDAO;
import com.my.biz.user.vo.UserVO;

public class UserServiceImpl implements UserService{

	UserDAO dao;
	
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
		// TODO Auto-generated method stub
		return dao.login(id, pw);
	}

	@Override
	public int addUser(UserVO user) {
		// TODO Auto-generated method stub
		return dao.addUser(user);
	}

	@Override
	public UserVO getUser(String uid) {
		// TODO Auto-generated method stub
		return dao.getUser(uid);
	}

	@Override
	public List<UserVO> getUserList() {
		return dao.getUserList();
	}

	@Override
	public int removeUser(String uid) {
		// TODO Auto-generated method stub
		return dao.removeUser(uid);
	}

	@Override
	public int updateUser(UserVO user) {
		// TODO Auto-generated method stub
		return dao.updateUser(user);
	}

	@Override
	public List<UserVO> searchUser(String condition, String keyword) {
		// TODO Auto-generated method stub
		return dao.searchUser(condition, keyword);
	}

}
