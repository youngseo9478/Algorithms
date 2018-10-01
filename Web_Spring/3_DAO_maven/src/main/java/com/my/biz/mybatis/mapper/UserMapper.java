package com.my.biz.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.my.biz.user.vo.UserVO;

public interface UserMapper {

	@Select ("SELECT*FROM USERS")
	public List<UserVO> userlist(); //select 처리해주는 메소드

	@Select("SELECT * FROM USERS WHERE ID = #{id} and PW = #{pw}")
	public UserVO login(UserVO vo);
	
	@Insert("insert into	users (id,pw,name,role) values(#{id},#{pw},#{name},#{role})")
	public int useradd(UserVO vo);
	
	@Select("select * from users where id = #{id}")
	public UserVO userget(String id);
	
	@Delete("delete from users where id = #{id}")
	public int userdel(String id);
	
	@Update("update users set pw = #{pw}, name = #{name} where id = #{id}")
	public int userupdate(UserVO vo);

	@Select("select * from users where ${condition} like '%'||#{keyword}||'%'")
	public List<UserVO> usersearch2(UserVO vo); //UserVO로 한 방법
	
	@Select("select * from users where ${condition} like '%'||#{keyword}||'%'")
	public List<UserVO> usersearch(HashMap<String, String> map); //HashMap으로 한 방법
		
}
