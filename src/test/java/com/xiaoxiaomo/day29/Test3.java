package com.xiaoxiaomo.day29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 批量插入
 * @author xiaoxiaomo
 *
 */
public class Test3 {
	public static void main(String[] args) throws Exception {
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql:///xxo?useUnicode=true&characterEncoding=UTF-8", "root", "123");
		//获取向数据库发送语句的对象
		Statement statm = conn.createStatement();
		//操作数据
		String sql1 = "insert into exam values(null,'张飞飞1',56,86,88)";
		String sql2 = "insert into exam values(null,'张飞飞2',56,86,88)";
		statm.addBatch(sql1);
		statm.addBatch(sql2);
		statm.executeBatch();
		
		//关闭连接
		statm.close();
		conn.close();
	}
}
