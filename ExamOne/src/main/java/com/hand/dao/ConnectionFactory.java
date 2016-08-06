package com.hand.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 通用数据库连接工厂
 */
public class ConnectionFactory {
	
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	
	private Connection conn;
	
	static {
		Properties prop = new Properties();
		try {
			InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			prop.load(in);
		} catch (Exception e) {
			System.out.println("IO读取出错,找不到dbconfig.properties!");
		}

		driver = prop.getProperty("driver");
		dburl = prop.getProperty("dburl");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
		System.out.println(driver+","+dburl+","+user+","+password);
		
	}
	
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
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			//log.info("加载数据库驱动出现异常！");
			e.printStackTrace();
		}

		try {
		   conn=(Connection) DriverManager.getConnection(dburl, user, password);
		} catch (SQLException e) {
			//log.info("通过JDBC获取数据库连接发生异常！");
			e.printStackTrace();
		}
		return conn;
	}

}
