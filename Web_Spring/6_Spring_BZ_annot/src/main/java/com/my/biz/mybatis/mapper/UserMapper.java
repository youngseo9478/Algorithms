package com.my.biz.mybatis.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.my.biz.user.vo.UserVO;

public interface UserMapper {

	@Select("SELECT * FROM USERS")
	public List<UserVO> userlist();
	
	@Select("select * from users where id = #{id} and pw = #{pw}")
	public UserVO login(UserVO vo);

	@Insert("insert into users (id,pw,name,role) "
			+ "values(#{id}, #{pw}, #{name},#{role})")
	public int adduser(UserVO vo);

	@Insert("insert into users (id,pw,name,role) values('${id}', '${pw}', '${name}','${role}')")
	int adduser2(UserVO vo);

	@Select("select * from users where id = #{id}")
	public UserVO getuser(String id);
	
	@Delete("delete from users where id = #{id}")
	int deleteuser(String id);
	
	@Update("update users set pw = #{pw}, name = #{name} where id = #{id}")
	public int updateuser(UserVO vo);
	
   @Select("select * from users where ${condition} like '%'||#{keyword}||'%'")
   public List<UserVO> searchuser(HashMap<String, String> map);
  // public List<UserVO> searchuser(UserVO vo);
}





