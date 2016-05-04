package cn.xxo.day16;

import java.io.FileReader;
import java.io.IOException;

/**
 * 使用字符流读取一个文本文件，将读取到的文本内容打印到控制台。
 * @author gs
 *
 */
public class Test5 {
	public static void main(String[] args) throws IOException {
		//源文件
		FileReader fr = new FileReader("abc.txt");
		
		char[] buf = new char[2];
		
		int len = 0;
		while((len = fr.read(buf)) != -1){
			System.out.println(new String(buf));
		}
		
		
		
		
		//开始读取
/*		int ch = fr.read();
		System.out.println((char)ch);
		int ch1 = fr.read();
		System.out.println(ch1);
		int ch2 = fr.read();
		System.out.println(ch2);*/
		
//		int ch = 0;
//		while((ch = ch) != -1){
//			System.out.print((char)ch);
//		}
		
		//关闭
		fr.close();
	}
}
