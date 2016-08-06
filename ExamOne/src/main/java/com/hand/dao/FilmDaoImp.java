package com.hand.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hand.entity.Film;

public class FilmDaoImp implements FilmDao {
	
	//film 的数据库添加函数	
	public void addFilm(Connection conn, Film film) throws SQLException {
		String addSql="insert into film (title,description,language_id) values(?,?,?);";
		PreparedStatement ps = conn.prepareStatement(addSql);
		ps.setString(1, film.getTitle());
		ps.setString(2, film.getDescription());
		ps.setInt(3, film.getLanguage_id());
		ps.execute();
	}
   
	//film 的数据库删除函数	
	public void delete(Connection conn, Film film) throws SQLException {
		String deleteSql="delete from film where film_id=?";
		PreparedStatement ps = conn.prepareStatement(deleteSql);
		ps.setInt(1, film.getFilm_id());
		ps.execute();
	}

}
