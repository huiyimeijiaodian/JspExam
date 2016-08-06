package com.hand.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 通用数据库连接工厂
 */
public class ConnectionFactory {
	private Connection conn;
	
	/**
	 * 单例模式-饿汉式
	 */
	private static final ConnectionFactory factory = new ConnectionFactory();
	private ConnectionFactory() {
	}
	public static ConnectionFactory getInstance() {
		return factory;
	}

	/**
	 * 数据库链接工厂
	 *
	 * @return 返回一个数据库链接
	 */
	public Connection makeConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			//log.info("加载数据库驱动出现异常！");
			e.printStackTrace();
		}

		try {
		   conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","123456");
		} catch (SQLException e) {
			//log.info("通过JDBC获取数据库连接发生异常！");
			e.printStackTrace();
		}
		return conn;
	}

}
