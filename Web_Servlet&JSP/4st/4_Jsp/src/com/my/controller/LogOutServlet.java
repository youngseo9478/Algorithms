package com.my.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Cookie[] cookies= request.getCookies();
		if(cookies != null) {
			for(Cookie data :cookies) {
				if(data.getName().equals("userid")) {
					data.setMaxAge(0);
					response.addCookie(data);
					break;
				}
			}
		}
		System.out.println("logout.do  service 수행");
		ServletContext application = getServletContext();
		Integer count = (Integer)application.getAttribute("count");
		
		// 처리하세요..
		if(count != null) {
			application.setAttribute("count", count-1);
		}
		
		HttpSession session = request.getSession();
		//session.getAttribute("");
		//session.setAttribute("cart", "");
		//session.removeAttribute("");
		session.invalidate();
		//request.getRequestDispatcher("login.jsp").forward(request, response);
		response.sendRedirect("login.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
