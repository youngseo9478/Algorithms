package com.my.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.biz.board.dao.BoardDAO;
import com.my.biz.board.dao.BoardDAO_JDBC;
import com.my.biz.board.dao.BoardDAO_Mybatis;
import com.my.biz.board.service.BoardService;
import com.my.biz.board.service.BoardServiceImpl;
import com.my.biz.board.vo.BoardVO;

public class UpdateBoardController implements Controller {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// BoardDAO dao = new BoardDAO_JDBC();
		BoardDAO dao = new BoardDAO_Mybatis();
		BoardService service = new BoardServiceImpl(dao);
		String seq = request.getParameter("seq");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setSeq(Integer.parseInt(seq));

		service.boardUpdate(vo);

		response.sendRedirect("listBoard.do");
	}
}
