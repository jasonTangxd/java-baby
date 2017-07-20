package com.xiaoxiaomo.day21;

/**
 * 判断给定的字符串是不是合法的QQ号
 * 132277282
 * 
 * 
 * 要求：
 * 1：不能以0开头
 * 2：QQ号的长度在5~12位之间
 * 3：只能是数字
 * @author xiaoxiaomo
 *
 */
public class Demo1 {
	
	public static void main(String[] args) {
		String str = "6a43786437";
		String regex = "[1-9][0-9]{4,11}";//正则表达式
		boolean flag = str.matches(regex);
		System.out.println(flag);
	}

	private static void test() {
		String str = "0643786437";
		if(!str.startsWith("0")){
			if(str.length()>=5&&str.length()<=12){
				try {
					Integer.parseInt(str);
					System.out.println("合法的QQ号："+str);
				} catch (NumberFormatException e) {
					System.err.println("非法QQ号：包含字母或者特殊字符");
				}
			}else{
				System.err.println("非法QQ号：长度非法！");
			}
		}else{
			System.err.println("非法QQ号：不能以0开头！");
		}
	}

}
