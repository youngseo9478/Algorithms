package com.my.biz.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.my.biz.user.vo.UserVO;

//여기서는 파라미터를 절대 한개이상 넣을수없다! 그럴 경우는 VO를 이용해야함!!

public interface UserMapper {


/*	<select id="userlist" resultType="com.my.biz.user.vo.UserVO">
	SELECT * FROM USERS		
	</select>	*/
	@Select("SELECT * FROM USERS")		
	public List<UserVO>userlist();
	
/*	<select id="login" resultType="uservo" parameterType="uservo">
		select * from users where id=#{id} and pw=#{pw}
	</select>	*/
	@Select("select * from users where id=#{id} and pw=#{pw}")
	public UserVO login(UserVO vo);
	
/*	<insert id="adduser" parameterType="uservo">
		insert into users (id, name, pw, role) values(#{id},#{name},#{pw},#{role})
	</insert>	*/
	@Insert("insert into users (id, name, pw, role) values(#{id},#{name},#{pw},#{role})")
	public int addUser(UserVO vo);
	
/*	<insert id="adduser2" parameterType="uservo">
		insert into users (id, name, pw, role) values('${id}','${name}','${pw}','${role}')
	</insert>	*/
	@Insert("insert into users (id, name, pw, role) values('${id}','${name}','${pw}','${role}')")
	public int addUser2(UserVO vo);
	
/*	<select id="getuser" resultType="uservo">
		select * from users where id=#{id}
	</select>	*/
	@Select("select * from users where id=#{id}")
	public UserVO getuser(String id);
	
/*	<delete id="deleteuser">
		delete from users where id=#{id}
	</delete>	*/
	@Delete("delete from users where id=#{id}")
	public int deleteuser(String id);
	
/*	<update id="updateuser" parameterType="uservo">
		update users set name =#{name}, pw=#{pw} where id=#{id}
	</update>	*/
	@Update("update users set name =#{name}, pw=#{pw}, role=#{role} where id=#{id}")
	public int updateuser(UserVO vo);
	
/*	<select id="searchuser" resultType="uservo" parameterType="HashMap">
		select * from users
		<where> 
			<if test="name !=null"> name like '%'|| #{name} ||'%'</if>
			<if test="id !=null"> id like '%'|| #{id} ||'%'</if>
			<if test="role !=null"> role like '%'|| #{role} ||'%'</if>
		</where>
	</select>	*/
	
	
	@Select("select * from users where ${condition} like '%'|| #{keyword} ||'%' ")
	//public List<UserVO> searchuser(UserVO vo);	//UserVO 가능
	public List<UserVO> searchuser(HashMap<String, String> map);	//HashMap 가능
	
}
