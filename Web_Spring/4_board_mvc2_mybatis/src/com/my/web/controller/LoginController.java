package com.my.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.my.biz.user.dao.UserDAO;
import com.my.biz.user.dao.UserDAO_JDBC;
import com.my.biz.user.dao.UserDAO_MyBatis;
import com.my.biz.user.service.UserService;
import com.my.biz.user.service.UserServiceImpl;
import com.my.biz.user.vo.UserVO;

//@WebServlet(urlPatterns= { "/login.do","/login"})
public class LoginController implements Controller {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest request, 
			               HttpServletResponse response) 
					throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
//        UserDAO dao = new UserDAO_JDBC();
        UserDAO dao = new UserDAO_MyBatis();
		UserService service = new UserServiceImpl(dao);
		
		UserVO user =  service.login(id, pw);
		
		if(user != null) {
			//로그인 성공
			HttpSession session = request.getSession();
			user.setPw(null);
			Logger logger = LoggerFactory.getLogger("my");
			logger.info("login  /  "+id);
			session.setAttribute("login", user);
			response.sendRedirect("listBoard.do");
		}else {
			//로그인 실패
			//response.sendRedirect("login.html");
			response.sendRedirect("index.jsp?content=login.html");
			
		}
		
	}
}





