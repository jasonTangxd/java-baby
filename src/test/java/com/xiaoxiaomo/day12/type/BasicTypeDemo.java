package com.xiaoxiaomo.day12.type;

public class BasicTypeDemo {

	/**
	 * java中的基本数据类型有4类8种
	 * byte-------Byte
	 * short------Short
	 * char-------Character
	 * int--------Integer
	 * long-------Long
	 * float------Float
	 * double-----Double
	 * boolean----Boolean
	 * 
	 * java中常见的5个异常：
	 * 	NumberFormatException
	 *  NullPointerException
	 *  IndexOutOfBoundsException
	 *  ClassNotFoundException
	 *  OutOfMemoryError
	 *  RuntimeException
	 */
	public static void main(String[] args) {
//		Integer x = -128;
//		Integer y = -128;
//		System.out.println(x == y);
//		Integer m = -129;
//		Integer n = -129;
//		System.out.println(m == n);
		test();
		/*
		 * 从-128~127这个区间内的数字一旦被创建之后，下一次再创建相同的对象的时候，不会再创建新的对象，只是对原来对象的一个引用
		 * 或者说是我们1个byte的范围
		 */
	}
	
	/**
	 * 将一个数字整型的字符串"1234567"转化为int类型的数字
	 * 	要求：不要使用Integer的相关API
	 */
	public static void test() {
		String str = "1234567";
		char[] chs = str.toCharArray();
		int sum = 0;
		for (int i = 0; i < chs.length; i++) {
			int temp = chs[i] - '0';;
//			sum += temp * (new Double(Math.pow(10, chs.length - i - 1)).intValue());
			sum = sum * 10 + temp;
		}
		System.out.println(sum);
	}
	
	
	public static int getIntFromString(String str){
		
		return 0;
	}
	
	
	
	
	public static void methodInteger() {
		Integer i = new Integer("6");
//		System.out.println(i.floatValue());
		System.out.println(Integer.toBinaryString(6));
		System.out.println(toBinary(6));
		int i1 = Integer.parseInt("12345678");
		Integer i2 = Integer.valueOf("12345678");
		System.out.println(i1 == i2);//进行了自动拆箱
	}
	/**
	 * 作业：1、自己手动写一个讲int类型的数字转化为16进制的字符串
	 */
	
	/**
	 * 自己手写一个将int类型的数字转换成二进制的字符串
	 * @param src
	 * @return
	 */
	public static String toBinary(int src) {

		StringBuilder sb = new StringBuilder();
		while(src != 0) {
			sb.append(src%2);
			src = src / 2;
		}
		return sb.reverse().toString();
	}
	
	
	
	public static void method_cx() {
		String intStr = "1234567890";
		Integer integer = Integer.valueOf(intStr);
		integer = integer + 1; //第一步讲integer转化为基本的数据类型1234567890，然后和1进行的"+"运算，得到的是基本的数据类型:自动拆箱
							   //第二步：把得到的基本数据类型赋值给了引用数据类型，这个过程我们称之为自动装箱
		System.out.println(integer); 
		
		Integer i = 4;//自动装箱
		int a = new Integer(5);//自动拆箱
	}
}
