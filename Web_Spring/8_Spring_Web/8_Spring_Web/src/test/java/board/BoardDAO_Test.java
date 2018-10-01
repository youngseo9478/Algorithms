package board;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.biz.board.dao.BoardDAO;
import com.my.biz.board.dao.BoardDAO_MyBatis;
import com.my.biz.board.service.BoardService;
import com.my.biz.board.service.BoardServiceImpl;
import com.my.biz.board.vo.BoardVO;

public class BoardDAO_Test {
	BoardService service;
	
	@Before
	public void setUp() throws Exception {
		/*BoardDAO dao = new BoardDAO_MyBatis();
		service = new BoardServiceImpl(dao); */
		
		String[] config = {"applicationContext.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		service = (BoardService) context.getBean("boardService");
	}

	@After
	public void tearDown() throws Exception {
		service = null;
	}

	//@Test
	public void boardInsert() {
		BoardVO vo = new BoardVO();
		vo.setCnt(0);
		vo.setContent("content");
		vo.setTitle("테스트1");
		//vo.setUserid("java01");
		vo.setWriter("작성자");
		int row = service.boardInsert(vo);
		System.out.println("boardInsert() row: "+row);
		System.out.println("========= boardInsert() 리스트 시작 =========");
		for(BoardVO data : service.boardSelectAll()) {
			System.out.println(data);
		}
		System.out.println("========= boardInsert() 리스트 끝 =========");
		
	}
	
	//@Test
	public void boardUpdate() {
		System.out.println("boardUpdate()");
		BoardVO vo = service.boardFind(8);
		System.out.println("수정전 : "+vo);
		vo.setTitle("테스트중!!!!");
		service.boardUpdate(vo);
		System.out.println("수정후 : "+vo);
	}
	
	//@Test
	public void boardDelete() {
		int row = service.boardDelete(10);
		System.out.println("boardDelete() row: "+row);
		if(row==0) {
			System.out.println("삭제 실패");
		} else {
		System.out.println("========= boardDelete() list 시작 =========");
		for(BoardVO data : service.boardSelectAll()) {
			System.out.println(data);
		}
		System.out.println("========= boardDelete() list  끝 =========");
		}
	}
	
	//@Test
	public void list() {
		System.out.println("========= boardSelectAll() 시작 =========");
		for(BoardVO data : service.boardSelectAll()) {
			System.out.println(data);
		}
		System.out.println("========= boardSelectAll() 끝 =========");
	}

	//@Test
	public void boardFind(){
		if(service.boardFind(8)==null) {
			System.out.println("결과값없음");
		} else {
		System.out.println("boardFind() : "+service.boardFind(8));
		}
		
	}
		
	
	//@Test
	public void searchBoard() {
		System.out.println("========= searchBoard() 시작 =========");
		for(BoardVO data : service.searchBoard("title", "테스트")) {
			System.out.println(data);
		}
		System.out.println("========= searchBoard"
				+ "() 끝 =========");
				
	}
	
}
