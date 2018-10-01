package com.my.biz.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.my.biz.board.vo.BoardVO;

public class BoardDAO_Spring implements BoardDAO {
    JdbcTemplate spring;
    
	public BoardDAO_Spring(JdbcTemplate spring) {
		this.spring = spring;
	}
	public BoardDAO_Spring(){
       /*
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		dataSource.setUsername("java01");
		dataSource.setPassword("1234");
		
    	spring = new JdbcTemplate(dataSource);
       */
    }
	
    
	public JdbcTemplate getSpring() {
		return spring;
	}
	public void setSpring(JdbcTemplate spring) {
		this.spring = spring;
	}
	@Override
	public int boardInsert(BoardVO vo) {
		String sql = "insert into board (seq,title,writer,content) "
				+ "values((select nvl(max(seq),0)+1 from board),?,?,?)";
		
		Object[] obj = {vo.getTitle(),vo.getWriter(),vo.getContent()};
		return spring.update(sql,obj);
	}

	@Override
	public int boardDelete(int seq) {
		String sql = "delete from board where seq = ? ";
		Object[] obj = {seq};

		return spring.update(sql,obj);
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		System.out.println("수정"+vo);
		String sql = 
			"update board set title = ?,content = ? where seq = ?";
		Object[] obj = {vo.getTitle(),vo.getContent(),vo.getSeq()};

		return spring.update(sql,obj);
	}

	@Override
	public List<BoardVO> boardSelectAll() {
		String sql = "select * from board order by seq desc";
		
		return spring.query(sql, new BoardRowMapper());
	}

	@Override
	public BoardVO boardFind(int seq) {
		String sql = "select * from board where seq = ? ";
		
		Object[] obj = {seq};
		BoardVO vo = spring.queryForObject(sql,obj ,new BoardRowMapper());
		if(vo != null) {
            cnt(seq, vo.getCnt()+1);
		}
		return vo;
	}

	@Override
	public List<BoardVO> searchBoard(String condition, String keyword) {
		String sql = "";
		sql = "select * from board where " + condition + " like  '%'||?||'%'  ";
		Object[] obj = {keyword};
		return spring.query(sql,obj, new BoardRowMapper());
	}

	private void cnt(int seq,int cnt) {
		String sql = "update board set cnt = ? where seq = ?";
		Object[] obj = {cnt,seq};
		spring.update(sql,obj);
	}
}

class BoardRowMapper implements RowMapper<BoardVO>{
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		BoardVO data = new BoardVO();
		data.setCnt(rs.getInt("cnt"));
		data.setSeq(rs.getInt("seq"));
		data.setContent(rs.getString("content"));
		data.setTitle(rs.getString("title"));
		data.setWriter(rs.getString("writer"));
		data.setUserid(rs.getString("userid"));
		data.setRegdate(rs.getDate("regdate"));
		return data;
	}
}












