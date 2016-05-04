package cn.xxo.day16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 利用高效读写 复制一个文本文件
 * @author gs
 *
 */
public class Test11 {
	public static void main(String[] args) throws IOException {
		
		copy_text();
		
	}

	public static void copy_text() {
		FileReader fr = null;
		BufferedReader bfr = null;
		FileWriter fw = null;
		BufferedWriter bfw = null;
		try {
			//获取一个读取源
			fr = new FileReader("d:\\abc.txt");
			//使用高效读取
			bfr = new BufferedReader(fr);
			//创建一个写入源
			fw = new FileWriter("d:\\c.txt");
			//使用高效写入
			bfw = new BufferedWriter(fw);
			
			//开始读写
			//方式一
/*		int ch = 0;
			while((ch = bfr.read()) != -1){
				bfw.write(ch);
//			bfw.newLine();
				bfw.flush();
			}*/
			
			//方式二
/*		char[] buf = new char[1024];
			int len = 0;
			bfr.read(buf);
			bfw.write(buf);*/
			
			//方式三
/*		char[] buf = new char[1024];
			int len = 0;
			while((len = bfr.read(buf)) != -1){
				bfw.write(buf,0,len);
			}*/
			
			//方式四
			String line = null;
			while((line = bfr.readLine()) != null){
				bfw.write(line);
				bfw.newLine();
				bfw.flush();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bfr != null){
				try {
					bfr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(bfw != null){
				//关闭流
				try {
					bfw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
