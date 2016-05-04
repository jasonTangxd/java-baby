package cn.xxo.day30;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * jdbc封装结果集
 * @author gs
 *
 */
public class Test4 {
	public static void main(String[] args) throws Exception {
		//用法二	
		datasource2();
		
	}

	private static void datasource2() throws SQLException {
		//指定数据源
		BasicDataSource bds = new BasicDataSource();   //15
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql:///crxy");
		bds.setUsername("root");
		bds.setPassword("123");
		
		Connection conn = bds.getConnection();
		Statement statm = conn.createStatement();
		ResultSet rs = statm.executeQuery("select * from account");
		
		ArrayList<Account> arrayList = new ArrayList<Account>();
		
		while(rs.next()){
			Account account = new Account();
			account.setId(rs.getInt(1));
			account.setName(rs.getString(2));
			account.setMoney(rs.getDouble(3));
			arrayList.add(account);
		}
		
		for (Account account : arrayList) {
			System.out.print(account.getId());
			System.out.print(" | ");
			System.out.print(account.getName());
			System.out.print(" | ");
			System.out.println(account.getMoney());
			
		}
		
		bds.close();
		statm.close();
		conn.close();//不是真正的关闭连接   而是将连接返回连接池
	}
}
