package board;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.my.biz.board.dao.BoardDAO;
import com.my.biz.board.dao.BoardDAO_Mybatis;
import com.my.biz.board.service.BoardService;
import com.my.biz.board.service.BoardServiceImpl;
import com.my.biz.board.vo.BoardVO;

public class BoardDAO_Test {
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
	public void list() {
		System.out.println("==== User List ====");
		for(BoardVO data  :service.boardSelectAll()) {
			System.out.println(data);
		}
	}
	//@Test
	public void add() {
		BoardVO vo = new BoardVO();
	    vo.setTitle("~~~");
	    vo.setContent("...");
	    vo.setWriter("...");
	    int row = service.boardInsert(vo);
	    if(row == 0) {
	    	System.out.println("인서트 실패");
	    }
	}
	
	//@Test
	public void update() {
		BoardVO vo = service.boardFind(10);
	   vo.setTitle("수정 ~~");
	   service.boardUpdate(vo);
	}
	@Test
	public void getBoard() {
	   System.out.println(service.boardFind(10));
	}
	//@Test
	public void search() {
		List<BoardVO> list = service.searchBoard("writer", "k");
		System.out.println("===== 검색 =====");
		for(BoardVO data :list) {
			System.out.println(data);
		}
	}
	//@Test
	public void delete() {
	     int row =service.boardDelete(10);
	     if(row == 0) {
	    	 System.out.println("java09 삭제 X");
	     }
	}
}









