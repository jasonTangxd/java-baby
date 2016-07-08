package com.xxo.day18;

import java.io.File;

/**
 * File类的用法
 * @author xiaoxiaomo
 *
 */
public class Test2 {
	public static void main(String[] args) {
		//实例化对象时，文件不会产生
		//File(String pathname) 
//		File file = new File("d:\\abc.txt"); 
//		File file = new File("d:\\");
		
		//同一个分区的多个文件操作   多个分区的同一个文件
//		File(String parent, String child) 
//		File file = new File("d:\\","abc.txt");
		
		//File(File parent, String child) 
//		File path = new File("d:\\");
//		File file = new File(path,"abc.txt");
		
		
		System.out.println(File.separator); //   System.getProperty("file.separator")
		System.out.println(File.separatorChar); //   System.getProperty("file.separator")
//		System.out.println(System.getProperty("file.separator"));
		
		System.out.println(File.pathSeparator); // 
		
		
		
	}
}
