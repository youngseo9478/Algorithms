package com.my.biz.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.my.biz.user.vo.UserVO;
import com.my.util.DataSourceUtil;
import com.my.util.JDBCUtil;

public class UserDAO_JDBC implements UserDAO{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	@Override
	public UserVO login(String id, String pw) {
		String sql = "select * from users "
				+ " where id = ? and pw = ?";
		UserVO vo = null;
		con = DataSourceUtil.getConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new UserVO(
						rs.getString("id"), 
						rs.getString("pw"), 
						rs.getString("name"), 
						rs.getString("role")); 
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		return vo;
	}

	@Override
	public int addUser(UserVO user) {
		String sql = 
			"insert into users (id,pw,name,role) values(?, ?, ?,?)";
		con = DataSourceUtil.getConnection();
		int row = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getPw());
			ps.setString(3, user.getName());
			ps.setString(4, user.getRole());
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		return row;
	}

	@Override
	public UserVO getUser(String uid) {
		String sql = "select * from users where id = ?";
		con = DataSourceUtil.getConnection();
		UserVO vo = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, uid);
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = new UserVO(uid, rs.getString("pw"), 
						rs.getString("name"), rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		return vo;
	}

	@Override
	public List<UserVO> getUserList() {
		String sql = "select * from users";
		con = DataSourceUtil.getConnection();
		List<UserVO> list = new ArrayList<UserVO>();
		UserVO vo = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = new UserVO(rs.getString("id"), rs.getString("pw"), 
						rs.getString("name"), rs.getString("role"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		return list;
	}

	@Override
	public int removeUser(String uid) {
		String sql = "delete from users where id = ?";
		con = DataSourceUtil.getConnection();
		int row = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, uid);
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		return row;
	}

	@Override
	public int updateUser(UserVO user) {
		String sql = "update users "
				+ "set pw = ?, name = ? where id = ?";
		con = DataSourceUtil.getConnection();
		int row = 0;
		try {
			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getPw());
			ps.setString(2, user.getName());
			ps.setString(3, user.getId());
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		return row;
	}

	@Override
	public List<UserVO> searchUser(String condition, String keyword) {
		String sql = "";
		con = DataSourceUtil.getConnection();
		List<UserVO> list = new ArrayList<UserVO>();
		UserVO vo = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, keyword);
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = new UserVO(rs.getString("id"), rs.getString("pw"), 
						rs.getString("name"), rs.getString("role"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		return list;
		
	}
}
