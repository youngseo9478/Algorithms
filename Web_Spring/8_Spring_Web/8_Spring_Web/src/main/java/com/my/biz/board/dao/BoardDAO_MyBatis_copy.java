package com.my.biz.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.my.biz.board.vo.BoardVO;
import com.my.util.SqlSessionFactoryBean;

public class BoardDAO_MyBatis_copy implements BoardDAO{
	//과제 제출
	SqlSession mybatis;
	
	public BoardDAO_MyBatis_copy() {
		mybatis = SqlSessionFactoryBean.getSqlSession(true);
										//true일 경우 autocommit;
	}	

	@Override
	public int boardInsert(BoardVO vo) {
		return mybatis.update("board.boardinsert", vo);
	}

	@Override
	public int boardDelete(int seq) {
		return mybatis.update("board.boarddelete", seq);
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		return mybatis.update("board.boardupdate",vo);
	}

	@Override
	public List<BoardVO> boardSelectAll() {
		return mybatis.selectList("board.boardselectall");
	}

	@Override
	public BoardVO boardFind(int seq) {
		return mybatis.selectOne("board.boardfind", seq);
	}

	@Override
	public List<BoardVO> searchBoard(String condition, String keyword) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(condition, keyword);
		return mybatis.selectList("board.searchboard", map);
	}

}
