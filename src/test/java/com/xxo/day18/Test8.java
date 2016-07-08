package com.xxo.day18;

import java.io.File;

/**
 * 列出指定扩展名的文件
 * @author xiaoxiaomo
 *
 */
public class Test8 {
	public static void main(String[] args) {
	
		File file = new File("d:\\abc");
		File[] listFiles = file.listFiles();
		for (File f : listFiles) {
			System.out.println(f);
		}
			
	}
}
