package com.xxo.day18;

import java.io.File;
import java.io.IOException;

/**
 * 编写程序实现创建并删除文件夹或者一个文件
 * @author xiaoxiaomo
 *
 */
public class Test4 {
	public static void main(String[] args) throws IOException {
		File file = new File("D:\\bbb.txt");
		
		//文件创建
		//创建一个新的文件  如果文件存在  不创建
		boolean b = file.createNewFile();
		file.deleteOnExit();
//		boolean b = file.mkdir();
//		boolean b = file.mkdirs(); 
		
//		boolean b = file.delete();
		
		System.out.println(b);
		
		
	}
}
