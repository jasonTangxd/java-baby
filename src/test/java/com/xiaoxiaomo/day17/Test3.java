package com.xiaoxiaomo.day17;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 使用字节流 读取一个文本文件  显示在控制台上
 * @author xiaoxiaomo
 *
 */
public class Test3 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("D:\\a.txt");
/*		int ch = fis.read();
		System.out.println(ch);
		int ch1 = fis.read();
		System.out.println(ch1);
		int ch2 = fis.read();
		System.out.println(ch2);
		int ch3 = fis.read();
		System.out.println(ch3);*/
		
		//读取方法一
//		int ch = 0;
//		while((ch = fis.read()) != -1){
//			System.out.println((char)ch);
//		}
		
		//读取方式二
		System.out.println(fis.available());
		
		//方式三
//		byte[] buf = new byte[1024];
//		int len = 0;
//		while((len = fis.read(buf)) != -1){
//			System.out.println(new String(buf , 0 , len));
//		}
		
		//不建议使用？
		byte[] buf = new byte[fis.available()];
		int len = fis.read(buf);
		System.out.println(new String(buf,0,len));
		
		fis.close();
	}
}
