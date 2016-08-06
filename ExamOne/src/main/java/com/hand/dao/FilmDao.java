package com.hand.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.hand.entity.Film;



public interface FilmDao {
	public void addFilm(Connection conn, Film film) throws SQLException;

	//public void update(Connection conn, Long id, Film film) throws SQLException;

	public void delete(Connection conn, Film film) throws SQLException;
}
