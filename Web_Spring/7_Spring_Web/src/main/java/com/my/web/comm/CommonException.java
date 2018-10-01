package com.my.web.comm;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.my.web.controller") // aop처럼 동작->포인트컷필요
public class CommonException {

	// 이게 부가기능에 해당하는 것 즉, point cut이 필요
	@ExceptionHandler(Exception.class)
	public ModelAndView ex(Exception exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.setViewName("error/error");
		return mav;
	}

}
