package com.my.biz.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.my.biz.board.vo.BoardVO;

public class BoardDAO_Spring implements BoardDAO {

	JdbcTemplate spring;

	public BoardDAO_Spring() {
		spring = new JdbcTemplate();
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		dataSource.setUsername("youngseo");
		dataSource.setPassword("1234");
		spring.setDataSource(dataSource);
	}

	@Override
	public int boardInsert(BoardVO vo) {
		String sql = "insert into board (seq,title,writer,content) "
				+ "values((select nvl(max(seq),0)+1 from board),?,?,?)";
		return spring.update(sql,vo.getTitle(),vo.getWriter(),vo.getContent());
	}

	@Override
	public int boardDelete(int seq) {
		String sql = "delete from board where seq = ? ";
		return spring.update(sql,seq);
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		System.out.println("수정" + vo);
		String sql = "update board set title = ?,content = ? where seq = ?";
		return spring.update(sql, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	@Override
	public List<BoardVO> boardSelectAll() {
		String sql = "select * from board";
		return spring.query(sql, new BoardRowMapper());
	}

	@Override
	public BoardVO boardFind(int seq) {
		String sql = "select * from board where seq = ? ";
		Object[] obj = {seq};
		BoardVO data = spring.queryForObject(sql, obj, new BoardRowMapper());
		cnt(seq, data.getCnt()+1);
		return spring.queryForObject(sql, obj, new BoardRowMapper());
	}

	@Override
	public List<BoardVO> searchBoard(String condition, String keyword) {
		String sql = "";
		if (condition.equals("title")) {
			sql = "select * from board where title like '%'|| ? ||'%' ";
		} else if (condition.equals("writer")) {
			sql = "select * from board where writer like '%'|| ? ||'%' ";
		} else if (condition.equals("content")) {
			sql = "select * from board where content like '%'|| ? ||'%' ";
		}
		return spring.query(sql, new Object[] {keyword}, new BoardRowMapper());
	}

	private void cnt(int seq, int cnt) { //외부에 노출하지 않는 메소드이기때문에 private으로 처리
		String sql = "update board set cnt = ? where seq = ?";
		Object[] obj = {cnt,seq};
		spring.update(sql,obj);
	}
}

class BoardRowMapper implements RowMapper<BoardVO> {

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO vo = new BoardVO();
		vo.setCnt(rs.getInt("cnt"));
		vo.setContent(rs.getString("content"));
		//vo.setRegdate(rs.getDate("date"));
		vo.setSeq(rs.getInt("seq"));
		vo.setTitle(rs.getString("title"));
		vo.setUserid(rs.getString("userid"));
		vo.setWriter(rs.getString("writer"));
		return vo;
	}

}
