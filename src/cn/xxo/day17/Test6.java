package cn.xxo.day17;

import java.io.IOException;
import java.io.InputStream;

/**
 * 编写一个程序，将用户输入的内容转换为大写写到控制台上，如果输入的是quit退出
 * @author gs
 *
 */
public class Test6 {
	public static void main(String[] args) throws IOException {
		intput_demo();
	}

	public static void intput_demo() throws IOException {
		/*
		 * 读取用户输入内容
		 * 读到转换为大写
		 * 打印到控制台
		 */
		InputStream in = System.in;
		//定义一个边长数组  用于存储一行的数据
		StringBuilder sb = new StringBuilder();
		
		int ch = 0;
		while((ch = in.read()) != -1){ //循环读取
			if(ch == '\r'){
				continue;
			}
			if(ch == '\n'){
				String tmp = sb.toString();
				if("quit".equals(tmp)){  //当用户输入quit退出整个程序
					return;
				}
				System.out.println(tmp.toUpperCase());
				sb.delete(0, sb.length());  //清空变长数组
				
			}else{
				//如果没有遇到换行符   将字母转换为char添加到边长数组中
				sb.append((char)ch); 
			} 
		}
	}
}
