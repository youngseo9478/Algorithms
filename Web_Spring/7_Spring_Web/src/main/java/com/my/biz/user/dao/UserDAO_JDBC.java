package com.my.biz.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.my.biz.user.vo.UserVO;
import com.my.util.JDBCUtil;

@Component("userJdbc")
public class UserDAO_JDBC implements UserDAO {
	Connection con=null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override	
	public UserVO login(String id, String pw) {
		String sql="select * from users where id=? and pw=?";
		con = JDBCUtil.getConnection();
		UserVO vo = null;		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = new UserVO(rs.getString("id"),
										rs.getString("name"),
										rs.getString("pw"),
										rs.getString("role")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		
		return vo;
	}

	@Override
	public int addUser(UserVO user) {
		String sql = "insert into users (id, name, pw, role) values(?,?,?,?)";
			//컬럼명 없을 경우 순서 다르면 꼬일 수 있으므로
		con = JDBCUtil.getConnection();
		int result = 0;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPw());
			ps.setString(4, user.getRole());
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, ps, con);
		}
		
		return result;
	}

	@Override
	public UserVO getUser(String uid) {
		String sql = "select * from users where id=?";
		UserVO vo = null;
		con = JDBCUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, uid);
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = new UserVO(rs.getString("id"),
								rs.getString("name"),
								rs.getString("pw"),
								rs.getString("role")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		
		return vo;
	}

	@Override
	public List<UserVO> getUserList() {
		String sql = "select * from users";
		List<UserVO> list = new ArrayList<UserVO>();
		con = JDBCUtil.getConnection();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				UserVO vo = new UserVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPw(rs.getString("pw"));
				vo.setRole(rs.getString("role"));

				list.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		
		return list;
	}

	@Override
	public int removeUser(String uid) {
		String sql = "delete from users where id=?";
		int result = 0;
		con = JDBCUtil.getConnection();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, uid);
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, ps, con);
		}
		
		return result;
	}

	@Override
	public int updateUser(UserVO user) {
		String sql = "update users set name =?, pw=?, role=? where id=? ";
		int result = 0;
		con = JDBCUtil.getConnection();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPw());
			ps.setString(3, user.getRole());
			ps.setString(4, user.getId());
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(null, ps, con);
		}
		
		return result;
	}

	@Override
	public List<UserVO> searchUser(String condition, String keyword) {
		String sql = "";
		List<UserVO> list = new ArrayList<UserVO>();
		
		if(condition.equalsIgnoreCase("id")) {
			//sql = "select * from users where id=?";
			sql = "select * from users where id like '%'|| ? ||'%' ";
		} else if (condition.equalsIgnoreCase("name")) {
			//sql = "select * from users where name=?";
			sql = "select * from users where name like '%'|| ? ||'%' ";
		} else if (condition.equalsIgnoreCase("role")){
			//sql = "select * from users where role=?";
			sql = "select * from users where role like '%'|| ? ||'%' ";
		} else {
			System.out.println("정확한 condition 입력 필요");
		}
		
		
		con = JDBCUtil.getConnection();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, keyword);
			rs = ps.executeQuery();
			//String id, String name, String pw, String role
			while(rs.next()) {
				UserVO vo = new UserVO(rs.getString("id"),
										rs.getString("name"),
										rs.getString("pw"),
										rs.getString("role")
						);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		
		return list;
	}

}
