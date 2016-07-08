package com.xxo.day21;


/**
 * 手机号：
 * 1:11位
 * 2：1开头
 * 3：第二位只能是3 或者8或者5
 * @author xiaoxiaomo
 *
 */
public class Demo2 {
	
	
	public static void main(String[] args) {
		
		//匹配功能
		String telphone = "17612345678";
		String regex = "1[358][0-9]{9}";
		boolean flag = telphone.matches(regex);
		System.out.println(flag);
		
		
		String str = "heheeeeeeeeeee";
		String regex1 = "hehe+";
		boolean matches = str.matches(regex1);
		System.out.println(matches);
	}

}
