package com.my.biz.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.core.RowMapper;

import com.my.biz.board.vo.BoardVO;
import com.my.util.SqlSessionFactoryBean;

public class BoardDAO_Mybatis implements BoardDAO {
	SqlSession mybatis;

	public BoardDAO_Mybatis() {
		mybatis = SqlSessionFactoryBean.getSqlSession(true);
	}

	@Override
	public int boardInsert(BoardVO vo) {
		return mybatis.update("board.boardinsert", vo);
	}

	@Override
	public int boardDelete(int seq) {
		return mybatis.update("board.boarddel", seq);
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		return mybatis.update("board.boardupdate", vo);
	}

	@Override
	public List<BoardVO> boardSelectAll() {
		return mybatis.selectList("board.boardlist");
	}

	@Override
	public BoardVO boardFind(int seq) {
		BoardVO data = mybatis.selectOne("board.boardfind", seq);
		cnt(seq, data.getCnt());
		return mybatis.selectOne("board.boardfind", seq);
	}

	@Override
	public List<BoardVO> searchBoard(String condition, String keyword) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(condition, keyword);

		// 혹은 VO에 두 변수를 추가해서 셋겟 메소드 통해서 넘겨줄수도 있음
		// BoardVO vo = new BoardVO();
		// vo.setCondition(condition);
		// vo.setKeyword(keyword);
		// return mybatis.selectList("board.boardsearch2", vo);
		
		return mybatis.selectList("board.boardsearch", map);
	}

	private void cnt(int seq, int cnt) {
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		vo.setCnt(cnt);
		mybatis.update("board.cnt", vo);
	}
}
