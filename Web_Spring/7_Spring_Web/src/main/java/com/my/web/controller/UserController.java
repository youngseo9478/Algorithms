package com.my.web.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.my.biz.user.service.UserService;
import com.my.biz.user.vo.UserCondition;
import com.my.biz.user.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@ModelAttribute("userCondition") //메모리에 올라가있으면 매번 호출될테니까 위치를 잘 잡아서 유용하게 써야 한다.
	public List<UserCondition> makeSearchCondition(){
		List<UserCondition> list = new ArrayList<UserCondition>();
		list.add(new UserCondition("id", "아이디"));
		list.add(new UserCondition("name", "이름"));
		list.add(new UserCondition("role", "권한"));
		System.out.println("userCondition : "+list);
		return list;
	}
	
	@RequestMapping("/listuser.do")
	public ModelAndView list() {
		// String s = null;
		// s.indexOf('a'); //에러발생시키기위함
		ModelAndView mav = new ModelAndView();
		//System.out.println(service.getUserList());
		//mav.addObject("list", service.getUserList());
		mav.addObject("users", service.getUserList());
		mav.setViewName("user/user_list");
		return mav;
	}
	@RequestMapping("/searchuser.do")
	public ModelAndView searchUser(@RequestParam("searchCondition")String condition, 
								   @RequestParam("searchKeyword")String keyword) {
		ModelAndView mav = new ModelAndView();
		//System.out.println(service.getUserList());
		//mav.addObject("list", service.getUserList());
		mav.addObject("users", service.searchUser(condition, keyword));
		mav.setViewName("user/user_list");
		return mav;
	}
	
	@RequestMapping(value="/adduser.do", method=RequestMethod.GET)	//get 방식일 때 동작
	//public ModelAndView addform() {
	public String addform() {	//String으로 view 이름만 return
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("user/user_write");
		//return mav;
		return "user/user_write"; //view이름으로 리턴됨 
	}
	
	@RequestMapping(value="/adduser.do", method=RequestMethod.POST)	//post 방식일 때 동작
	//public ModelAndView addproc(HttpServletRequest req) {
	//public ModelAndView addproc(UserVO vo) {// UserVO vo -> command 객체 (scope : request 영역)
											//컬럼명과 파라미터명이 일치할 때 가능
	public String addproc(UserVO vo) {	//String으로 view 이름만 return
		//insert 작업
		/*UserVO vo = new UserVO();
		vo.setName(req.getParameter("name"));
		vo.setId(req.getParameter("id"));
		vo.setPw(req.getParameter("pw"));
		vo.setRole(req.getParameter("role"));*/
		service.addUser(vo);
		
		//ModelAndView mav = new ModelAndView();
		
		//mav.setViewName("redirect:listuser.do");	
			//redirect: -> 다시 재요청. ViewResolver를 거치지 않는다. share 영역 발생X
		//return mav;
		return "redirect:listuser.do";
	}
	
	@RequestMapping(value="/userview.do", method=RequestMethod.GET)
	//public String userview (HttpServletRequest req) {
	//public String userview (String id, HttpServletRequest req) {
	//public String userview (@RequestParam("id") String uid, HttpServletRequest req) {
	public String userview (@RequestParam("id") String uid, Model model) {
		//UserVO user = service.getUser(req.getParameter("id"));
		//UserVO user = service.getUser(id);
		UserVO user = service.getUser(uid);
		//req.setAttribute("user", user);
		model.addAttribute("user", user);	//model -> request 와 같은 개념
		return "user/user_view";
	}
	
	//@RequestMapping(value="/removeuser.do", method=RequestMethod.POST)
										//removeuser.do 하나뿐이므로 method 없어도 괜찮음
	@RequestMapping(value="/removeuser.do")
	public String removeuser(String id) {
		service.removeUser(id);
		return "redirect:listuser.do";
	}
	@RequestMapping("/modifyuser.do")
	public String modifyuser(String id, HttpServletRequest req) {
		UserVO user = service.getUser(id);
		req.setAttribute("user", user);
		return "user/user_modify";
	}
	
	@RequestMapping("/updateuser.do")
	public String updateuser(UserVO vo) {
		service.updateUser(vo);
		System.out.println(vo);
		return "redirect:listuser.do";
	}
	
	//@ExceptionHandler(NullPointerException.class)
	public String ex(NullPointerException exception) { //예외핸들링할 메소드
		return "error/error";
	}
}
