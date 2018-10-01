package com.my.biz.user.dao;

import java.util.List;

import com.my.biz.user.vo.UserVO;

public interface UserDAO {
	 public UserVO login(String id , String pw);
	 public int addUser(UserVO user);
	 public UserVO getUser(String uid);
	 public List<UserVO> getUserList();
	 public int removeUser(String uid);
	 public int updateUser(UserVO user);
	 public List<UserVO> searchUser(String condition, String keyword);

}
