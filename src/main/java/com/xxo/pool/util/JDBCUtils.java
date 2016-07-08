package com.xxo.pool.util;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * JDBC工具类
 * Created by xiaoxiaomo on 2012/4/26.
 *
 */
public class JDBCUtils {
	private static String driverClass = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;

	static {
		// 直接获取配置文件内容 getBundle对应配置文件properties的文件名
		driverClass = ResourceBundle.getBundle("db").getString("driverClass");
		url = ResourceBundle.getBundle("db").getString("url");
		username = ResourceBundle.getBundle("db").getString("username");
		password = ResourceBundle.getBundle("db").getString("password");
	}

	/*
	 * 获取连接
	 */
	public static Connection getConnection() {

		loadDriver();

		try {

			return DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	/*
	 * 加载驱动
	 */
	private static void loadDriver() {
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	//更新 
	public static void close(Connection conn, Statement statm) {
		// 关闭连接
		try {
			statm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//查询
	public static void close(Connection conn, Statement statm, ResultSet rs) {
		// 关闭连接
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
