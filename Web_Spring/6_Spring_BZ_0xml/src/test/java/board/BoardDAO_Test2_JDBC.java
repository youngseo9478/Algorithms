package board;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.biz.board.dao.BoardDAO;
import com.my.biz.board.dao.BoardDAO_JDBC;
import com.my.biz.board.dao.BoardDAO_Spring;
import com.my.biz.board.service.BoardService;
import com.my.biz.board.service.BoardServiceImpl;
import com.my.biz.board.vo.BoardVO;
import com.my.biz.user.service.UserService;

public class BoardDAO_Test2_JDBC {
	
	BoardService service;

	@Before
	public void setUp() throws Exception {
		String[] config = { "applicationContext.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		service = (BoardService) context.getBean("boardService");
	}

	@After
	public void tearDown() throws Exception {
		service = null;
	}

	//@Test
	public void insert() {
		System.out.println("====insert======");
		BoardVO vo = new BoardVO();
		vo.setTitle("2월1일");
		vo.setWriter("java01");
		vo.setContent("매니저님이 간식 가져다주셨다");
		int row = service.boardInsert(vo);
		if(row==0) {
			System.out.println("insert 실패");
		}else {
			System.out.println(row+"행 삽입하였습니다.");
		}
	}
	//@Test
	public void delete() {
		System.out.println("====delete======");
		int row = service.boardDelete(10);
		if(row==0) {
			System.out.println("delete 실패");
		}else {
			System.out.println(row+"행 delete하였습니다.");
		}
	}
	//@Test
	public void update() {
		System.out.println("====update======");
		BoardVO vo = new BoardVO();
		vo.setTitle("2월의 첫번째 날!!");
		vo.setContent("눈누누누누");
		vo.setSeq(9);
		int row = service.boardUpdate(vo);
		if(row==0) {
			System.out.println("update 실패");
		}else {
			System.out.println(row+"행 update하였습니다.");
		}
	}
	//@Test
	public void selectAll() {
		System.out.println("====selectAll======");
		for(BoardVO vo : service.boardSelectAll()) {
			System.out.println(vo);
		}
	}
	@Test
	public void find() {
		System.out.println("====find======");
		BoardVO vo = service.boardFind(10);
		System.out.println(vo);
	}
	//@Test
	public void search() {
		System.out.println("====search======");
		List<BoardVO> list = service.searchBoard("title", "2월");
		for(BoardVO vo : list) {
			System.out.println(vo);
		}
	}

}
