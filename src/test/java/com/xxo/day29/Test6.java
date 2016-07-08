package com.xxo.day29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * PreparedStatement对象
 * 
 * @author xiaoxiaomo
 *
 */
public class Test6 {
	public static void main(String[] args) throws Exception {
		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 创建连接
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql:///xxo?useUnicode=true&characterEncoding=UTF-8",
				"root", "123");
		
		
		String sql = "select * from exam where english = ? ";
		// 获取向数据库发送语句的对象
		PreparedStatement pstatm = conn.prepareStatement(sql);  //发送一个预编译好的sql给数据库
		
		pstatm.setString(1, "90");
		// 操作数据
		ResultSet rs = pstatm.executeQuery();
	
		// 遍历结果集
		while (rs.next()) {// 循环一次是一行数据
			// String s = rs.getString(3); //get的是字段 第一个字段从1开始
			// String s = rs.getString("name"); //get时可以指定字段名称
			// String s = rs.getString("chinese"); //可以获取非字符类型的数据
			// double s = rs.getDouble("chinese"); //get时可以指定字段名称
			// System.out.println(Double.parseDouble(s));
			System.out.println("id=" + rs.getString(1) + " name="
					+ rs.getString(2) + " chinese=" + rs.getString("chinese")
					+ " math=" + rs.getString("math") + " english="
					+ rs.getString("english"));
		}
	}
}
