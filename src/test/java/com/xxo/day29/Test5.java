package com.xxo.day29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 异常处理 和 资源释放
 * 
 * @author xiaoxiaomo
 *
 */
public class Test5 {
	public static void main(String[] args) {
		// 创建连接
		Connection conn = null;
		Statement statm = null;
		ResultSet rs = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection(
							"jdbc:mysql:///xxo?useUnicode=true&characterEncoding=UTF-8",
							"root", "123");
			// 获取向数据库发送语句的对象
			statm = conn.createStatement();
			// 操作数据
			String sql = "select * from exam";
			rs = statm.executeQuery(sql);
			// 遍历结果集
			while (rs.next()) {// 循环一次是一行数据
				// String s = rs.getString(3); //get的是字段 第一个字段从1开始
				// String s = rs.getString("name"); //get时可以指定字段名称
				// String s = rs.getString("chinese"); //可以获取非字符类型的数据
				// double s = rs.getDouble("chinese"); //get时可以指定字段名称
				// System.out.println(Double.parseDouble(s));
				System.out.println("id=" + rs.getString(1) + " name="
						+ rs.getString(2) + " chinese="
						+ rs.getString("chinese") + " math"
						+ rs.getString("math") + " english"
						+ rs.getString("english"));

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭连接 释放资源
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (statm != null)
					statm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
