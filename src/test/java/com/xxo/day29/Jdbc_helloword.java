package com.xxo.day29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * 第一个jdbc程序
 * @author xiaoxiaomo
 *
 */
public class Jdbc_helloword {
	public static void main(String[] args) throws Exception {
		//注册驱动
//		DriverManager.registerDriver(new Driver());//该方式不推荐
		Class.forName("com.mysql.jdbc.Driver");//推荐该方式
		//获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xxo", "root", "123");
		//创建与数据库通信的对象
		String sql = "select * from student";
		Statement statm = conn.createStatement();
		//操作数据
		ResultSet rs = statm.executeQuery(sql);
		
		//遍历结果集
		while(rs.next()){
			System.out.print(rs.getString(1));
			System.out.print("|"+rs.getString(2));
			System.out.print("|"+rs.getString(3));
			System.out.println("===");
		}
		
		//关闭连接
		rs.close();
		statm.close();
		conn.close();
	}
}
