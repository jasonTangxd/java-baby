package com.xxo.day18;

import java.io.File;

/**
 * 
 * @author xiaoxiaomo
 *
 */
public class Test9 {
	public static void main(String[] args) {
//		File[] listRoots = File.listRoots();
//		for (File file : listRoots) {
//			System.out.println(file.getPath());
//		}
		
/*		File file = new File("d:\\abc");
		File[] listFiles = file.listFiles();
		for (File f : listFiles) {
			System.out.println(f);
		}*/
		
		File file = new File("d:\\abc");
		String[] names = file.list(new MyFilenameFilter("d"));
		for (String name : names) {
			System.out.println(name);
		}
		
		// File file = new File("L:\\");
		
		// long freeSpace = file.getFreeSpace();
		// long totalSpace = file.getTotalSpace();
		// long usableSpace = file.getUsableSpace();
		// System.out.println("freeSpace = " + freeSpace);
		// System.out.println("totalSpace = " + totalSpace);
		// System.out.println("usableSpace = " + usableSpace);
		
	}
}
