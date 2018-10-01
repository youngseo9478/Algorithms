package com.my.biz.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.my.biz.board.vo.BoardVO;
import com.my.biz.mybatis.mapper.BoardMapper;
import com.my.util.SqlSessionFactoryBean;

//@Component("boardMybatis2")
@Repository("boardMybatis2")
public class BoardDAO_MyBatis_Interface implements BoardDAO{
	@Autowired
	SqlSession mybatis;
	BoardMapper mapper;
	
	
	
	
	public BoardDAO_MyBatis_Interface(SqlSession mybatis) {
		this.mybatis = mybatis;
	}

	public BoardDAO_MyBatis_Interface() {
		//mybatis = SqlSessionFactoryBean.getSqlSession(true);
										//true일 경우 autocommit;
	}	
	
	
	public SqlSession getMybatis() {
		return mybatis;
	}

	public void setMybatis(SqlSession mybatis) {
		this.mybatis = mybatis;
	}
	
	@PostConstruct
	public void init() {
		mapper = mybatis.getMapper(BoardMapper.class);
	}
	
	@Override
	public int boardInsert(BoardVO vo) {
		//return mybatis.update("board.addboard", vo);
		return mapper.addboard(vo);
	}

	@Override
	public int boardDelete(int seq) {
		//return mybatis.update("board.deleteboard", seq);
		
		return mapper.deleteboard(seq);
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		//return mybatis.update("board.updateboard",vo);
		return mapper.updateboard(vo);
	}

	@Override
	public List<BoardVO> boardSelectAll() {
		//return mybatis.selectList("board.boardlist");
		return mapper.boardlist();
	}

	@Override
	public BoardVO boardFind(int seq) {
		//BoardVO vo = mybatis.selectOne("board.getboard", seq);
		BoardVO vo = mapper.getboard(seq);
		if(vo!=null) {
			//mybatis.update("board.cnt", vo);
			mapper.cnt(vo);
		}
		return  vo;
		
	}

	@Override
	public List<BoardVO> searchBoard(String condition, String keyword) {
		//BoardVO vo = new BoardVO();
		//vo.setCondition(condition);
		//vo.setKeyword(keyword);
		//return mybatis.selectList("board.searchboard", vo);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("condition", condition);
		map.put("keyword", keyword);
		return mapper.searchboard(map);
	}
	
	
	public void cnt(int seq, int cnt){
		BoardVO vo = new BoardVO();
		vo.setCnt(cnt);
		vo.setSeq(seq);
		//mybatis.update("board.cnt",vo);
		mapper.cnt(vo);
	}
}
