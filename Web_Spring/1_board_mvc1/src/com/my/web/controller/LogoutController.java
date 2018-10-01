package com.my.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.my.biz.user.vo.UserVO;

public class LogoutController implements Controller {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		  HttpSession session = request.getSession();
		  UserVO data = (UserVO)session.getAttribute("login");

		  Logger logger = LoggerFactory.getLogger("my");
		  logger.info("logout  /  "+data.getId());
		  
		  session.removeAttribute("login");
		  session.invalidate();
		  //response.sendRedirect("login.html");
		  response.sendRedirect("index.jsp?content=login.html");
	}

}






