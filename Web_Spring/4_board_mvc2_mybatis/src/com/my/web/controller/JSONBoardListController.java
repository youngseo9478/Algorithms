package com.my.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.my.biz.board.dao.BoardDAO;
import com.my.biz.board.dao.BoardDAO_JDBC;
import com.my.biz.board.dao.BoardDAO_Mybatis;
import com.my.biz.board.service.BoardService;
import com.my.biz.board.service.BoardServiceImpl;
import com.my.biz.board.vo.BoardVO;

/*@WebServlet("json.do")*/
public class JSONBoardListController implements Controller {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		/*
		 * 로그인 안해도 서비스 받게끔 지워버렸음 HttpSession session = request.getSession();
		 * if(session.getAttribute("login") == null) {
		 * response.sendRedirect("index.jsp?content=login.html"); return; }
		 */
		// 프린트하기위함
		PrintWriter out = response.getWriter();
		// 배열로 만들기 위함
		JSONArray array = new JSONArray();

		// BoardDAO dao = new BoardDAO_JDBC();
		BoardDAO dao = new BoardDAO_Mybatis();
		BoardService service = new BoardServiceImpl(dao);

		List<BoardVO> list = service.boardSelectAll();
		JSONObject json = new JSONObject(); // json객체로 바꿔주는 것
		for (BoardVO vo : list) {
			json.put("seq", vo.getSeq());
			json.put("writer", vo.getWriter());
			json.put("title", vo.getTitle());
			// json.put("regdate", vo.getRegdate()); //파싱할때 에러남 날짜는..?왜지??

			// 배열에 담아주는 것
			array.add(json);

			// for문 수행할 때 마다 찍어주는 것
			// out.println(vo);
			// out.println("<hr>");
			// out.print(json.toJSONString());
		}
		// for문 안에서 배열에 데이터를 착착 담아낸 후에 한번에 찍어내는 것
		out.println(array.toJSONString());
		out.close();
		/*
		 * 아래처럼 결과값을 뿌려주는거 아니고 그냥 위의 과정을 통해 제이슨 형태로 바꾸려는 것 request.setAttribute("list",
		 * list); request.setAttribute("content", "boardlist.jsp"); String view =
		 * "index.jsp"; request.getRequestDispatcher(view).forward(request, response);
		 */

	}
}
