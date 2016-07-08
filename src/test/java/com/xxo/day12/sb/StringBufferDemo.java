package com.xxo.day12.sb;

public class StringBufferDemo {

	/**
	 * StringBuffer:
	 * Create Read Update Delete
		1、增
			StringBuffer append(数据)：可以追加任何数据到我们字符串缓冲区中
			StringBuffer insert(offset, 数据)：在偏移量offset(距离下标为0的字符长度)下标出插入数据
		2、删
			StringBuffer delete(int start, int end):删除区间[start, end)之间的字符串，返回对象本身  
			StringBuffer deleteCharAt(int index)  ：删除指定下标出的字符
		3、改
			void setCharAt(int index, char ch) ：将下标index处的字符修改为给定的字符ch
		4、查
			 char charAt(int index) :返回指定下标index处的字符
			 void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
			 	将sb中的区间[srcBegin, srcEnd)拷贝到dst中，dst从dstBegin开始复制
			 int indexOf(String str) ：返回字符串str出现的第一次的下标
			 int indexOf(String str, int fromIndex) ：返回字符串str从fromIndex开始出现的第一次的下标
 			 int lastIndexOf(String str) ：返回字符串str出现的第后次的下标
 			 int lastIndexOf(String str, int fromIndex)：返回字符串str从fromIndex开始往左查出现的第一次的下标
 			 int length()：长度
 			 String substring(int start) ：返回从start开始到结束的字符串
 			 String substring(int start, int end) ：返回给定区间[start, end)的字符串
 		5、反转
 			StringBuffer reverse() ：将sb中的字符串进行反转
 		6、替换
 			StringBuffer replace(int start, int end, String str)  将[start, end)区间中的字符串替换为str
 		总结：
 			StringBuffer是一个容器，长度可变，可以接收任何数据类型
 		jdk进行升级一般考虑的问题：
 			1、提高安全性
 			2、提高效率
 			3、操作简便
 		StringBuilder:
 			StringBuilder提高了与StringBuffer几乎一致的api，不同的是
 			1、StringBuffer是jdk1.0的时候出现，StringBuilder是jdk1.5的时候出现
 			2、StringBuffer是线程安全的，StringBuilder是线程非安全
 			3、StringBuffer的效率要比StringBuilder的效率低
 			建议大家使用StringBuilder
 		
 		String和Sb的区别：
 			1、sb的是可变的，String不可变
 			2、sb在操作的时候是操作的同一个对象，String在操作的时候在不断的创建对象
 			
	 */
	public static void main(String[] args) {
		method_int2SArr();
	}
	
	//讲一个int数组转换为一个字符串
	public static void method_int2SArr() {
		//Log 4 java
		int[] intArr = new int[]{123, 4, 56, 90};
		//第一种使用String的api
		/*
		String str = "";
		
		for (int x = 0; x < intArr.length; x++) {
			str += intArr[x];
		}
		System.out.println(str);
		*/
		//第二种使用StringBuilder的api
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < intArr.length; x++) {
			sb.append(intArr[x]);
		}
		System.out.println(sb.toString());
		
	}
	public static void method_replace() {
		StringBuffer sb = new StringBuffer("abC");
		sb.append(123).append(true);
		System.out.println(sb.replace(1, 3, "wahaha"));
	}
	
	public static void method_reverse() {
		StringBuffer sb = new StringBuffer("abC");
		sb.append(123).append(true);
		System.out.println(sb.reverse().toString());
	}
	
	public static void method_get() {
		StringBuffer sb = new StringBuffer("abC");
		sb.append(123).append(true);
//		char ch = sb.charAt(2);
//		System.out.println(ch);
		char[] chs = new char[4];
		sb.getChars(2, 5, chs, 1);
//		System.out.println(sb.toString());
		for (int i = 0; i < chs.length; i++) {
			System.out.println("chs[" + i + "] = " + chs[i] + "...");
		}
	}
	
	public static void method_upd() {
		StringBuffer sb = new StringBuffer("abc");
		sb.append(123).append(true);
		sb.setCharAt(2, '2');
		System.out.println(sb.toString());
	}
	
	public static void method_delete() {
		StringBuffer sb = new StringBuffer("abc");
		sb.append(123).append(true);//abc123true
//		sb.delete(6, 5);
		sb.deleteCharAt(10);
		
		System.out.println(sb.toString());
	}
	public static void method_add() {
		StringBuffer sb = new StringBuffer("abc");
//		StringBuffer sb1 = sb.append("bcc");
//		System.out.println(sb.toString());//abc
//		System.out.println(sb1.toString());//abcbcc
		//编程链
		sb.append(123).append(true).insert(3, "qq");
		sb.insert(0, new char[]{'x','y','z'}, 1, 1);
		System.out.println(sb.toString());
	}
	
	public static StringBuffer deleteCharAt(StringBuffer sb, int index) {
		sb.delete(index, index+1);
		return null;
	}
}
