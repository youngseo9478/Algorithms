package com.my.biz.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.my.biz.board.vo.BoardVO;

//@Component("boardSpring")
@Repository("boardSpring")
public class BoardDAO_Spring implements BoardDAO {
	
	//@Inject
	@Autowired
	JdbcTemplate spring;

	public BoardDAO_Spring() {
		/*spring = new JdbcTemplate();
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		dataSource.setUsername("java01");
		dataSource.setPassword("1234");
		spring.setDataSource(dataSource);*/
		
	}

	public BoardDAO_Spring(JdbcTemplate spring) {
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
	public int boardInsert(BoardVO vo) {
		String sql = "insert into board (seq,title,writer,content) " + 
				"values((select nvl(max(seq),0)+1 from board),?,?,?)";
		//return spring.update(sql, vo.getTitle(), vo.getWriter(), vo.getContent());
		
		Object[] obj = {vo.getTitle(), vo.getWriter(), vo.getContent()};
		return spring.update(sql, obj);
	}

	@Override
	public int boardDelete(int seq) {
		String sql = "delete from board where seq = ?";	
		return spring.update(sql, seq);
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		String sql = "update board set title = ?, content = ? where seq = ?";
		return spring.update(sql, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	@Override
	public List<BoardVO> boardSelectAll() {
		String sql = "select * from board order by seq desc";
		return spring.query(sql, new BoardRowMapper());
	}

	@Override
	public BoardVO boardFind(int seq) {
		String sql = "select * from board where seq = ? ";
		//return spring.queryForObject(sql,new Object[] {seq}, new BoardRowMapper());
		Object[] obj= {seq};
		//return spring.queryForObject(sql,obj, new BoardRowMapper());
		BoardVO vo = spring.queryForObject(sql,obj ,new BoardRowMapper());
		if(vo != null) {
            cnt(seq, vo.getCnt()+1);
		}
		return vo;

	}

	@Override
	public List<BoardVO> searchBoard(String condition, String keyword) {
		String sql = "select * from board where "+condition+" like '%'|| ? || '%' ";
		//return spring.query(sql, new Object[] {keyword}, new BoardRowMapper());
		Object[] obj = {keyword};
		return spring.query(sql, obj, new BoardRowMapper());
		
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

