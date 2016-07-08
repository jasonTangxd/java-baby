package com.xxo.day18;

import java.io.File;

/**
 * 找出指定文件夹下的隐藏文件   和 指定文件扩展名文件
 * @author xiaoxiaomo
 *
 */
public class Test10 {
	public static void main(String[] args) {
		File file = new File("F:\\电影");
		File[] listFiles = file.listFiles(new MyFileFilter(".mkv"));
		for (File f : listFiles) {
			System.out.println(f);
		}
	}
}
