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
public class BoardDAO_JDBC implements BoardDAO{

	@Override
	public int boardInsert(BoardVO vo) {
		String sql = "insert into board (seq,title,writer,content) " + 
				"values((select nvl(max(seq),0)+1 from board),?,?,?)";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO data = null;
		int row = 0;
				
		try {
			con = JDBCUtil.getConnection();
			System.out.println(con);
			//con = DataSourceUtil.getConnection();	//테스트 시 톰캣 환경에서
			ps = con.prepareStatement(sql);
			//? 세팅 작업
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getWriter());
			ps.setString(3, vo.getContent());
			//실행	//결과 값 핸들링
			System.out.println("addBoard dao1");
			row = ps.executeUpdate();
			System.out.println("addBoard dao2");
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		
		return row;
	}

	@Override
	public int boardDelete(int seq) {
		String sql = "delete from board where seq = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO data = null;
		int row = 0;
		//cnt 증가 처리
		
		try {
			con = JDBCUtil.getConnection();	
			//con = DataSourceUtil.getConnection()
			ps = con.prepareStatement(sql);
			//? 세팅 작업
			ps.setInt(1, seq);
			//실행 및 결과 값 핸들링
			row = ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		
		return row;
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		String sql = "update board set title = ?, content = ? where seq = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO data = null;
		int row = 0;
				
		try {
			con = JDBCUtil.getConnection();	
			//con = DataSourceUtil.getConnection()
			ps = con.prepareStatement(sql);
			//? 세팅 작업
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			ps.setInt(3, vo.getSeq());
			//실행 //결과 값 핸들링
			row = ps.executeUpdate();

			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		
		return row;
	}

	@Override
	public List<BoardVO> boardSelectAll() {
		String sql = "select * from board order by seq desc";	//정렬까지 (최근 게시물부터)
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO data = null;
		int row = 0;
		List<BoardVO> list = new ArrayList<BoardVO>();		
		try {
			con = JDBCUtil.getConnection();	//테스트 시 톰캣 환경에서
			//con = DataSourceUtil.getConnection()
			ps = con.prepareStatement(sql);
			//? 세팅 작업
			//실행
			rs = ps.executeQuery();
			//결과 값 핸들링
			while(rs.next()) {
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

			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		
		return list;
	}

	@Override
	public BoardVO boardFind(int seq) {	//게시물 상세 내용 보기
		String sql = "select * from board where seq = ? ";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO data = null;
		int row = 0;
				
		try {
			con = JDBCUtil.getConnection();	//테스트 시 톰캣 환경에서
			//con = DataSourceUtil.getConnection()
			ps = con.prepareStatement(sql);
			//? 세팅 작업
			ps.setInt(1, seq);
			//실행
			rs = ps.executeQuery();
			//결과 값 핸들링
			while(rs.next()) {
				data = new BoardVO();
				data.setCnt(rs.getInt("cnt"));
				data.setSeq(rs.getInt("seq"));
				data.setContent(rs.getString("content"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setUserid(rs.getString("userid"));
				data.setRegdate(rs.getDate("regdate"));
			}


		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		
		return data;
	}

	@Override
	public List<BoardVO> searchBoard(String condition, String keyword) {
		String sql = "";
		//String sql = "select * from board where ? = ? ";	//?=? -> 오류
		//like 사용
		//condition 처리 -> if 사용. 또는 변수 처리
		//like '%keyword%'
		if(condition.equals("title")) {
			sql = "select * from board where title like '%'|| ? ||'%' ";
		} else { 
			sql = "select * from board where writer like '%'|| ? ||'%' ";
		}
		sql = "select * from board where "+condition+" like ? ";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO data = null;
		int row = 0;
		List<BoardVO> list = new ArrayList<BoardVO>();
				
		try {
			con = JDBCUtil.getConnection();	
			//con = DataSourceUtil.getConnection()
			ps = con.prepareStatement(sql);
			//? 세팅 작업
			//ps.setString(1, keyword);
			ps.setString(1, "%"+keyword+"%");
			//실행
			rs = ps.executeQuery();
			//결과 값 핸들링
			while(rs.next()) {
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
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		
		return list;
	}

}
