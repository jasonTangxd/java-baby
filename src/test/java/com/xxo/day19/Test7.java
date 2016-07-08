package com.xxo.day19;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * Properties配置存储为文件
 * @author xiaoxiaomo
 *
 */
public class Test7 {
	public static void main(String[] args) throws IOException{
		Properties prop = new Properties();
		prop.setProperty("zhangsan", "15000");
		prop.setProperty("lisi", "8000");
		prop.setProperty("wangwu", "20000");
		
		
//		prop.list(System.out);//测试用
		prop.store(new FileOutputStream("a.properties"), "peizhi");
		
		prop.setProperty("wangwu", "10000");
		System.out.println(prop.getProperty("wangwu"));
		
	}
}
