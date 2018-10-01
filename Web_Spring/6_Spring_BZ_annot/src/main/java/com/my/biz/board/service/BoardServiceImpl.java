package com.my.biz.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.my.biz.board.dao.BoardDAO;
import com.my.biz.board.vo.BoardVO;

//@Component("boardService")
@Service("boardService")
public class BoardServiceImpl implements BoardService {

	// @Autowired
	// @Qualifier("boardJdbc")
	// @Resource(name="boardJdbc")
	@Resource(name = "boardSpring")
	// @Resource(name="boardMybatis1")
	// @Resource(name="boardMybatis2")
	BoardDAO dao = null;

	public BoardServiceImpl() {
	}

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
		// TODO Auto-generated method stub
		return dao.boardInsert(vo);
	}

	@Override
	public int boardDelete(int seq) {
		// TODO Auto-generated method stub
		return dao.boardDelete(seq);
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.boardUpdate(vo);
	}

	@Override
	public List<BoardVO> boardSelectAll() {
		// TODO Auto-generated method stub
		return dao.boardSelectAll();
	}

	@Override
	public BoardVO boardFind(int seq) {
		// TODO Auto-generated method stub
		return dao.boardFind(seq);
	}

	@Override
	public List<BoardVO> searchBoard(String condition, String keyword) {
		// TODO Auto-generated method stub
		return dao.searchBoard(condition, keyword);
	}

}
