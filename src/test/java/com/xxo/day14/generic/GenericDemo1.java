package com.xxo.day14.generic;

import com.xxo.day14.treeset.TreeSetDemo;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 重写上午的练习：按照字符串的长度进行排序，如果长度相等，按照字符串的自然顺序排序
 * 要求：使用泛型 
 * 以后大家在写的时候，要求尽量使用泛型
 * *** 通常我们在操作集合的时候，都会使用到泛型
 */
public class GenericDemo1 {

	public static void main(String[] args) {
//		Set<String> set = new TreeSet<String>(new MyComparator());
		Set<String> set = new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				int result = new Integer(str1.length()).compareTo(new Integer(str2.length()));
				if(result == 0) {
					result = str1.compareTo(str2);
				}
				return result;
			}
		});
		
		set.add("abc");
		set.add("abcd");
		set.add("abcde");
		set.add("abce");
		set.add("abcdd");
		TreeSetDemo.sop(set);
	}
}

class MyComparator implements Comparator<String> {

	@Override
	public int compare(String str1, String str2) {
		int result = new Integer(str1.length()).compareTo(new Integer(str2.length()));
		if(result == 0) {
			result = str1.compareTo(str2);
		}
		return result;
	}
}
