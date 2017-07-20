package com.xiaoxiaomo.day17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 复制一个文本文件
 * @author xiaoxiaomo
 *
 */
public class Test15 {
	public static void main(String[] args) throws IOException {
		//读取源文件
		FileInputStream fis = new FileInputStream("d:\\abc.txt");
		//转换并指定编码进行读取
		InputStreamReader isr = new InputStreamReader(fis,"gbk");
		//高效读取
		BufferedReader bfr = new BufferedReader(isr);
		
		//目标文件
		FileOutputStream fos = new FileOutputStream("d:\\ccc.txt");
		//指定编码集进行写入
		OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
		//高效写入
		BufferedWriter bfw = new BufferedWriter(osw);
		
		//循环读取并且写入目标文件
		/*String line = null;
		while((line = bfr.readLine()) != null){
			bfw.write(line);
			bfw.newLine();
			bfw.flush();
		}*/
		
		int ch = 0;
		while((ch = bfr.read()) != -1){
			bfw.write(ch);
		}
		
		//关闭流
		bfr.close();
		bfw.close();
		
	}
}
