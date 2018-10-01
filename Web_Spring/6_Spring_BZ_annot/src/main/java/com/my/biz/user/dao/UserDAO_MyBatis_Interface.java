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
	
	@Autowired
    SqlSession mybatis;
	
    UserMapper mapper;
    
    public  UserDAO_MyBatis_Interface(){
    	//mybatis = SqlSessionFactoryBean.getSqlSession(true);
    }
    
    public UserDAO_MyBatis_Interface(SqlSession mybatis) {
		super();
		this.mybatis = mybatis;
	}
    
    @PostConstruct
	public void init() {
       mapper = mybatis.getMapper(UserMapper.class);
    }
    @Override
	public List<UserVO> getUserList() {
    	System.out.println("MyBatis Interface 기반 동작");
		return mapper.userlist();
	}
	@Override
	public UserVO login(String id, String pw) {
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPw(pw);
		return mapper.login(vo);
	}
	@Override
	public int addUser(UserVO user) {
		int row = mapper.adduser(user);
		return row;
	}
	@Override
	public UserVO getUser(String uid) {
		return mapper.getuser(uid);
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
		HashMap<String, String> map = new HashMap<String, String>();
        map.put("condition", condition);
        map.put("keyword", keyword);
        System.out.println(map);
		return mapper.searchuser(map);
	}

}





