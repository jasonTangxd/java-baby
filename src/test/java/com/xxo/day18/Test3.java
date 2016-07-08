package com.xxo.day18;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * 打印一个文件的所有属性
 * 
 * @author xiaoxiaomo
 *
 */
public class Test3 {
	public static void main(String[] args) throws IOException {

		File file = new File("d:\\cd.txt");

		System.out.println("getAbsolutePath = " + file.getAbsolutePath());  //绝对路径
		System.out.println("getName=" + file.getName());  //文件名
		System.out.println("getCanonicalPath=" + file.getCanonicalPath());  //绝对路径的规范形式 
		System.out.println("getPath=" + file.getPath()); //定义文件路径时  内容是什么就打印什么
		System.out.println("length=" + file.length()); //文件大小
		System.out.println("lastModified=" + file.lastModified()); //最后修改时间
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long t = file.lastModified();
		String time = sdf.format(t);
		System.out.println(time);
	}
}

