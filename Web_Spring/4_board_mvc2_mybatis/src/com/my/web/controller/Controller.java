package com.my.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모든 컨트롤러는 이 메소드를 구현해야하는 것
public interface Controller {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	// 부모에서는 throws 없는데 자식에서 있으면 오버라이딩이 아님!
	// 부모에게는 있는데 자식에게는 걸어도 안걸어도 상관없음.
}
