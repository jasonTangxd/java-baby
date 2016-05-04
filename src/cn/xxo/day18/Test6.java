package cn.xxo.day18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 重命名文件  、 剪切功能实现
 * @author gs
 *
 */
public class Test6 {
	public static void main(String[] args) throws IOException {
//		rename_file1();
		rename_file2();
		rename_file3();
	}

	/*
	 * 剪切功能
	 * 剪切功能可能失败：
	 * 1、文件占用
	 * 2、没有删除权限
	 * 3、没有写入权限
	 * 
	 */
	public static void rename_file3() {
//		方式一
//		File file1 = new File("h:\\abc.txt");
//		File file2 = new File("c:\\xxx.txt");
//		file1.renameTo(file2);
		
		File file1 = new File("h:\\abc.txt");
		File file2 = new File("d:\\");
		File file3 = new File(file2,"xxx.txt");
		file1.renameTo(file3);
	}


	/*
	 * 使用文件对象完成重命名
	 */
	public static void rename_file2() {
		File file1 = new File("d:\\abc.txt");
		File file2 = new File("d:\\xxx.txt");
		file1.renameTo(file2);
	}

	/*
	 * 使用字符流读取写入方式完成重命名
	 */
	public static void rename1() throws FileNotFoundException, IOException {
		File file1 = new File("d:\\abc.txt");
		File file2 = new File("d:\\xxx.txt");
		FileReader fr = new FileReader(file1);
		FileWriter fw = new FileWriter(file2);
		
		int ch = 0;
		while((ch = fr.read()) != -1){
			fw.write(ch);
		}
		
//		file1.delete();
		file1.deleteOnExit();
		
		fr.close();
		fw.close();
	}
}
