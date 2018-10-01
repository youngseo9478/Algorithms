package com.my.biz.board.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.my.biz.board.vo.BoardVO;
import com.my.biz.mybatis.mapper.BoardMapper;
import com.my.util.SqlSessionFactoryBean;

public class BoardDAO_Mybatis2_interface implements BoardDAO {
	SqlSession mybatis;
	BoardMapper mapper;

	public BoardDAO_Mybatis2_interface() {
		mybatis = SqlSessionFactoryBean.getSqlSession(true);
		mapper = mybatis.getMapper(BoardMapper.class);
	}

	@Override
	public int boardInsert(BoardVO vo) {
		return mapper.boardadd(vo);
	}

	@Override
	public int boardDelete(int seq) {
		return mapper.boarddel(seq);
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		return mapper.boardupdate(vo);
	}

	@Override
	public List<BoardVO> boardSelectAll() {
		return mapper.boardlist();
	}

	@Override
	public BoardVO boardFind(int seq) {
		BoardVO vo = mapper.boardfind(seq);
		mapper.cnt(vo);
		return mapper.boardfind(seq);
	}

	@Override
	public List<BoardVO> searchBoard(String condition, String keyword) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("condition", condition);
		map.put("keyword", keyword);

		// 혹은 VO에 두 변수를 추가해서 셋겟 메소드 통해서 넘겨줄수도 있음
		// BoardVO vo = new BoardVO();
		// vo.setCondition(condition);
		// vo.setKeyword(keyword);
		// return mybatis.selectList("board.boardsearch2", vo);
		
		return mapper.usersearch(map);
	}

	private void cnt(int seq, int cnt) {
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		vo.setCnt(cnt);
		mapper.boardupdate(vo);
	}
}
