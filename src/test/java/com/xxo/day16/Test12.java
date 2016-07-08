package com.xxo.day16;

import java.io.FileReader;
import java.io.IOException;

/**
 * 调用自己的高效读取类MyBufferedReader
 * @author xiaoxiaomo
 *
 */
public class Test12 {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("d:\\c.txt");
		MyBufferedReader mybfr = new MyBufferedReader(fr);
//		int ch = 0;
//		while((ch = mybfr.myRead()) != -1){
//			System.out.println((char)ch);
//		}
		String line = null;
		while((line = mybfr.myReadLine()) != null){
			System.out.println(line);
		}
		
		mybfr.myClose();
	}
}
