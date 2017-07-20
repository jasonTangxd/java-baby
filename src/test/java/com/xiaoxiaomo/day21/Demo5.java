package com.xiaoxiaomo.day21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * 获取
 * 原始字符串
 * jahs122jshdjs1232
 * 
 * 
 * 获取字符串中的所有数字
 * 
 * 页面下载成功.url:[{http://www.xxo.cn}].耗时[{10000}]毫秒.当前时间戳:[{13623283723}]
 * 
 * 页面下载成功.url:[{}].耗时[{}]毫秒.当前时间戳:[{}]
 * @author xiaoxiaomo
 *
 */
public class Demo5 {
	/**
	 * aa1234bb7672cc
	 * aa3333bb2233cc
	 * aa334bb554cc
	 * @param args
	 */
	public static void main(String[] args) {
//		String log = "页面下载成功.url:[{http://www.xxo.cn/shkjjk}].耗时[{10000}]毫秒.当前时间戳:[{13623283723}]";
//
//		Pattern compile = Pattern.compile("^页面下载成功\\.url:\\[\\{(.+)\\}\\]\\.耗时\\[\\{([0-9]+)\\}\\]毫秒\\.当前时间戳:\\[\\{([0-9]+)\\}\\]$");
//		Matcher matcher = compile.matcher(log);
//		if(matcher.find()){
//			System.out.println(matcher.group(1));
//			System.out.println(matcher.group(2));
//			System.out.println(matcher.group(3));
//		}

		test1();
	}
	private static void test2() {
		String str = "aa1234bb7672cc";
		
		//1：对指定规则进行编译，获取一个模式对象
		Pattern compile = Pattern.compile("aa(\\d+)bb([0-9]+)cc");
		//2：使用这个模式对字符串进行匹配,返回一个匹配的对象
		Matcher matcher = compile.matcher(str);
		//3：使用这个macher对象，可以具体的进行匹配操作，然后获取匹配的结果
		if(matcher.find()){
			String group = matcher.group();
			String group2 = matcher.group(0);//和不传参数一样，都是获取整个正则表达式匹配的内容
			String group3 = matcher.group(1);//获取正则表达式中第一个正则组的内容
			String group4 = matcher.group(2);//.......
			System.out.println("group:"+group);
			System.out.println("group2:"+group2);
			System.out.println("group3:"+group3);
			System.out.println("group4:"+group4);
			
			
		}
	}

	private static void test1() {
		String str = "jahs122jshdjs1232jsdjka1122";
		
		//1：对指定规则进行编译，获取一个模式对象
		Pattern compile = Pattern.compile("[0-9]+");
		//2：使用这个模式对字符串进行匹配,返回一个匹配的对象
		Matcher matcher = compile.matcher(str);
		//3：使用这个macher对象，可以具体的进行匹配操作，然后获取匹配的结果
		while(matcher.find()){
			String group = matcher.group();
			System.out.println(group);
		}
		/*//4：表示进行一次匹配
		boolean find2 = matcher.find();
		System.out.println(find2);
		//5：获取到匹配的结果
		String group1 = matcher.group();
		System.out.println(group1);*/
	}
	
	

}
