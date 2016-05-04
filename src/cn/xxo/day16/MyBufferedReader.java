package cn.xxo.day16;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class MyBufferedReader  extends Reader{
	
	private FileReader fr;
	
	MyBufferedReader(FileReader fr){
		this.fr = fr;
	}
	
	//定义一个数组，读取源文件上的数据
	char[] buf = new char[1024];
	//指针 用于读取数组数组
	int pos ;
	//计数器  统计剩余数据
	int count;
	
	//行号
	int lineNumber;
	
	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public int myRead() throws IOException{
		//如果数组中的数据已经取完或者没有数据
		if(count == 0){
			count = fr.read(buf);  //第一次是9    第二次是3  第三次-1
		}
		if(count < 0){
			return -1;
		}
		//读取数组中的数据
		int ch = buf[pos];
		//指针递增
		pos++;
		//剩余数据长度递减
		count--;
		
		return ch;
	}

	public void myClose() throws IOException {
		fr.close();
	}
	
	public String myReadLine() throws IOException{
		//定义一个边长数组，用于存储一行的数组
		StringBuilder sb = new StringBuilder();
		//开始读取数据（从内存）
		int ch = 0;
		while((ch = myRead()) != -1){
			//如果遇到\r不存，跳出本次循环
			if(ch == '\r'){
				continue;
			}
			//遇到\n返回这一行的数据
			if(ch == '\n'){
				lineNumber++;  //行号递增 
				return sb.toString();
			}
			//没有遇到换行符时不断添加
			sb.append((char)ch);
		}
		//如果最后一行没有换行符  判断边长数组中是否有数据  有就返回
		if(sb.length() != 0){
			lineNumber++;
			return sb.toString();
		}
		return null;
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}
