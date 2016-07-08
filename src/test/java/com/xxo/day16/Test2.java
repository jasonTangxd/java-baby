package com.xxo.day16;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 换行
 * @author xiaoxiaomo
 *
 */
public class Test2 {
	//系统换行符
	private static String LINESEPARATOR = System.getProperty("line.separator");

	public static void main(String[] args) throws IOException {
		//指定对应的文件目标
		FileWriter fw = new FileWriter("abc.txt");
		
		//写入相应的数据
		fw.write("abcde"+LINESEPARATOR +"superman");
		
		//关闭流
		fw.close();
		
	}
}
