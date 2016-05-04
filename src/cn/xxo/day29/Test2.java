package cn.xxo.day29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * statement对象
 * @author gs
 *
 */
public class Test2 {
	public static void main(String[] args) throws Exception {
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//创建连接
		Connection conn = DriverManager.getConnection("jdbc:mysql:///crxy?useUnicode=true&characterEncoding=UTF-8", "root", "123");
		//获取向数据库发送语句的对象
		Statement statm = conn.createStatement();
		//操作数据
//		String sql = "insert into exam values(12,'张飞飞',56,86,88)";
		String sql = "update  exam set chinese=68 where name='张飞飞'";
		boolean b = statm.execute(sql);
		System.out.println(b);
		//关闭连接
		statm.close();
		conn.close();
	}
}
