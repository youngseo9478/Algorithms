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

public class DeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, 
			               HttpServletResponse response)
			            throws ServletException, IOException {
      
		String[] seqs = request.getParameterValues("seq");
		
		BoardDAO dao = new BoardDAO_JDBC();
		BoardService service = new BoardServiceImpl(dao);
		for(int i=0; i<seqs.length;i++) {
		   service.boardDelete(Integer.parseInt(seqs[i]));
		}
		
		response.sendRedirect("listBoard.do");
	}

}
