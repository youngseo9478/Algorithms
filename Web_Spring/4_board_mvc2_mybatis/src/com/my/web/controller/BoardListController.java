package com.my.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.biz.board.dao.BoardDAO;
import com.my.biz.board.dao.BoardDAO_JDBC;
import com.my.biz.board.dao.BoardDAO_Mybatis;
import com.my.biz.board.service.BoardService;
import com.my.biz.board.service.BoardServiceImpl;
import com.my.biz.board.vo.BoardVO;

public class BoardListController implements Controller {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("login") == null) {
			response.sendRedirect("index.jsp?content=login.html");
			return;
		}

		// BoardDAO dao = new BoardDAO_JDBC();
		BoardDAO dao = new BoardDAO_Mybatis();
		BoardService service = new BoardServiceImpl(dao);

		List<BoardVO> list = service.boardSelectAll();
		request.setAttribute("list", list);
		request.setAttribute("content", "boardlist.jsp");
		String view = "index.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}
}
