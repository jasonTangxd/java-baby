package com.xiaoxiaomo.pool.c3p0;

import java.sql.*;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * c3p0连接池用法
 * Created by xiaoxiaomo on 2012/4/26.
 *
 */
public class C3P0Test {
	public static void main(String[] args) throws Exception {

//		ComboPooledDataSource cpds = new ComboPooledDataSource();
		ComboPooledDataSource cpds = new ComboPooledDataSource("momo");
		Connection conn = cpds.getConnection();
		Statement statm = conn.createStatement();
		ResultSet rs = statm.executeQuery("select * from sys_user");

		while(rs.next()){
			//处理rs......
		}
		rs.close();
		statm.close();
		conn.close();
	}

}
