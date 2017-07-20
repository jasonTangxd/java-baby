package com.xiaoxiaomo.day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 使用转换流实现 Test6的打印功能
 * 
 * @author xiaoxiaomo
 *
 */
public class Test10 {
	public static void main(String[] args) throws IOException {
		read_console();
	}

	public static void read_console() throws IOException {
		InputStream in = System.in;
		// 字节流转换为字符流
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader bfr = new BufferedReader(isr);

		String line = null;
		while ((line = bfr.readLine()) != null) {
			if ("exit".equals(line)) {
				return;
			}
			System.out.println(line.toUpperCase());
		}
		isr.close();
		bfr.close();
	}
}
