package com.xxo.day16;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * LineNumberReader用法
 * 
 * @author xiaoxiaomo
 *
 */
public class Test14 {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("d:\\c.txt");
		LineNumberReader lnr = new LineNumberReader(fr);
		String line = null;
		lnr.setLineNumber(10);
		while ((line = lnr.readLine()) != null) {
			System.out.println(lnr.getLineNumber() + ":" + line);
		}
		
		
		
/*		MyBufferedReader mlnr = new MyBufferedReader(fr);
		String line = null;
		mlnr.setLineNumber(10);
		while ((line = mlnr.myReadLine()) != null) {
			System.out.println(mlnr.getLineNumber() + ":" + line);
		}*/

		lnr.close();
	}
}
