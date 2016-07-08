package com.xxo.day19;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 获取指定目录下，指定扩展名的文件（包含子目录中的），将获取到的文件绝对路径按照关键词过滤，存储到UTF-8格式文本文件中。
 * @author xiaoxiaomo
 *
 */
public class Test2 {
	public static void main(String[] args) {
		/*
		 * 开发思路：
		 * 1、可以使用FilenameFilter过滤文件名
		 * 2、根据关键词过滤，使用contains过滤绝对路径
		 * 3、转换流 OutputStreamWriter指定编码格式
		 * 4、递归
		 */
//		args[0];
//		args[1];
//		args[2];
		
		//需要查找的路径
		File path = new File("D:\\a");
		File outpath = new File("D:\\aa.txt");
		//定义一个容器
		List<String> list = new ArrayList<String>();
		//定义一个文件名过滤器
		MyFilenameFilter filter = new MyFilenameFilter(".txt");
		//查找
		findFiles(path,list,filter);
		
		//关键词
		String suffix = "a";
		//写结果集
		writeFiles(list,outpath,suffix);
		
	}

	/**
	 * 写结果集
	 * @param list  结果集
	 * @param outpath  输出目录
	 * @param suffix   关键词 
	 */
	public static void writeFiles(List<String> list, File outpath,String suffix) {
		if(list.size() == 0){
			return;
		}
		BufferedWriter bfw = null;
		try{
		//指定写入路径
		bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outpath),"utf-8"));
		
		//遍历结果集 写
		for (String path : list) {
			if(path.contains(suffix)){
				bfw.write(path);
				bfw.newLine();
				bfw.flush();
			}
		}
		
		}catch(IOException e){
			throw new RuntimeException("写入失败 error :" + e.toString());
		}finally{
			//关闭流
			if(bfw != null){
				try {
					bfw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * 找到符合条件的文件名
	 * args:path为传递进来文件夹路径
	 * 
	 */
	public static void findFiles(File path, List<String> list, MyFilenameFilter filter) {
		//判断传递进来的路径是否存在
		if(!path.exists()){
			return;
		}
		//根据条件进行过滤
		File[] rsList = path.listFiles();  //目录下所有的内容查找出来
		if(rsList.length > 0){
			//遍历
			for (File file : rsList) {
				if(file.isDirectory()){//是目录 
					//递归
					findFiles(file, list, filter);
					
				}else{
					//过滤文件扩展名
					if(filter.accept(file, file.getName())){
						list.add(file.getAbsolutePath());
					}
				}
			}
		}
	}
	
	/*		File[] rsList = path.listFiles(filter);
	if(rsList.length > 0){
		for (File file : rsList) {
			if(file.isDirectory()){//是目录
				findFiles(path, list, filter);
			}else{//是文件
				list.add(file.getAbsolutePath());
			}
		}
	}*/
	
}
