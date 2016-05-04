package cn.xxo.day18;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * Properties
 * @author gs
 *
 */

public class Test13 {
	public static void main(String[] args) throws IOException {
		//获取系统配置信息
//		Properties properties = System.getProperties();
//		System.out.println(properties.toString());
		
		//将配置信息打印到控制台
		//list方法经常用来调试，当前配置中的所有配置
//		properties.list(System.out);
		
		//设置配置信息
//		Properties prop = new Properties();
//		prop.setProperty("zhangsan", "15000");
//		prop.setProperty("lisi", "18000");
//		prop.setProperty("wangwu", "8000");
//		prop.list(System.out);
//		String s = prop.getProperty("lisi");
//		System.out.println(s);
		
		//获取全部配置信息
//		Set<String> props = prop.stringPropertyNames();
//		for (String key : props) {
//			System.out.println(key + " -> " + prop.getProperty(key));
//		}
		
		//读取配置文件中的配置信息
		Properties prop = new Properties();
		FileInputStream is =new FileInputStream("salary.properties");
		prop.load(is);
		String s = prop.getProperty("zhangsan");
		System.out.println(s);
//		prop.list(System.out);
		
	}
}
