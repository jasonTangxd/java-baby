package cn.xxo.day29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 字符集指定
 * @author gs
 *
 */
public class Test1 {
	public static void main(String[] args) throws Exception {
		//注册驱动
//		DriverManager.registerDriver(new Driver());//该方式不推荐
		Class.forName("com.mysql.jdbc.Driver");//推荐该方式
		//获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crxy?useUnicode=true&characterEncoding=UTF-8", "root", "123");
		//创建与数据库通信的对象
		String sql = "insert into test3 values(null,'犀利哥')";
		Statement statm = conn.createStatement();
		//操作数据
		System.out.println(sql);
		int b = statm.executeUpdate(sql);
		System.out.println(b);
		
		//关闭连接
		statm.close();
		conn.close();
	}
}
