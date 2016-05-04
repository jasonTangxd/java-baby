package cn.xxo.day18;

import java.io.File;

/**
 * 列出目录中文件
 * 
 * @author gs
 *
 */
public class Test7 {
	public static void main(String[] args) {
		File file = new File("D:\\abc");
		String[] list = file.list();
		for (String name : list) {
			if (name.endsWith(".java")) {
				System.out.println(name);
			}
		}
	}
}
