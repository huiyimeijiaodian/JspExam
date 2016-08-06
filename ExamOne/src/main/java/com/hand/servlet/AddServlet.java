package com.hand.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.dao.ConnectionFactory;
import com.hand.dao.FilmDao;
import com.hand.dao.FilmDaoImp;
import com.hand.entity.Film;

public class AddServlet extends HttpServlet {
	public AddServlet() {
		super();
	}
	
	public void init() throws ServletException {
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("------addFilm dopost--------");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String language = request.getParameter("language");
		int language_id=1;
		System.out.println("language:"+language);
		Film film=new Film();
		Connection conn=ConnectionFactory.getInstance().makeConnection();
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("SELECT language_id FROM language where name=?");
			ps.setString(1, language);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				language_id=rs.getInt(1);
				film.setTitle(title);
				film.setDescription(description);
				film.setLanguage_id(language_id);
			}
		} catch (SQLException e1) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			e1.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		Connection conn1=ConnectionFactory.getInstance().makeConnection();
		try {
			System.out.println("add before");
			FilmDaoImp filmdao=new FilmDaoImp();
			filmdao.addFilm(conn1, film);//添加一部电影
			System.out.println("add success");
			
			request.setAttribute("msg", "add success!");
			RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
			rd.forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
 		
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
}
