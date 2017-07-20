package com.xiaoxiaomo.day17;

import java.io.IOException;
import java.io.InputStream;

/**
 * 读取键盘输入的数据 打印到控制台上
 * @author xiaoxiaomo
 *
 */
public class Test5 {
	public static void main(String[] args) throws IOException {
		//获取键盘输入的数据 
		InputStream in = System.in;
//		System.out.println(in.read());
//		System.out.println(in.read());
//		System.out.println(in.read());
		int ch = 0;
		while((ch = in.read()) != -1){
			System.out.print((char)ch);
		}
		
//		System.out.println((int)'\r');
//		System.out.println((int)'\n');
		
//		in.close();
//		InputStream in1 = System.in;
//		System.out.println(in1.read());
	}
}
