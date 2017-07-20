package com.xiaoxiaomo.day15.map.test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 需求：对"adfafea"进行统计，统计出每个字符在字符串中出现的次数，
	        要求最后的打印结果为a(3)d(1)e(1)f(2)
	  思路：
	    要从字符串中获取两个东西：字符，出现的次数===>每一个字符对应了一个次数
	  字符和次数之间有关系？映射关系
	 当出现有映射关系的时候，咱们就要考虑到使用Map集合，因为有顺序，所以使用TreeMap
	 
	        
	   第一步：将字符串===>字符数组
	   第二步： 需要使用map来保存每一个字符，字符在字符串中出现的次数
	  第三步：就需要对map中的数据进行结果展示
 *
 */
public class MapTest4 {
	
	public static void main(String[] args) {
		String result = method_count("adfafea");
		System.out.println(result);
	}
	
	public static String method_count(String src) {
		char[] chs = src.toCharArray();
		Map<Character, Integer> chsMap = new TreeMap<Character, Integer>();
//		Integer count = 0;
		for (int x = 0; x < chs.length; x++) {
//			Integer value = chsMap.get(chs[x]);
//			if(null == value) {
//				chsMap.put(chs[x], 1);
//			} else {
//				chsMap.put(chs[x], value + 1);
//			}
			/**
			 * 另外一种书写方式
			 */
//			count = 0;
//			count = chsMap.get(chs[x]);
//			if(count == null) {
//				count = 1;
//			} else {
//				count++;
//			}
//			chsMap.put(chs[x], count);
			//简写
			chsMap.put(chs[x], chsMap.get(chs[x]) == null ? 1 : chsMap.get(chs[x]) + 1);
		}
		
		StringBuilder sb = new StringBuilder();
		Set<Map.Entry<Character, Integer>> entrySet = chsMap.entrySet();
		Iterator<Map.Entry<Character, Integer>> it2 = entrySet.iterator();
		while(it2.hasNext()) {
			Map.Entry<Character, Integer> me = it2.next();
			char ch = me.getKey();
			int count = me.getValue();
			sb.append(ch + "(" + count + ")");
		}
		return sb.toString();
	}
	
}
