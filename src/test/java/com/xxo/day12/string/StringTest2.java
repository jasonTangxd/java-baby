package com.xxo.day12.string;

/**
 * 获取两个字符中最大相同子串 .
	"sadabcdfghjkl"
	"werabcdtyu"
 * @author xiaoxiaomo
 *
 */
public class StringTest2 {

	public static void main(String[] args) {
//		String str1 = "sadabcdfghjkl";
//		String str2 = "werabcdtyu";
		String str1 = "abcdefg";
		String str2 = "aefgt";
		System.out.println(getMaxSub(str1, str2));
	}
	
	/**
	 * 思路： 
	 * 	第一步：找到大小字符串
	 *  第二步：如果小的字符串恰好包含在大的字符串中话，就返回小的字符串
	 *  	如果不在，
	 * @param scr1
	 * @param scr2
	 * @return
	 */

	public static String getMaxSub(String scr1, String scr2) {
		String max = scr1.length() > scr2.length() ? scr1 : scr2;
		String min = scr1.length() < scr2.length() ? scr1 : scr2;
		
		for (int x = 0; x < min.length(); x++) {
			for(int start = 0, end = min.length() -x; end != min.length() + 1; start++,end++) {
//				System.out.println(min.substring(start, end));
				String temp = min.substring(start, end);
				if(max.contains(temp)) {//max.indexOf(temp) != -1
					return temp; 
				}
			}
		}
		return null;
	}
}
