package com.xiaoxiaomo.day17;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 向磁盘上写入一个文件
 * @author xiaoxiaomo
 *
 */
public class Test13 {
	public static void main(String[] args) throws IOException {
		//指定一个写入源
		 FileOutputStream fos = new FileOutputStream("d:\\b.txt");
		 //使用转换流将数据写入到文件中
		 OutputStreamWriter osw = new OutputStreamWriter(fos);
		 
		 osw.write("你好");
		 
		 osw.close();
	}
}
