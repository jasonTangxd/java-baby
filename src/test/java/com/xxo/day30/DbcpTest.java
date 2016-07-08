package com.xxo.day30;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * 数据库连接池dbcp
 * @author xiaoxiaomo
 *
 */
public class DbcpTest {
	public static void main(String[] args) throws Exception {
		//dbcp用法一
//		datasource1();
		
		//用法二
		datasource2();
		
	}

	private static void datasource2() throws Exception {
		//数据源工厂创建数据库连接池
		BasicDataSourceFactory factory = new BasicDataSourceFactory();
		//创建配置文件对象
		Properties prop = new Properties();
		InputStream in = DbcpTest.class.getResourceAsStream("/dbcp.properties");
		//加载配置文件流
		prop.load(in);
		//加载配置文件 生成对应数据源
		DataSource ds = factory.createDataSource(prop);
		Connection conn = ds.getConnection();
		Statement statm = conn.createStatement();
		ResultSet rs = statm.executeQuery("select * from student");
		
		while(rs.next()){
			System.out.print(rs.getString(1));
			System.out.print(" | ");
			System.out.print(rs.getString(2));
			System.out.print(" | ");
			System.out.print(rs.getString(3));
			System.out.print(" | ");
			System.out.print(rs.getString(4));
			System.out.println(" | ");
			
		}
		
		rs.close();
		statm.close();
		conn.close();//不是真正的关闭连接   而是将连接返回连接池
		
	}

	
	
	
	
	
	
	private static void datasource1() throws SQLException {
		//指定数据源
		BasicDataSource bds = new BasicDataSource();   //15
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql:///xxo");
		bds.setUsername("root");
		bds.setPassword("123");
		
		Connection conn = bds.getConnection();
		Statement statm = conn.createStatement();
		ResultSet rs = statm.executeQuery("select * from student");
		
		while(rs.next()){
			System.out.print(rs.getString(1));
			System.out.print(" | ");
			System.out.print(rs.getString(2));
			System.out.print(" | ");
			System.out.print(rs.getString(3));
			System.out.print(" | ");
			System.out.print(rs.getString(4));
			System.out.println(" | ");
			
		}
		
		bds.close();
		statm.close();
		conn.close();//不是真正的关闭连接   而是将连接返回连接池
	}
}
