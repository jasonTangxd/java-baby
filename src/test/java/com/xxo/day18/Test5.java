package com.xxo.day18;

import java.io.File;
import java.io.IOException;

/**
 * 文件的判断功能实现
 * @author xiaoxiaomo
 *
 */
public class Test5 {
	public static void main(String[] args) throws IOException {
		File file = new File("D:\\ab");
		
//		file.createNewFile();
		file.mkdirs();
/*		boolean b = file.isFile();
		boolean b1 = file.isDirectory();
		boolean exists = file.exists();
		System.out.println(exists);*/
	}
}
