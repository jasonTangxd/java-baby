package com.xiaoxiaomo.day16;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 利用高效写入类 写入对应的数据
 * @author xiaoxiaomo
 *
 */
public class Test9 {
	private static String LINESEPARATOR = System.getProperty("line.separator");

	public static void main(String[] args) throws IOException {
		//写入源
		FileWriter fw = new FileWriter("file/abc.txt");
		BufferedWriter bfr = new BufferedWriter(fw);
		
		//开始写
//		bfr.write("ab\r\nrcd");
		bfr.write("ab"+LINESEPARATOR +"superman");
//		bfr.newLine();
//		bfr.write("1234");
//		bfr.flush();
		
		//关闭流
		bfr.close();
		
	}
}
