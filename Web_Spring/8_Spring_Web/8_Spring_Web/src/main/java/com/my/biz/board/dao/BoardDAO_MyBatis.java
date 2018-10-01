package com.my.biz.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.my.biz.board.vo.BoardVO;
import com.my.util.SqlSessionFactoryBean;

//@Component("boardMybatis1")
@Repository("boardMybatis1")
public class BoardDAO_MyBatis implements BoardDAO{
	
	@Autowired
	SqlSession mybatis;
	
	public BoardDAO_MyBatis() {
		/*mybatis = SqlSessionFactoryBean.getSqlSession(true);
										//true일 경우 autocommit;
		*/	
	}

	public BoardDAO_MyBatis(SqlSession mybatis) {
		this.mybatis = mybatis;
	}

	public SqlSession getMybatis() {
		return mybatis;
	}

	public void setMybatis(SqlSession mybatis) {
		this.mybatis = mybatis;
	}

	@Override
	public int boardInsert(BoardVO vo) {
		return mybatis.update("board.addboard", vo);
	}

	@Override
	public int boardDelete(int seq) {
		return mybatis.update("board.deleteboard", seq);
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		return mybatis.update("board.updateboard",vo);
	}

	@Override
	public List<BoardVO> boardSelectAll() {
		return mybatis.selectList("board.boardlist");
	}

	@Override
	public BoardVO boardFind(int seq) {
		BoardVO vo = mybatis.selectOne("board.getboard", seq);
		if(vo!=null) {
		mybatis.update("board.cnt", vo);
		}
		return  vo;
	}

	@Override
	public List<BoardVO> searchBoard(String condition, String keyword) {
		BoardVO vo = new BoardVO();
		vo.setCondition(condition);
		vo.setKeyword(keyword);
		return mybatis.selectList("board.searchboard", vo);
	}
	
	
	private void cnt(int seq, int cnt){
		BoardVO vo = new BoardVO();
		vo.setCnt(cnt);
		vo.setSeq(seq);
		mybatis.update("board.cnt",vo);
	}
}
