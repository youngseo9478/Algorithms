package com.my.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.biz.user.dao.UserDAO;
import com.my.biz.user.dao.UserDAO_JDBC;
import com.my.biz.user.service.UserService;
import com.my.biz.user.service.UserServiceImpl;
import com.my.biz.user.vo.UserVO;

public class AddUserController implements Controller {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest request, 
			               HttpServletResponse response) 
					throws ServletException, IOException {
		
		UserDAO dao = new UserDAO_JDBC();
		//UserService service = new UserServiceImpl(dao);
		UserService service = new UserServiceImpl();
		((UserServiceImpl)service).setDao(dao);
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String role = request.getParameter("role");
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setName(name);
		vo.setPw(pw);
		vo.setRole(role);
		
		service.addUser(vo);
		
		response.sendRedirect("index.jsp?content=login.html");
	}
}







