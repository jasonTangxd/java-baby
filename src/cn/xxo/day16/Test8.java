package cn.xxo.day16;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流复制一个文本文件(高效方法、异常处理)。
 * 
 * @author gs
 *
 */
public class Test8 {
	public static void main(String[] args) {
		/*
		 * 有一个读取源和写入源将源文件中的内容读取出来创建一个新的文件将内容刷新到新的文件中
		 */
		// 有一个读取源和写入源
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("d:\\abc.txt");
			fw = new FileWriter("d:\\abc_copy.txt");

			// 利用自定义的缓存数组高效读写
/*			char[] buf = new char[1024];
			int len = 0;
			while((len = fr.read(buf)) != -1){
				fw.write(buf,0,len);
			}*/
			
			
		} catch (Exception e) {
			throw new RuntimeException("复制失败");
		} finally {
			// 关闭流
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					System.out.println("关闭失败");;
				}
			}

			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					System.out.println("关闭失败");
				}
			}

		}

	}
}
