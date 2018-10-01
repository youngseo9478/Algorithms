package com.my.biz.board.service;

import java.util.List;
import com.my.biz.board.vo.BoardVO;

public interface BoardService {
	public int boardInsert(BoardVO vo);
	public int boardDelete(int seq);
	public int boardUpdate(BoardVO vo);
	public List<BoardVO> boardSelectAll();
	public BoardVO boardFind(int seq);
	public List<BoardVO> searchBoard(String condition, String keyword);

}
