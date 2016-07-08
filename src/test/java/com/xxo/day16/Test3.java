package com.xxo.day16;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 续写
 * @author xiaoxiaomo
 *
 */
public class Test3 {
	public static void main(String[] args) throws IOException {
		//指定一个输出源
		FileWriter fw = new FileWriter("abc.txt",true);
		
		//写入数据
		fw.write("superman1");
		
		//刷新并关闭资源
		fw.close();
	}
}
