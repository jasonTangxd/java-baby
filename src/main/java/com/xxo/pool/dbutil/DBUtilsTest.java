package com.xxo.pool.dbutil;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xxo.pool.bean.SysUser;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * DBUtils用法
 * Created by xiaoxiaomo on 2012/4/26.
 *
 */
public class DBUtilsTest {
	public static void main(String[] args) throws Exception {

		//数据源
		ComboPooledDataSource cpds = new ComboPooledDataSource("momo");
		//指定一个DBUtils核心类
		QueryRunner query = new QueryRunner(cpds);

		SysUser account = query.query(
				"select * from sys_user",
				new BeanHandler<SysUser>(SysUser.class));
		System.out.print(account.toString());

		cpds.close();
	}

}
