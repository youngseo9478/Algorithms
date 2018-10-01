package test;

import java.util.List;

import com.my.biz.board.dao.BoardDAO;
import com.my.biz.board.dao.BoardDAO_JDBC;
import com.my.biz.board.service.BoardService;
import com.my.biz.board.service.BoardServiceImpl;
import com.my.biz.board.vo.BoardVO;

public class BoardTest {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO_JDBC();
        BoardService service = new BoardServiceImpl(dao);
        // service.boardDelete(1);
        BoardVO vo  = new BoardVO();
        vo.setTitle("sample ");
        vo.setWriter("ko");
        vo.setContent("hello java test");
        //service.boardInsert(vo);
        //System.out.println("insert "+vo);
        
        BoardVO data = service.boardFind(1);
        System.out.println(data);
        data.setContent("update test....");
        service.boardUpdate(data);
        
        //List<BoardVO> list = service.boardSelectAll();
        List<BoardVO> list = service.searchBoard("title","sam");
        System.out.println("검색 목록");
        for(BoardVO d:list) {
        	System.out.println(d.getSeq()+", "+d.getTitle()+" ,"+d.getContent());
        }
        
        
	}
}




