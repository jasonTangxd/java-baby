package com.xxo.day19;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件切割   
 * @author xiaoxiaomo
 *
 */
public class Test6 {
	public static void main(String[] args) throws IOException {
		qiege_file();
	}

	public static void qiege_file() throws IOException {
		/*
		 * 有一个较大源读取文件
		 * 
		 */
		File file = new File("d:\\aaa\\y.rmvb");
		FileInputStream fis = new FileInputStream(file);
		
		FileOutputStream fos = null;
		byte[] buf = new byte[10485760 * 4];
		
		int count = 0;
		int len = 0;
		while((len = fis.read(buf)) != -1){
			count++;
			fos = new FileOutputStream(new File(file.getParent()+"\\"+count+".part"));
			fos.write(buf,0,len);
			fos.close();
		}
		fis.close();
	}
}
