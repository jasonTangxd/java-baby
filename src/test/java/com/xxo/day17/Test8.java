package com.xxo.day17;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 将用户输入的数据写入到文本文件中
 * @author xiaoxiaomo
 *
 */
public class Test8 {
	public static void main(String[] args) throws IOException {
		//输出目的
		FileOutputStream fos = new FileOutputStream("d:\\a.txt");
		BufferedOutputStream bfos = new BufferedOutputStream(fos);
		
		InputStream in = System.in;
		BufferedInputStream bin = new BufferedInputStream(in);
		
		int ch = 0 ;
		while((ch = bin.read()) != -1){
			bfos.write(ch);
			bfos.flush();
		}
		
	}
}
