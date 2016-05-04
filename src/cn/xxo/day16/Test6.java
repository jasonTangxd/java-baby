package cn.xxo.day16;

import java.io.FileReader;
import java.io.IOException;
/**
 * 使用字符流读取一个文本文件，将读取到的文本内容打印到控制台。
 * @author gs
 *
 */
public class Test6 {
	private static int BUFFER_SIZE = 3;

	public static void main(String[] args) throws IOException {
		//源文件
		FileReader fr = new FileReader("abc.txt");
		
		
		//开始读取
/*		char[] buf = new char[BUFFER_SIZE];
		int len = fr.read(buf);
		System.out.println(len + ":" + new String(buf));
//		int len1 = fr.read(buf);
//		System.out.println(len1 + ":" + new String(buf));
//		int len2 = fr.read(buf);
//		System.out.println(len2 + ":" + new String(buf));
*/		
		char[] buf = new char[BUFFER_SIZE];
		int len = 0;
		while((len = fr.read(buf)) != -1){
			System.out.print(new String(buf,0,len));
		}
		
		//关闭
		fr.close();
	}
}
