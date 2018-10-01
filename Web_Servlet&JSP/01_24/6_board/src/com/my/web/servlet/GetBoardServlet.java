package com.my.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.biz.board.dao.BoardDAO;
import com.my.biz.board.dao.BoardDAO_JDBC;
import com.my.biz.board.service.BoardService;
import com.my.biz.board.service.BoardServiceImpl;
import com.my.biz.board.vo.BoardVO;

public class GetBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, 
			               HttpServletResponse response) 
					throws ServletException, IOException {
		
		BoardDAO dao = new BoardDAO_JDBC();
		BoardService service = new BoardServiceImpl(dao);
		
		String seq = request.getParameter("seq");
		
		BoardVO data = service.boardFind(Integer.parseInt(seq));
		request.setAttribute("board", data);
		String view = "board.jsp";
		
		request.getRequestDispatcher(view).forward(request, response);
	}
}






