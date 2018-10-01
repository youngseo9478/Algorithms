package com.my.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.web.controller.AddBoardController;
import com.my.web.controller.AddUserController;
import com.my.web.controller.BoardListController;
import com.my.web.controller.Controller;
import com.my.web.controller.DeleteBoardController;
import com.my.web.controller.GetBoardController;
import com.my.web.controller.JSONBoardListController;
import com.my.web.controller.LoginController;
import com.my.web.controller.LogoutController;
import com.my.web.controller.SearchBoardController;
import com.my.web.controller.UpdateBoardController;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//모든 서블릿은 컨트롤러인데 여러개의 컨트롤러를 부모인 Controller로 핸들링하는 것! 
	//원래는 모두 다른 타입으로 공통이 Object인데 Object타입은 사용불가,,,
	Map<String, Controller> handlerMapping = new HashMap<String,Controller>(); 
	
	//공유가 필요한 자원 ->웹어플리케이션의 전체적인 흐름을 가지고 있음 
	public void init(ServletConfig config) throws ServletException {
		handlerMapping.put("/login.do", new LoginController());
		handlerMapping.put("/logout.do", new LogoutController());
		handlerMapping.put("/addBoard.do", new AddBoardController());
		handlerMapping.put("/listBoard.do", new BoardListController());
		handlerMapping.put("/deleteBoard.do", new DeleteBoardController());
		handlerMapping.put("/getBoard.do", new GetBoardController());
		handlerMapping.put("/searchBoard.do", new SearchBoardController());
		handlerMapping.put("/updateBoard.do", new UpdateBoardController());
		handlerMapping.put("/addUser.do", new AddUserController());
		handlerMapping.put("/json.do", new JSONBoardListController());
	}
	

	public void destroy() {
	}

	protected void service(HttpServletRequest request, 
			               HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		//여기서 구분을 /로 했기때문에 위에 맵핑할때도 /를 붙여줘야하는 것
		System.out.println("path "+path);
		handlerMapping.get(path).service(request, response);
	}
}

















