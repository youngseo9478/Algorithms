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

public class DeleteBoardController implements Controller {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] seqs = request.getParameterValues("seq");

		// BoardDAO dao = new BoardDAO_JDBC();
		BoardDAO dao = new BoardDAO_Mybatis();
		BoardService service = new BoardServiceImpl(dao);
		for (int i = 0; i < seqs.length; i++) {
			service.boardDelete(Integer.parseInt(seqs[i]));
		}

		response.sendRedirect("listBoard.do");
	}

}
