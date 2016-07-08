package com.xxo.day19;

import java.io.File;
import java.io.FilenameFilter;

public class MyFilenameFilter implements FilenameFilter {

	private String suffix;
	MyFilenameFilter(String suffix){
		this.suffix = suffix;
	}
	@Override
	public boolean accept(File dir, String name) {
		
		return name.endsWith(suffix);
	}

}
