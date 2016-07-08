package com.xxo.day18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 字节流复习
 * @author xiaoxiaomo
 *
 */


public class Test1 {
	public static void main(String[] args) throws IOException {
		//解码
		BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream("file"),"gbk"));
		//编码
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file"),"gbk"));
		
//		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}
