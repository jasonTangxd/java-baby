package com.xxo.day17;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 将字节流转换为字符流
 * @author xiaoxiaomo
 *
 */
public class Test11 {
	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
//		FileInputStream fis = new FileInputStream("d:\\b.txt");
		
		InputStreamReader isr = new InputStreamReader(in);
		int ch = 0;
		while((ch = isr.read()) != -1){
			System.out.print((char)ch);
		}
		isr.close();
	}
}
