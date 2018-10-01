package com.my.biz.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.my.biz.board.vo.BoardVO;
import com.my.util.DataSourceUtil;
import com.my.util.JDBCUtil;

@Component("boardJdbc")
public class BoardDAO_JDBC implements BoardDAO {

	@Override
	public int boardInsert(BoardVO vo) {
		String sql = "insert into board (seq,title,writer,content) "
				+ "values((select nvl(max(seq),0)+1 from board),?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO data = null;
		int row = 0;
		try {
			// con = JDBCUtil.getConnection();
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅 작업
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getWriter());
			ps.setString(3, vo.getContent());
			// 실행 //결과값 핸들링
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		return row;
	}

	@Override
	public int boardDelete(int seq) {
		String sql = "delete from board where seq = ? ";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO data = null;
		int row = 0;

		try {
			// con = DataSourceUtil.getConnection();
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅 작업
			ps.setInt(1, seq);
			// 실행 //결과값 핸들링
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		return row;
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		System.out.println("수정"+vo);
		String sql = 
			"update board set title = ?,content = ? where seq = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO data = null;
		int row = 0;
		try {
			// con = DataSourceUtil.getConnection();
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅 작업
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			ps.setInt(3, vo.getSeq());
			// 실행 //결과값 핸들링
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		return row;
	}

	@Override
	public List<BoardVO> boardSelectAll() {
		String sql = "select * from board order by seq desc";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO data = null;
		int row = 0;
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			// con = DataSourceUtil.getConnection();
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅 작업
			// 실행
			rs = ps.executeQuery();
			// 결과값 핸들링
			while (rs.next()) {
				data = new BoardVO();
				data.setCnt(rs.getInt("cnt"));
				data.setSeq(rs.getInt("seq"));
				data.setContent(rs.getString("content"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setUserid(rs.getString("userid"));
				data.setRegdate(rs.getDate("regdate"));
				list.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		return list;
	}

	@Override
	public BoardVO boardFind(int seq) {
		String sql = "select * from board where seq = ? ";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO data = null;
		int row = 0;

		try {
			// con = DataSourceUtil.getConnection();
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅 작업
			ps.setInt(1, seq);
			// 실행
			rs = ps.executeQuery();
			// 결과값 핸들링
			while (rs.next()) {
				data = new BoardVO();
				data.setCnt(rs.getInt("cnt"));
				data.setSeq(rs.getInt("seq"));
				data.setContent(rs.getString("content"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setUserid(rs.getString("userid"));
				data.setRegdate(rs.getDate("regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		cnt(seq,data.getCnt());
		return data;
	}

	@Override
	public List<BoardVO> searchBoard(String condition, String keyword) {
		String sql = "";
		if (condition.equals("title")) {
			sql = "select * from board where title like '%'|| ? ||'%' ";
		} else {
			sql = "select * from board where writer like '%'|| ? ||'%' ";
		}
		sql = "select * from board where " + condition + " like  ?  ";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO data = null;
		int row = 0;
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			// con = DataSourceUtil.getConnection();
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅 작업
			// ps.setString(1, keyword);
			ps.setString(1, "%" + keyword + "%");
			// 실행
			rs = ps.executeQuery();
			// 결과값 핸들링
			while (rs.next()) {
				data = new BoardVO();
				data.setCnt(rs.getInt("cnt"));
				data.setSeq(rs.getInt("seq"));
				data.setContent(rs.getString("content"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setUserid(rs.getString("userid"));
				data.setRegdate(rs.getDate("regdate"));
				list.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		return list;
	}

	private void cnt(int seq,int cnt) {
		String sql = "update board set cnt = ? where seq = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		try {
			// con = DataSourceUtil.getConnection();
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅 작업
			ps.setInt(1, cnt+1);
			ps.setInt(2, seq);
			// 실행 //결과값 핸들링
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
	}
}
