package cn.xxo.day17;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 读取window创建的文件--其中有中文字符
 * @author gs
 *
 */
public class Test12 {
	public static void main(String[] args) throws IOException {
		 //使用字节流读取一个指定的文本文件
		 FileInputStream fis = new FileInputStream("d:\\b.txt");
		 //使用转换流将文本文件内容转换为字符流  转换时指定对应的字符集进行读取
		 InputStreamReader isr = new InputStreamReader(fis,"gbk");
		 //高效读取
		 BufferedReader bfr = new BufferedReader(isr);
		 
		 int ch = 0;
		 while((ch = isr.read()) != -1){
			 System.out.println((char)ch);
		 }
	}
}
