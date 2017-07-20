package com.xiaoxiaomo.day13.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 要求：取出ArrayList当中的重元素(字符串为例)
 *
 */
public class ArrayListTest1 {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("xxo01");
		list.add("xxo01");
		list.add("xxo03");
		list.add("xxo02");
		list.add("xxo03");

		
		System.out.println("去重前的集合：" + list);
		list = singleElement(list);
		System.out.println("去重后的集合：" + list);
		
	}
	
	public static List singleElement(List oldList) {
		List newList = new ArrayList();
		Iterator it = oldList.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			if(!newList.contains(obj)) {
				newList.add(obj);
			}
		}
		return newList;
	}

//	public static void sop(List list) {
//		Iterator it = list.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
//	}
}
