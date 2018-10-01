package com.my.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, 
		               	 HttpServletResponse response) 
					throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println("login.do service() 영역");
		
		PrintWriter out = response.getWriter();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        if(id == null || pw ==null ||id.length()==0||pw.length()==0) {
        	response.sendRedirect("./login.html");//재요청
        	return;
        }
        boolean flag = true; //
        
        if(flag) {
        	Cookie cookie = new Cookie("userid", id);
        	response.addCookie(cookie);
        	
        	ServletContext application = getServletContext();
        	
        	Integer count = 
        			(Integer)application.getAttribute("count");
        	
        	if(count == null) {
        		application.setAttribute("count", 1);
        	}else {
        		application.setAttribute("count", count+1);
        	}
        	
        	HttpSession session = request.getSession();
        	session.setAttribute("login", id);
        	
        	String view ="main.jsp";
        	request.getRequestDispatcher(view).forward(request, response);
        	return;
        }else {
        	request.setAttribute("errorMsg", "id 와 password 확인 해 주세요");
        	out.print("<h1> 로그인 실패 </h1>");
        	out.println("<a href='./login.html'>로그인창</a>");
        }
	}
	
	public void doGet(HttpServletRequest request, 
          	 HttpServletResponse response) 
		throws ServletException, IOException {
		 
		doPost(request, response);
	}
}








