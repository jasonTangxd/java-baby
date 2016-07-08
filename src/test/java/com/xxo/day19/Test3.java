package com.xxo.day19;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * 打印流
 * @author xiaoxiaomo
 *
 */
public class Test3 {
	public static void main(String[] args) throws IOException {
		//此类会自动刷新缓冲区
//		PrintStream ps = new PrintStream("d:\\a.txt");
//		ps.write(97);
//		ps.write(609);
//		ps.print(97);
		
		InputStream  bfr = System.in;
		PrintWriter pw = new PrintWriter(System.out);
		
		
		int ch = 0;
		while((ch = bfr.read()) != -1){
//			if(line.equals("quit")){
//				break;
//			}
			pw.println(ch);
			pw.flush();
		}
		pw.close();
		
	}
}
