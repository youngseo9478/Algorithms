package test_board;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.my.biz.board.dao.BoardDAO;
import com.my.biz.board.dao.BoardDAO_Mybatis2_interface;
import com.my.biz.board.service.BoardService;
import com.my.biz.board.service.BoardServiceImpl;
import com.my.biz.board.vo.BoardVO;

public class BoardDAO_Test_Mybatis2_interface {

	BoardService service;

	@Before
	public void setUp() throws Exception {
		BoardDAO dao = new BoardDAO_Mybatis2_interface();
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
		vo.setTitle("2월2일 과제 테스트1");
		vo.setWriter("영서");
		vo.setContent("되겠지...?");
		service.boardInsert(vo);
	}
	
	//@Test
	public void boardsearch() {
		for(BoardVO vo : service.searchBoard("title", "2월")) {
			System.out.println(vo);
		}
	}
	//@Test
	public void boardfind() {
		service.boardFind(11);
	}
	
	//@Test
	public void boarddelete() {
		service.boardDelete(0);
	}
	
	@Test
	public void boardupdate() {
		BoardVO vo = new BoardVO();
		vo.setSeq(5);
		vo.setTitle("Mybatis+Spring 연동 테스트 ");
		vo.setContent("Mybatis+Spring 연동 테스트 완료!!!!");
		service.boardUpdate(vo);
	}
}
