package com.my.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

//언제 동작할지는 빈설정파일에서 관리
public class AuthenticInterceptor extends HandlerInterceptorAdapter {// spring에있는 클래스 상속

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception { // pre는 나올때 post는 나올때
		// WebUtils //이걸이용해서도 세션정보 가져올 수 있음
		// WebUtils.getSessionAttribute(request, "login");
		HttpSession session = request.getSession();
		if (session.getAttribute("login") != null) {
			return true; // 로그인되어있는 상태면 그냥 가던 길 가도록..
		} else {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:login.html");
			throw new ModelAndViewDefiningException(mav);
		}
	}
}
