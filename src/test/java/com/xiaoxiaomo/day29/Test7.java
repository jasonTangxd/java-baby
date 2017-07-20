package com.xiaoxiaomo.day29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * PreparedStatement对象2
 * 
 * @author xiaoxiaomo
 *
 */
public class Test7 {
	public static void main(String[] args) throws Exception {
		// statmtest();

		pstatmtest();
	}

	private static void statmtest() throws Exception {
		// String username = "张三' or '1'= '1";
		String username = "张三' -- ";
		String password = "123123123123";

		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 创建连接
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql:///xxo?useUnicode=true&characterEncoding=UTF-8",
				"root", "123");

		// 获取向数据库发送语句的对象
		// PreparedStatement pstatm = conn.prepareStatement(sql);
		// //发送一个预编译好的sql给数据库
		// pstatm.setString(1, "90");
		// ResultSet rs = pstatm.executeQuery();
		// 操作数据
		
		String sql = "select * from user where username = '" + username
				+ "' and password = '" + password + "' ";
		System.out.println("sql = " + sql);
		Statement statm = conn.createStatement();
		ResultSet rs = statm.executeQuery(sql);
		rs.next();
		
		if (rs.getString("username").equals("张三")
				&& rs.getString("password").equals("123")) {
			System.out.println("登录成功");
		} else {
			System.out.println("登录失败");
		}

		// 关闭资源
		rs.close();
		statm.close();
		conn.close();
	}

	private static void pstatmtest() throws ClassNotFoundException, SQLException {
		 String username = "张三' or '1'= '1";
//		String username = "张三";
		String password = "1231";

		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 创建连接
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql:///xxo?useUnicode=true&characterEncoding=UTF-8",
				"root", "123");

		// 获取向数据库发送语句的对象
		// 操作数据
		String sql = "select * from user where username = ? and password = ? ";
		PreparedStatement pstatm = conn.prepareStatement(sql);
		// 发送一个预编译好的sql给数据库
		pstatm.setString(1, username);
		pstatm.setString(2, password);
		System.out.println(sql);
		ResultSet rs = pstatm.executeQuery();

		rs.next();
		
		if (rs.getString("username").equals("张三")
				&& rs.getString("password").equals("123")) {
			System.out.println("登录成功");
		} else {
			System.out.println("登录失败");
		}

		// 关闭资源
		rs.close();
		pstatm.close();
		conn.close();
	}
}
