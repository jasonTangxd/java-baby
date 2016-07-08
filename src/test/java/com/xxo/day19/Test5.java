package com.xxo.day19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/**
 * 序列流二  (推荐使用此方法合并文件)
 * @author xiaoxiaomo
 *
 */
public class Test5 {
	public static void main(String[] args) throws IOException {
//		FileInputStream fis1 = new FileInputStream("d:\\aaa\\a.txt");
//		FileInputStream fis2 = new FileInputStream("d:\\aaa\\b.txt");
//		FileInputStream fis3 = new FileInputStream("d:\\aaa\\c.txt");
		
		//定义输出
		FileOutputStream fos = new FileOutputStream("d:\\aaa\\d.txt");
		
		//将一组流添加到list中
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		al.add(new FileInputStream("d:\\aaa\\a.txt"));
		al.add(new FileInputStream("d:\\aaa\\b.txt"));
		al.add(new FileInputStream("d:\\aaa\\c.txt"));
		
		//将list转换为Enumeration
		Enumeration<FileInputStream> en = Collections.enumeration(al);
		
		
		SequenceInputStream sis = new SequenceInputStream(en);
		
		byte[] buf = new byte[8192];
		int len = 0 ;
		while((len = sis.read(buf)) != -1){
			fos.write(buf,0,len);
		}
		
		sis.close();
		fos.close();
	}
}
