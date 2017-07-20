package com.xiaoxiaomo.day30;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 滚动结果集
 * 
 * @author xiaoxiaomo
 *
 */
public class Test1 {
	public static void main(String[] args) throws Exception {
		// 装载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 建立连接
		Connection conn = DriverManager.getConnection("jdbc:mysql:///xxo",
				"root", "123");
		// 创建发送sql对象
		// Statement statm = conn.createStatement();
		Statement statm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		// 操作数据
		String sql = "select * from orders";
		ResultSet rs = statm.executeQuery(sql);

		// 直接指定某一行进行更新

		// 遍历结果集
		while (rs.next()) {
			rs.updateString(3, "1600");
			rs.updateRow();
			System.out.print(rs.getString(2));
			System.out.println(" | ");
			System.out.println(rs.getString(3));

		}

		// while(rs.previous()){
		// System.out.println("id=" + rs.getString(1) + " name="
		// + rs.getString(2) + " chinese="
		// + rs.getString("chinese") + " math="
		// + rs.getString("math") + " english="
		// + rs.getString("english"));
		// }
		// 关闭连接
		rs.close();
		statm.close();
		conn.close();

	}
}
