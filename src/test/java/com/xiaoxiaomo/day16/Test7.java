package com.xiaoxiaomo.day16;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流复制一个文本文件(普通方法)
 * 
 * @author xiaoxiaomo
 *
 */
public class Test7 {
	public static void main(String[] args) {
		/*
		 * 有一个读取源和写入源将源文件中的内容读取出来创建一个新的文件将内容刷新到新的文件中
		 */
		// 有一个读取源和写入源
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("d:\\abc.txt");
			fw = new FileWriter("d:\\abc_copy.txt");

			// 不断读取并且写
			int ch = 0;
			while ((ch = fr.read()) != -1) {
				fw.write(ch);
			}
		} catch (Exception e) {
			throw new RuntimeException("复制失败");
		} finally {
			// 关闭流
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					System.out.println("关闭失败");;
				}
			}

			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					System.out.println("关闭失败");
				}
			}

		}

	}
}
