package com.my.biz.user.dao;

import java.util.List;

import com.my.biz.user.vo.UserVO;

public class UserDAO_Spring implements UserDAO{

	@Override
	public UserVO login(String id, String pw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addUser(UserVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserVO getUser(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVO> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removeUser(String uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(UserVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserVO> searchUser(String condition, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
