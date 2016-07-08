package com.xxo.day15.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections中的二分查找
 * 二分查找的前提条件是：要查找的集合是有序的。
 * 通过短点或者单步调试，在需要相应调试的位置，双击打断点，然后，使用Debug runas
 * 
 * -------
 * 建议大家以后在工作的过程是尽量使用线程不安全集合（因为效率高），考虑到是在多线程中进行运算，
 * 那么这个时候只需要使用Collections.synchxxxxx(Collection|map)就可以获得一个线程安全的集合
 */
public class CollectionsBinarySearchTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("zhangsan");
		list.add("lisi");
		list.add("langwang");
		list.add("zhaoliu");
		list.add("zhouqi");
		list.add("weiba");
		//
		System.out.println("集合元素：" + list);
		Collections.sort(list);
		System.out.println("排序后的集合：" + list);
		int index = halfSearch(list, "lisi001");
		System.out.println("找到没？" + index);
	}
	
	public static <T extends Comparable<T>> int halfSearch(List<T> list, T key) {
		int start = 0, end = list.size() - 1, mid = -1;
		while(start <= end) {
			mid = (start + end) >> 1;
			int result = list.get(mid).compareTo(key);
			if(result < 0) {
				start = mid + 1;
			} else if(result > 0) {
				end = mid - 1;
			} else {
				return mid;
			}
		}
		return -start - 1;
	}
}
