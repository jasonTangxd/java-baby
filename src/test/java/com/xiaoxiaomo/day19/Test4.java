package com.xiaoxiaomo.day19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 序列流一
 * @author xiaoxiaomo
 *
 */
public class Test4 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis1 = new FileInputStream("d:\\aaa\\a.txt");
		FileInputStream fis2 = new FileInputStream("d:\\aaa\\b.txt");
		FileInputStream fis3 = new FileInputStream("d:\\aaa\\c.txt");
		
//		FileOutputStream fos = new FileOutputStream("d:\\aaa\\d.txt");
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:\\aaa\\d.txt")));
		
		Vector<FileInputStream> v = new Vector<FileInputStream>();
		v.add(fis1);
		v.add(fis2);
		v.add(fis3);
		
		//将FileInputStream对象添加到集合中并转换为Enumeration
		Enumeration<FileInputStream> e = v.elements();
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(new SequenceInputStream(e)));
		
		String line = null;
		while((line = bfr.readLine())!= null){
			bfw.write(line);
			bfw.newLine();
			bfw.flush();
		}
		
		bfr.close();
		bfw.close();
	}
}
