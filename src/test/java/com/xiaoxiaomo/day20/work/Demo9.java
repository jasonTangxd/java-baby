package com.xiaoxiaomo.day20.work;

public class Demo9 {
	public static void main(String[] args) {
		String str = " ksdhks jkjkjds dsds ";
		str = str.trim();
		
		StringBuffer sb = new StringBuffer();
		char[] charArray = str.toCharArray();
		for (char c : charArray) {
			if(!Character.isWhitespace(c)){
				sb.append(c);
			}
		}
		System.out.println(sb.toString());
		
	}

}
