package com.my.biz.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.my.biz.user.vo.UserVO;

public class UserDAO_Spring implements UserDAO {

	JdbcTemplate spring; // spring이 관리하는 객체이므로 spring환경에서 관리하는게 맞음!

	public UserDAO_Spring() {
		// spring = new JdbcTemplate();

		//DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// 데이터소스도 스프링이 관리할것!! 데이터소스를 클라이언츠가 한다는건 말도 안됨~~
		/*
		 * dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		 * dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		 * dataSource.setUsername("youngseo"); dataSource.setPassword("1234");
		 * 
		 * spring.setDataSource(dataSource);
		 */

	}

	public UserDAO_Spring(JdbcTemplate spring) {
		super();
		this.spring = spring;
	}

	public JdbcTemplate getSpring() {
		return spring;
	}

	public void setSpring(JdbcTemplate spring) {
		this.spring = spring;
	}

	@Override
	public UserVO login(String id, String pw) {
		String sql = "select * from users where id = ? and pw = ?";

		UserVO vo = spring.queryForObject(sql, new Object[] { id, pw }, new UserRowMapper());

		return vo;
	}

	@Override
	public int addUser(UserVO user) {
		String sql = "insert into users (id,pw,name,role) values(?, ?, ?,?)";

		return spring.update(sql, user.getId(), user.getPw(), user.getName(), user.getRole());

	}

	@Override
	public UserVO getUser(String uid) {
		String sql = "select * from users where id = ?";
		UserVO vo = spring.queryForObject(sql, new Object[] { uid }, new UserRowMapper());
		return vo;
	}

	@Override
	public List<UserVO> getUserList() {
		String sql = "select * from users ";
		return spring.query(sql, new UserRowMapper());
	}

	@Override
	public int removeUser(String uid) {
		String sql = "delete from users where id = ?";
		return spring.update(sql, uid);
	}

	@Override
	public int updateUser(UserVO user) {
		String sql = "update users " + " set pw = ?, name = ? where id = ?";

		return spring.update(sql, user.getPw(), user.getName(), user.getId());
	}

	@Override
	public List<UserVO> searchUser(String condition, String keyword) {
		String sql = "select * from users where " + condition + " like '%'||?||'%'";

		return spring.query(sql, new String[] { keyword }, new UserRowMapper());
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
