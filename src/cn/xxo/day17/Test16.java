package cn.xxo.day17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * 
 * @author gs
 *
 */
public class Test16 {
	public static void main(String[] args) throws IOException {
		//读取源文件
		InputStream in = System.in;
		//转换并指定编码进行读取
		InputStreamReader isr = new InputStreamReader(in);
		//高效读取
		BufferedReader bfr = new BufferedReader(isr);
		//缩写
//		BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(in)));
		
		//目标文件
		OutputStream out = System.out;
		//指定编码集进行写入
		OutputStreamWriter osw = new OutputStreamWriter(out);
		//高效写入
		BufferedWriter bfw = new BufferedWriter(osw);
		//缩写
//		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutpuStream(out)));
		
		//循环读取并且写入目标文件
		/*String line = null;
		while((line = bfr.readLine()) != null){
			bfw.write(line);
			bfw.newLine();
			bfw.flush();
		}*/
		
		int ch = 0;
		while((ch = bfr.read()) != -1){
			bfw.write(ch);
			bfw.flush();//刷入控制台
		}
		
		//关闭流
		bfr.close();
		bfw.close();
		
	}
}
