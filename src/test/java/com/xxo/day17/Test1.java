package com.xxo.day17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 复习字符流  copy文本文件
 * @author xiaoxiaomo
 *
 */
public class Test1 {
	private static int BUFFER_SIZE = 1024;

	public static void main(String[] args) throws IOException {
		copy_text();
	}
	
	/*
	 * 指定一个读取源 读取源是文本文件
	 * 指定一个写入目的  也是一个文件  文件名可以和源读取文件不一样
	 * 频繁读取文本文件的内容  频繁的写入缓冲区
	 * 关闭并且刷新内容到目的地
	 */
	public static void copy_text() {
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader bfr = null;
		BufferedWriter bfw = null;
		//定义源
		try {
			//读取源
			fr = new FileReader("d:\\abc.txt");
			//高效读取
			bfr = new BufferedReader(fr);
			
			//写入源
			fw = new FileWriter("d:\\cc.txt");
			//高效写入
			bfw = new BufferedWriter(fw);
			
			//读取并写入
			//方式一
//			int ch = 0 ;
//			while((ch = bfr.read()) != -1){
//				bfw.write(ch);
//			}
			
			//方式二
//			char[] buf = new char[BUFFER_SIZE];
//			int len = 0;
//			while((len = bfr.read(buf)) != -1){
//				bfw.write(buf, 0, len);
//			}
			
			//方式三
			String line = null;
			while((line = bfr.readLine()) != null){
				bfw.write(line);
				bfw.newLine();
				bfw.flush();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭流
			if(bfr != null){
				try {
					bfr.close();
				} catch (IOException e) {
					throw new RuntimeException("关闭失败");
				}
			}
			
			if(bfw != null){
				try {
					bfw.close();
				} catch (IOException e) {
					throw new RuntimeException("关闭失败");
				}
			}
		}
		
	}
}
