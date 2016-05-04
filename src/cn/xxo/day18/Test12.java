package cn.xxo.day18;

import java.io.File;

/**
 * 递归删除文件夹
 * @author gs
 *
 */
public class Test12 {
	public static void main(String[] args) {
		File file = new File("D:\\aa");
//		boolean b = file.delete();
//		System.out.println(b);
		deletedir(file);
	}

	public static void deletedir(File file) {
		//列出；路径下的文件及文件夹
		File[] listFiles = file.listFiles();
		//遍历删除
		for(int i = 0 ; i < listFiles.length ; i++){
			if(listFiles[i].isDirectory()){//如果是目录
				deletedir(listFiles[i]);
				listFiles[i].delete();
			}else{
				//不管是目录或者是文件都尝试删一下
				listFiles[i].delete();
			}
		}
		//删除顶级文件夹
		file.delete();
	}
}
