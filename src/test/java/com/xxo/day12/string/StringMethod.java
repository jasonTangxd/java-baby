package com.xxo.day12.string;

public class StringMethod {

	public static void main(String[] args) {
//		method_pd();
//		method_replace();
//		method_transform();
		method_split();
	}

	/**
	 * 判断
	 * 	1、boolean isEmpty() 判断字符串内容是否为空
	 *  2、boolean contains(String subStr) 判断字符串中是否包含其它子串
	 *  3、boolean startsWith(String subStr) 判断字符串中以substr开头
	 *  3、boolean endsWith(String subStr) 判断字符串中以substr结尾
	 * 获取
		2.1 int length()
			获取字符串的长度。
		2.2 char charAt(index)
			根据指定的位置获取该位置对应的字符。
		2.3 int indexOf(ch) 
			根据字符获取该字符第一次出现的位置
			int idnexOf(ch,fromIndex)
				从fromIndex位置开始获取ch第一次出现的位置。
			找到了就返回第一次出现角标位，没找到，就返回-1.所以，
			可以通过-1这种方式判断一个字符是否在字符串存在。
		2.4 int indexOf(string)
			根据字符串获取该字符串第一次出现的位置
			int idnexOf(string,fromIndex)
				从fromIndex位置开始获取string第一次出现的位置。
			找到了就返回第一次出现角标位，没找到，就返回-1.所以，
			可以通过-1这种方式判断一个字符串是否在字符串存在。这既是contains方法原理。
		2.5 同样是获取一个字符或者字符串第一次出现的位置，但是是通过反向索引完成。
			功能和indexOf一致。
			int lastIndexOf(ch);
			int lastIdnexOf(ch,fromIndex):
			int lastIndexOf(string);
			int lastIdnexOf(string,fromIndex):
		2.6 获取字符串中的一部分字符串。
			String substring(start):从start开始到结尾。
			String substring(start,end);获取到的字符串包含start位，不包含end位。[,)
	 * 替换
			3.1 替换字符。
				String replace(oldChar,newChar):
			3.2 替换字符串
				String replaceAll(string,string);
	 * 比较
	 * 	equals()
	 * 转化
	 * 		5.1 将字符串转成字节数组。
				byte[] getBytes():编码解码时较为常用。还有在io流操作字节数据也很常用。
			5.2 将字符串转成字符数组。
				char[] toCharArray():
			5.3 将字符数组或者数组中的一部分转成字符串。
				static String copyValueOf(char[])
			5.4 将字符数组或者数组中的一部分转成字符串。
				static String valueOf(char[]):
			5.5 基本数据类型变成字符串------了解。
				static String valueOf(int);
				static String valueOf(double);
				static String valueOf(boolean);
				...
				int x = 3;
				String.valueOf(x);--> "3";
				x+""--> "3";
			5.6 将对象变成字符串----------了解。
				static String valueOf(object);
				和object.toString():结果是一样的。
			5.7 将字符串转成大写或者小写。
				小写：toLowerCase():
				大写：toUpperCase():
				https://www.xxo.cn
			切割：
				String[] split(regex)
				abc,bac,cab,haha
	 */
	public static void method_split() {
//		String str = "abc,bac,cab,haha";
		String str = "www.xxo.cn";
		String[] split = str.split("\\.");
		System.out.println(split.length);
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
		}
	}
	public static void method_transform() {
		String str = "abc";
//		byte[] bytes = str.getBytes();
		char[] chs = str.toCharArray();
		for (int i = 0; i < chs.length; i++) {
			System.out.println(chs[i]);
		}
		String val = str.valueOf(chs);
		System.out.println(val);
		String uc = str.toUpperCase();
		System.out.println(uc);
	}
	public static void method_replace() {
		String str = "woaidajiamemeda";
		System.out.println(str.replace('m', 'n'));
		System.out.println(str.replaceAll("meme", "mengmeng"));
	}
	
	public static void method_get() {
		String str = "woaidajiamemeda";
//		System.out.println(str.length());
//		System.out.println(str.charAt(2));
//		System.out.println(str.indexOf('j'));//6
//		System.out.println(str.indexOf("ia"));//7
//		System.out.println(str.indexOf('a', 3));//5
//		System.out.println(str.lastIndexOf('m'));//11?
//		System.out.println(str.lastIndexOf("da"));//13
//		System.out.println(str.lastIndexOf("em", 8));//-1
		System.out.println(str.substring(3));
		System.out.println(str.substring(3,5));
	}
	
	public static void method_pd() {
		String str = "woaidajiamemeda";
		System.out.println(str.isEmpty());
		System.out.println(str.contains("meme"));
		System.out.println(str.startsWith("aini"));
		System.out.println(str.endsWith("da"));
		
	}
}
