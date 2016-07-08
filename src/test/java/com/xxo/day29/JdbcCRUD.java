package com.xxo.day29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * 综合练习 JDBC方式的CRUD
 * 
 * @author xiaoxiaomo
 *
 */
public class JdbcCRUD {
	public static void main(String[] args) {
		// 查询 R
		// query();

		// 插入 C
		// insert();

		// 更新 U
		// update();

		// 删除 D
		delete();
	}

	private static void delete() {
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
			String sql = "delete from exam where id = 15";

			int b = statm.executeUpdate(sql);

			// int i = 1/0; //手动制造错误

			if (b == 1) {
				System.out.println("删除成功");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("插入失败");
		} finally {
			// 关闭连接 释放资源
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
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

	private static void update() {
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
			String sql = "update exam set chinese= 70 where id = 16";

			int b = statm.executeUpdate(sql);

			// int i = 1/0; //手动制造错误

			if (b == 1) {
				System.out.println("更新成功");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("插入失败");
		} finally {
			// 关闭连接 释放资源
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
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

	private static void insert() {
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
			String sql = "insert into exam values(null,'张无忌',34,65,67)";
			int b = statm.executeUpdate(sql);

			// int i = 1/0; //手动制造错误

			if (b == 1) {
				System.out.println("插入成功");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("插入失败");
		} finally {
			// 关闭连接 释放资源
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
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

	private static void query() {
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
			// 查询
			while (rs.next()) {// 循环一次是一行数据
				System.out.println("id=" + rs.getString(1) + " name="
						+ rs.getString(2) + " chinese="
						+ rs.getString("chinese") + " math"
						+ rs.getString("math") + " english"
						+ rs.getString("english"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接 释放资源
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
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
