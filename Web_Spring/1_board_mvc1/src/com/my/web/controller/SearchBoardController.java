package com.my.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.biz.board.dao.BoardDAO;
import com.my.biz.board.dao.BoardDAO_JDBC;
import com.my.biz.board.service.BoardService;
import com.my.biz.board.service.BoardServiceImpl;
import com.my.biz.board.vo.BoardVO;

public class SearchBoardController implements Controller {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest request, 
			               HttpServletResponse response) 
					throws ServletException, IOException {
		
		BoardDAO dao = new BoardDAO_JDBC();
		BoardService service = new BoardServiceImpl(dao);
		
		String condition = request.getParameter("condition");
		String keyword = request.getParameter("keyword");
		
		List<BoardVO> list = service.searchBoard(condition, keyword);
	    request.setAttribute("list", list);
	    request.setAttribute("content", "boardlist.jsp");
	    String view = "index.jsp";
	    request.getRequestDispatcher(view).forward(request, response);
	}

}
