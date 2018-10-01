package com.my.biz.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.my.biz.user.dao.UserDAO;
import com.my.biz.user.vo.UserVO;

@Component("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	//@Qualifier("userJdbc")
	@Qualifier("userSpring")
	//@Qualifier("userMybatis1")
	//@Qualifier("userMybatis2")
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
		 if(id.equals("") || id==null) {
			throw new RuntimeException("로그인 정보 필요"); //unchecked exception이어야 통과가능하므로 runtime붙여ㅈ귀
			//throw new Exception("로그인 정보 필요"); //checked exception이므로 try~catch나 throws해줘야하는데 그러면 오버라이딩이아니니까 사용불가!!
		 }
		//System.out.println(3/0); //강제로 예외발생시키기
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
