package com.my.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//annotation 기반에서는 인터페이스 필요X
@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		// String s = null;
		// s.indexOf('a'); //널포인터에러날것임
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Hello Spring MVC .. ");
		//request.setAttribute("msg", "Hello Spring MVC .. "); 와 같음
		mav.setViewName("hello");
		return mav;
	}
}
