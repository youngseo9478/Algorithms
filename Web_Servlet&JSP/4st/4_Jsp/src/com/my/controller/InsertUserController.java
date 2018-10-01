package com.my.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.model.UserInfo;

public class InsertUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        
	    UserInfo model = new UserInfo(id, name, pw, role);
	    //서비스만 있다면 이용하여 DB에 인서트가능
	    System.out.println("DB add : "+model);
	    request.setAttribute("data", model);
	    String view = "result.jsp";
	    //controller 흐름제어 뷰페이지에서 사용할 데이터 구축 도 필요
	    RequestDispatcher rd = request.getRequestDispatcher(view);
	    rd.forward(request, response);
	   
	    //request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}





