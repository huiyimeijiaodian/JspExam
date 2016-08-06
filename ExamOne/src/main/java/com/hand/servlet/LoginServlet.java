package com.hand.servlet;

import java.io.IOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.dao.ConnectionFactory;
import com.mysql.jdbc.Connection;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
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
		System.out.println("-----loginServlet dopost--------");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//取得参数username的值
		String uname = request.getParameter("uname");
//		String upsd = request.getParameter("upwd");
		System.out.println("name:"+uname);
		
		RequestDispatcher rd = null;
		String forward = null;
		boolean flag=false;
		if (uname == null) {
			request.setAttribute("msg", "用户名为空");
			rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		} else {
			try {
				Connection conn = (Connection) ConnectionFactory.getInstance().makeConnection();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer WHERE first_name = ?");
				ps.setString(1, uname);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					flag=true;
				}
				rs.close();
				conn.close();
			}  catch (SQLException e) {
				e.printStackTrace();
			}
			if (flag) {
				forward = "/success.jsp";
			} else {
				forward = "/error.jsp";
			}

			rd = request.getRequestDispatcher(forward);
			rd.forward(request, response);
			
		}
		
	}

	
	
}
