package com.my.biz.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.my.biz.board.dao.BoardDAO;
import com.my.biz.board.vo.BoardVO;


//@Component("boardService")
@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	//@Autowired
	//@Qualifier("boardJdbc")
	@Resource(name="boardMybatis2")
	BoardDAO dao = null;
	
	public BoardServiceImpl() {	}
	public BoardServiceImpl(BoardDAO dao) {
		this.dao = dao;
	}

	public BoardDAO getDao() {
		return dao;
	}
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}
	@Override
	public int boardInsert(BoardVO vo) {
		return dao.boardInsert(vo);
	}

	@Override
	public int boardDelete(int seq) {
		return dao.boardDelete(seq);
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		return dao.boardUpdate(vo);
	}

	@Override
	public List<BoardVO> boardSelectAll() {
		return dao.boardSelectAll();
	}

	@Override
	public BoardVO boardFind(int seq) {
		return dao.boardFind(seq);
	}

	@Override
	public List<BoardVO> searchBoard(String condition, String keyword) {
		return dao.searchBoard(condition, keyword);
	}

}
