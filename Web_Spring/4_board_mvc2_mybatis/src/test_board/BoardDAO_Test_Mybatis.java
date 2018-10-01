package test_board;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.my.biz.board.dao.BoardDAO;
import com.my.biz.board.dao.BoardDAO_Mybatis;
import com.my.biz.board.service.BoardService;
import com.my.biz.board.service.BoardServiceImpl;
import com.my.biz.board.vo.BoardVO;

public class BoardDAO_Test_Mybatis {

	BoardService service;

	@Before
	public void setUp() throws Exception {
		BoardDAO dao = new BoardDAO_Mybatis();
		service = new BoardServiceImpl(dao);
	}

	@After
	public void tearDown() throws Exception {
		service = null;
	}

	//@Test
	public void boardlist() {
		for (BoardVO vo : service.boardSelectAll()) {
			System.out.println(vo);
		}
	}
	
	//@Test
	public void boardinsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("2월1일 과제 테스트1");
		vo.setWriter("영떠르릉");
		vo.setContent("하위쿼리가 작동할 것인가...?");
		service.boardInsert(vo);
	}
	
	@Test
	public void boardsearch() {
		for(BoardVO vo : service.searchBoard("title", "2월")) {
			System.out.println(vo);
		}
	}
	//@Test
	public void boardfind() {
		service.boardFind(10);
	}
	
	//@Test
	public void boarddelete() {
		service.boardDelete(4);
	}
	
	//@Test
	public void boardupdate() {
		BoardVO vo = new BoardVO();
		vo.setSeq(5);
		vo.setTitle("Mybatis 테스트 완료 가능?");
		vo.setContent("Mybatis 테스트 완료!!!!");
		service.boardUpdate(vo);
	}
}
