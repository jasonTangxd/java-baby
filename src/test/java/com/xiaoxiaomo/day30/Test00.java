package com.xiaoxiaomo.day30;

/**
 * 课堂测试
 * @author xiaoxiaomo
 *
 */
public class Test00 {
	public static void main(String[] args) {
		/*
		 * driverclass:com.mysql.jdbc.Driver
		 * url:jdbc:mysql:///xxo
		 * username:root
		 * password:123
		 */
		
		//使用jdbc向exam表中添加一条记录  所有列不为空(Statement对象)
		Test1();
		
		//使用jdbc将exam表中的英语成绩为90分的同学删除(使用PreparedStatement防止sql注入)
		Test2();
		
		//使用c3p0连接池实现
		Test3();
		
	}

	private static void Test3() {
		
	}

	private static void Test2() {
		
	}

	private static void Test1() {
		
	}
}
