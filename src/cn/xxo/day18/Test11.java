package cn.xxo.day18;

import java.io.File;

/**
 * 深度遍历文件夹
 * @author gs
 *
 */
public class Test11 {
	public static void main(String[] args) {
//		listAll_1();
		
		File file = new File("D:\\a");
//		listAll_2(file);
		listAll_3(file,0);
	}

	/**
	 * 添加目录缩进
	 * @param file
	 */
	public static void listAll_3(File file , int count) {
		System.out.println(addSpace(count) + file);
		//每调用一次加一次
		count++;
		File[] listFiles = file.listFiles();
		for (int i = 0; i < listFiles.length; i++) {
			//如果是目录
			if(listFiles[i].isDirectory()){
				listAll_3(listFiles[i],count);
				
			}else{//是文件
				System.out.println(addSpace(count) +listFiles[i]);
			}
		}
	}

	//在文件夹前面添加空格
	public static String addSpace(int count) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i< count ; i ++){
			sb.append("\t");
		}
		return sb.toString();
	}

	/*
	 * 深度遍历文件夹
	 * @param file
	 */
	public static void listAll_2(File file) {
		System.out.println("dir : " + file);
		File[] listFiles = file.listFiles();
		for (int i = 0; i < listFiles.length; i++) {
			//如果是目录
			if(listFiles[i].isDirectory()){
				listAll_2(listFiles[i]);
				
			}else{//是文件
				if(listFiles[i].isHidden()){
					System.out.println("file : " +listFiles[i]);
				}
			}
		}
	}

	/*
	 * 不建议此方法遍历文件夹
	 */
	public static void listAll_1() {
		//指定一个路径
		File file = new File("D:\\abc");
		//列出文件夹下的文件及文件夹
		File[] listFiles = file.listFiles();
		//遍历数组
		for(int i = 0 ; i < listFiles.length ; i++){
			//如果是目录
			if(listFiles[i].isDirectory()){
				//列出该文件夹下面的文件及文件夹
				File[] listFiles2 = listFiles[i].listFiles();
				for(int j = 0 ; j < listFiles2.length ; j++){
					System.out.println(listFiles2[j]);
				}
			}
			//如果是文件  打印路径
			System.out.println(listFiles[i]);
		}
	}
}
