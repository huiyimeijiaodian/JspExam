package com.hand.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.dao.ConnectionFactory;
import com.hand.dao.FilmDaoImp;
import com.hand.entity.Film;

public class DeleteServlet extends HttpServlet {

	public DeleteServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("------delete doget------");
		String film_id=request.getParameter("film_id");
		System.out.println("delete film_id:"+film_id);
		
		Film film=new Film();
		film.setFilm_id(Integer.parseInt(film_id));
		Connection conn=ConnectionFactory.getInstance().makeConnection();
		try {
			System.out.println("delete before");
			FilmDaoImp filmdao=new FilmDaoImp();
			filmdao.delete(conn, film);//删除一部电影
			System.out.println("delete success");
			
			request.setAttribute("msg", "delete success");
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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}

	

}
