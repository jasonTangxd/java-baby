package cn.xxo.day17;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 将文本文件中的内容打印到控制台上
 * @author gs
 *
 */
public class Test9 {
	public static void main(String[] args) throws IOException {
		//读取源
		FileInputStream fis = new FileInputStream("d:\\a.txt");
		OutputStream out = System.out;
		int ch = 0;
		while((ch = fis.read()) != -1){
			out.write(ch);
		}
		fis.close();
	}
}
