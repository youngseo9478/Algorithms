package com.my.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("*.do")
public class CharacterEncoding implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, 
			 ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		//System.out.println("CharacterEncoding filter 동작");
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
