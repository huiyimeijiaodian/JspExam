package com.hand.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PermissionFilter implements Filter {

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		// 将ServletRequest转换为HttpServletRequest      
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String servletPath = request.getServletPath();
		System.out.println("Servlet Path ==> " + servletPath);
		// 获取HttpSession中的信息   
		HttpSession session = request.getSession();
		String sign = (String) session.getAttribute("sign");
		System.out.println("sign:"+sign);
		if(sign==null || "".equals(sign)){
			response.sendRedirect("/login.jsp");
			System.out.println("为空null!!!");
		}else{
			chain.doFilter(servletRequest, servletResponse);
		}
		
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}
