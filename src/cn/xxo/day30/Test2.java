package cn.xxo.day30;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uitls.JDBCUtils;

/**
 * 提取工具类
 * 
 * @author gs
 *
 */
public class Test2 {
	public static void main(String[] args){
		Connection conn = null;
		Statement statm = null;
		ResultSet rs = null;
		try {
			//获取连接
			conn = JDBCUtils.getConnection();
			// 创建发送sql对象
			statm = conn.createStatement();
			// 操作数据
			String sql = "select * from orders";
			rs = statm.executeQuery(sql);
			// 直接指定某一行进行更新
			
			// 遍历结果集
			while (rs.next()) {
				System.out.print(rs.getString(1));
				System.out.print(" | ");
				System.out.print(rs.getString(2));
				System.out.print(" | ");
				System.out.println(rs.getString(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, statm, rs);
		}
	}
}
