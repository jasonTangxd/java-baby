package cn.xxo.day16;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 在磁盘上写一个文件，并且向文件中写入相应的字母。
 * @author gs
 *
 */
public class Test1 {
	public static void main(String[] args) throws IOException {
		/**
		 * 实例化FileWriter时，会产生一个对应的文件
		 * 类在创建文件时，如果不存在，创建一个，如果存在，覆盖。
		 */
		//参数是路径+文件名
		FileWriter fw = new FileWriter("abc.txt");
		//将数据写到缓冲区
		fw.write("abcd");
		//将缓冲区的数据刷到具体的文件中 
//		fw.flush();
		//关闭 先刷新在关闭。
		fw.close();
	}
}
