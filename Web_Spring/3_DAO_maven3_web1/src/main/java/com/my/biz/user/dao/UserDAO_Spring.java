package com.my.biz.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.my.biz.user.vo.UserVO;

//여기서 제일 중요한건 jdbcTemplate 라이브러리 필요(책 213페이지)
public class UserDAO_Spring implements UserDAO {

	JdbcTemplate spring;

	public UserDAO_Spring() {
		spring=new JdbcTemplate();
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		dataSource.setUsername("youngseo");
		dataSource.setPassword("1234");

		spring.setDataSource(dataSource);
		//System.out.println(spring);
	}

	public UserDAO_Spring(JdbcTemplate spring) {
		this.spring = spring;
	}

	@Override
	public UserVO login(String id, String pw) {
		String sql = "select * from users " + " where id = ? and pw = ?"; //물음표에 넣어줄 값을 아랫줄에 배열형태로 넣어줌
		UserVO vo = spring.queryForObject(sql, new Object[] { id, pw }, new UserRowMapper()); // select결과값을
		return vo;
	}

	@Override
	public UserVO getUser(String uid) {
		String sql = "select * from users where id = ?"; //값이 하나여도 배열로 넣어줘야함
		UserVO vo  = spring.queryForObject(sql, new Object[] {uid}, new UserRowMapper());
		return vo;
	}

	@Override
	public int addUser(UserVO user) {
		String sql = "insert into users (id,pw,name,role) values(?, ?, ?, ?)";
		return spring.update(sql, user.getId(), user.getPw(), user.getName(), user.getRole());
	}

	@Override
	public int removeUser(String uid) {
		String sql = "delete from users where id = ?";
		return spring.update(sql, uid);
	}

	@Override
	public int updateUser(UserVO user) {
		String sql = "update users " + "set pw = ?, name = ? where id = ?";
		return spring.update(sql, user.getPw(), user.getName(), user.getId());
	}

	@Override
	public List<UserVO> getUserList() {
		String sql = "select * from users";
		return spring.query(sql, new UserRowMapper());
	}

	@Override
	public List<UserVO> searchUser(String condition, String keyword) {
		String sql = "";
		if (condition.equals("role")) {
			sql = "select * from users where role like '%'|| ? ||'%' ";
		} else if (condition.equals("name")) {
			sql = "select * from users where name like '%'|| ? ||'%' ";
		} else if (condition.equals("id")) {
			sql = "select * from users where id like '%'|| ? ||'%' ";
		}
		return spring.query(sql,new String[] {keyword} ,new UserRowMapper());
	}

}

class UserRowMapper implements RowMapper<UserVO> {

	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO vo = new UserVO();
		vo.setId(rs.getString("id"));
		vo.setName(rs.getString("name"));
		vo.setPw(rs.getString("pw"));
		vo.setRole(rs.getString("role"));
		return vo;
	}

}
