package com.hand.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CheckServlet() {
		super();
	}
	public void init() throws ServletException {
		// Put your code here
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-----dopost--------");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//取得参数username的值
		String uname = request.getParameter("uname");
		String upsd = request.getParameter("upwd");
		System.out.println("账号："+uname+",密码："+upsd);
		
	}

	
	
}
