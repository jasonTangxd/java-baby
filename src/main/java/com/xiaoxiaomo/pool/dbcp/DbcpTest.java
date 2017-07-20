package com.xiaoxiaomo.pool.dbcp;

import java.sql.*;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * 数据库连接池dbcp
 * Created by xiaoxiaomo on 2012/4/26.
 */
public class DbcpTest {
	public static void main(String[] args) throws Exception {
		//1. 数据源工厂创建数据库连接池
		//BasicDataSource bds = new BasicDataSource();//可以不使用配置
		BasicDataSourceFactory factory = new BasicDataSourceFactory();

		//2. 创建配置文件对象
		Properties prop = new Properties();
		//加载配置文件流
		prop.load( DbcpTest.class.getResourceAsStream("/dbcp.properties") );

		//3. 加载配置文件 生成对应数据源
		DataSource ds = factory.createDataSource(prop);
		Connection conn = ds.getConnection();
		Statement statm = conn.createStatement();
		ResultSet rs = statm.executeQuery("select * from student");

		while(rs.next()){
			//处理rs.....
		}
		
		rs.close();
		statm.close();
		//不是真正的关闭连接,而是将连接返回连接池
		conn.close();
	}
}
