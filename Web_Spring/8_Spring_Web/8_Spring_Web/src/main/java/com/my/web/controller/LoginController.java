package com.my.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.biz.user.service.UserService;
import com.my.biz.user.vo.UserVO;

@Controller
public class LoginController {
	
	@Autowired //주입완료
	UserService service; 
	
	@RequestMapping("/loginForm.do")
	public String loginForm() {
		
		return "redirect:login.html";
	}
	
	@RequestMapping("/login.do")
	public String loginProcess(UserVO vo, HttpServletRequest req,HttpSession session) { //session이나 request 둘 중 아무거나 써도 됨
		UserVO user = service.login(vo.getId(), vo.getPw());
		if(user!=null) {
			req.getSession().setAttribute("login", user);
			return "redirect:index.html";
		}else {
			return "redirect:login.html";
		}
	}

	@RequestMapping("/logout.do")
	public String logoutProcess(HttpSession session) { //session이나 request 둘 중 아무거나 써도 됨
		session.invalidate(); //session파괴하고 리턴해줌
		return "redirect:index.html";
	}
}
