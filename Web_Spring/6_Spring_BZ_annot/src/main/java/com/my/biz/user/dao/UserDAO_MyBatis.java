package com.my.biz.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.my.biz.user.vo.UserVO;
import com.my.util.SqlSessionFactoryBean;

@Component("userMybatis1")
public class UserDAO_MyBatis implements UserDAO{
	
	//@Inject
	@Autowired
    SqlSession mybatis;
    
    public  UserDAO_MyBatis(){
    	//mybatis = SqlSessionFactoryBean.getSqlSession(true);
    }
    public UserDAO_MyBatis(SqlSession mybatis) {
		this.mybatis = mybatis;
	}
	public SqlSession getMybatis() {
		return mybatis;
	}
	public void setMybatis(SqlSession mybatis) {
		this.mybatis = mybatis;
	}


	@Override
	public List<UserVO> getUserList() {
		return mybatis.selectList("user.userlist");
	}
	@Override
	public UserVO login(String id, String pw) {
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPw(pw);
		return mybatis.selectOne("user.login",vo);
	}
	@Override
	public int addUser(UserVO user) {
		int row = mybatis.update("user.adduser",user);
		//mybatis.commit();
		return row;
	}
	@Override
	public UserVO getUser(String uid) {
		return mybatis.selectOne("user.getuser",uid);
	}
	@Override
	public int removeUser(String uid) {
		return mybatis.update("user.deleteuser",uid);
	}

	@Override
	public int updateUser(UserVO user) {
		return mybatis.update("user.updateuser",user);
	}

	@Override
	public List<UserVO> searchUser(String condition, String keyword) {
        Map<String, String> map = new HashMap<String, String>();
        map.put(condition, keyword);
        
		return mybatis.selectList("user.searchuser", map);
	}

}





