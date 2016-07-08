package com.xxo.day16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 高效读取文本数据
 * @author xiaoxiaomo
 *
 */
public class Test10 {
	public static void main(String[] args) throws IOException {
		//获取一个源
		FileReader fr = new FileReader("file/abc.txt");
		BufferedReader bfr = new BufferedReader(fr);
		//开始读
/*		int ch = 0;
		while((ch = bfr.read()) != -1){
			System.out.println((char)ch);
		}*/
		
		char[] buf = new char[1024];
		int len = 0;
		bfr.read(buf);
		while((len = bfr.read(buf)) != -1){
			System.out.println(new String(buf,0,len));
		}
		System.out.println(new String(buf));
		
/*		String line = bfr.readLine();
		System.out.println(line);
		String line1 = bfr.readLine();
		System.out.println(line1);
		String line2 = bfr.readLine();
		System.out.println(line2);*/
		
//		String line = null;
//		while((line = bfr.readLine()) != null){
//			System.out.println(line);
//		}
		
		//关闭流
		bfr.close();
	}
}
