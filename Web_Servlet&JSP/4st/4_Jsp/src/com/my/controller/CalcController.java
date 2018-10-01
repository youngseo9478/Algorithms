package com.my.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("calc.do  doGet service 영역");
		
		String number = request.getParameter("number");
		if(number == null || number.isEmpty()) {
			request.setAttribute("errorMsg", "값입력해 주세요");
			//response.sendRedirect("input.jsp");
			request.getRequestDispatcher("input.jsp")
			.forward(request, response);

			return;
		}
		int num = Integer.parseInt(number);
		String view ="calcview.jsp";
		
		ArrayList<String> list = new ArrayList<String>();
		for(int i=1;i<=9;i++) {
			list.add(num+" * "+i+" = "+(num*i));
		}
		
		request.setAttribute("data", list);
		request.getRequestDispatcher(view).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
