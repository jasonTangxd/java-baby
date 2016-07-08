package com.xxo.day30;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * DBUtils用法
 * @author xiaoxiaomo
 *
 */
public class DBUtilsTest {
	public static void main(String[] args) throws Exception {
		
		
//		dbutilstest1();
		
//		dbutilsTest2();
		
		//dbutils 插入 更新  删除
		dbutilsTest3();
	}

	private static void dbutilsTest3() throws Exception {
		//数据源
		ComboPooledDataSource cpds = new ComboPooledDataSource("xxo");
		//指定一个DBUtils核心类
		QueryRunner  query = new QueryRunner(cpds);
		
		//插入
//		int b = query.update("insert into account values(null,?,?)","wangwu",1000);
//		System.out.println(b);
		
		//更新
//		int c = query.update("update account set money=1000 where name=? " ,"zhangsan");
//		System.out.println(c);
		
		//删除
		int c = query.update("delete from account where name=? " ,"lisi");
		System.out.println(c);
		
		
		
	}

	private static void dbutilsTest2() throws SQLException {
		//数据源
		ComboPooledDataSource cpds = new ComboPooledDataSource("xxo");
		//指定一个DBUtils核心类
		QueryRunner  query = new QueryRunner(cpds);
		
		Account account = query.query("select * from account", new BeanHandler<Account>(Account.class));
		System.out.print(account.getId());
		System.out.print(" | ");
		System.out.print(account.getName());
		System.out.print(" | ");
		System.out.println(account.getMoney());
	}
	
	private static void dbutilstest1() throws Exception {
		//数据源
		ComboPooledDataSource cpds = new ComboPooledDataSource("xxo");
		//指定一个DBUtils核心类
		QueryRunner  query = new QueryRunner(cpds);
		
		List<Account> list = query.query("select * from account", new BeanListHandler<Account>(Account.class));
		
		for (Account account : list) {
			System.out.print(account.getId());
			System.out.print(" | ");
			System.out.print(account.getName());
			System.out.print(" | ");
			System.out.println(account.getMoney());
		}
	}
}
