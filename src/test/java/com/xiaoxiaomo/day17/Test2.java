package com.xiaoxiaomo.day17;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用字节流创建一个文本文件  向其中写入内容
 * @author xiaoxiaomo
 *
 */
public class Test2 {
	public static void main(String[] args) throws IOException {
		//和字符流相同 会创建一个目标文件
		FileOutputStream fos = new FileOutputStream("d:\\a.txt");
		fos.write("superman".getBytes());
		fos.flush();
		fos.close();
		
/*		FileReader fr = new FileReader("abc.txt");
		FileWriter fw = new FileWriter("abc.txt");
		fw.write("abcccc");
		fw.flush();
		
		int ch = 0;
		while((ch = fr.read()) != 0){
			System.out.println((char)ch);
		}*/
		
		fos.close();
		
	}
}
