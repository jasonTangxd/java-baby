package com.xiaoxiaomo.day17;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 复制一个图片
 * @author xiaoxiaomo
 *
 */
public class Test4 {
	public static void main(String[] args) throws IOException {
		copy_jpg();
	}

	/*
	 * 复制图片
	 */
	public static void copy_jpg() throws IOException {
		//定义图片读取源
		FileInputStream fis = new FileInputStream("d:\\");
		BufferedInputStream bfis = new BufferedInputStream(fis);
		
		//定义图片写入源
		FileOutputStream fos = new FileOutputStream("d:\\1.mkv");
		BufferedOutputStream bfos = new BufferedOutputStream(fos);
		
		//读取文件时不建议使用此方法
/*		int ch = 0;
		while((ch = bfis.read()) != -1){
			bfos.write(ch);
			bfos.flush(); //不建议对字节流高效读写进行刷新
		}*/
		
		//建议使用此方法
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = bfis.read(buf)) != -1){
			bfos.write(buf, 0, len);
//			bfos.flush();
		}
		
		bfis.close();
		bfos.close();
	}
}
