package com.xiaoxiaomo.day12.string;

public class StringTest {

	public static void main(String[] args) {
		String str = "woainimenmemeda";
		System.out.println(test_reverse(str));
	}
	
	public static String test_reverse(String str) {
		/*
		 * 	第一步：将字符串转化为字符数组chs[]
			第二步：将字符数组进行反转chs[]
			第三步：new String(chs);
		 */
		//第一步：将字符串转化为字符数组chs[]
		char[] chs = str.toCharArray();
		//第二步：将字符数组进行反转chs[]
		reverseArray(chs);
		//第三步：new String(chs);
		return new String(chs);
	}

	private static void reverseArray(char[] chs) {
		for (int i = 0; i < chs.length / 2; i++) {
			swap(chs, i, chs.length - 1 - i);
		}
	}

	private static void swap(char[] chs, int i, int j) {
		char temp = chs[i];
		chs[i] = chs[j];
		chs[j] = temp;
	} 

}
