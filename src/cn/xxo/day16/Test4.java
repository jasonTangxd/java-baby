package cn.xxo.day16;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 对IO操作实现异常处理
 * 
 * @author gs
 *
 */
public class Test4 {
	public static void main(String[] args) {
		// 指定一个输出源
		FileWriter fw = null;
		try {
			fw = new FileWriter("d:\\abc.txt");
			// 写入数据
			fw.write("superman");

		} catch (IOException e) {
			// e.printStackTrace();
			throw new RuntimeException("写入失败");
		} finally {
			// 刷新并关闭资源
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("关闭失败");
				}
			}
		}

	}
}
