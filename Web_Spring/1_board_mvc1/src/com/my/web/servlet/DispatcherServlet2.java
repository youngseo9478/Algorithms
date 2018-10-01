package com.my.web.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.web.controller.AddBoardController;
import com.my.web.controller.AddUserController;
import com.my.web.controller.BoardListController;
import com.my.web.controller.DeleteBoardController;
import com.my.web.controller.GetBoardController;
import com.my.web.controller.LoginController;
import com.my.web.controller.LogoutController;
import com.my.web.controller.UpdateBoardController;
 //구버전 맵을 이용하는게 보편적이고 그거는 디스패처1
public class DispatcherServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}

	protected void service(HttpServletRequest request, 
			               HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("DispatcherServlet");
		//System.out.println("url"+request.getRequestURL());
		//System.out.println("uri"+request.getRequestURI());
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("path "+path);
		
		//if-else나 switch-case문을 사용할 수도 있지만 map구조가 가장 편리해서 그렇게 바꿀것임 
		switch (path) {
		case "/login.do":
			new LoginController().service(request, response);
			break;
		case "/logout.do":
			new LogoutController().service(request, response);
			break;
		case "/getBoard.do":
			new GetBoardController().service(request, response);
			break;
		case "/addBoard.do":
			new AddBoardController().service(request, response);
			break;
		case "/addUser.do":
			new AddUserController().service(request, response);
			break;
		case "/listBoard.do":
			new BoardListController().service(request, response);
			break;	
		case "/deleteBoard.do":
			new DeleteBoardController().service(request, response);
			break;	
		case "/updateBoard.do":
			new UpdateBoardController().service(request, response);
			break;			
		default:
			response.sendRedirect("index.jsp");
			break;
		}
	}
}

















