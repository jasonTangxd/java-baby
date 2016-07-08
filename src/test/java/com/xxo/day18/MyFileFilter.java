package com.xxo.day18;

import java.io.File;
import java.io.FileFilter;

public class MyFileFilter implements FileFilter{
	/*
	 * 要隐藏文件  要指定扩展名
	 */
	private String suffix;
	MyFileFilter(String suffix){
		this.suffix = suffix;
	}
	@Override
	public boolean accept(File pathname) {
		
		return pathname.getName().endsWith(suffix) && !pathname.isHidden();
	}
}
