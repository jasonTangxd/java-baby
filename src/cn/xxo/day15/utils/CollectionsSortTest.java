package cn.xxo.day15.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 集合中的排序sort，模拟一下Collections.sort<List<T> list>
 *
 */
public class CollectionsSortTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("zhangsan");
		list.add("lisi");
		list.add("langwang");
		list.add("zhaoliu");
		list.add("zhouqi");
		System.out.println("sort前的list：" + list);
//		Collections.sort(list);
		mySort(list);
		System.out.println("sort后的list：" + list);
	}
	
	public static <T extends Comparable<T>> void mySort(List<T> list) {
		for(int x = 0; x < list.size() - 1; x++) {
			for(int y = x + 1; y < list.size(); y++) {
				if(list.get(x).compareTo(list.get(y)) > 0) {
//					swap(list, x, y);
					Collections.swap(list, x, y);//Collections自带
				}
			}
		}
	}
	
	public static <T> void swap(List<T> list, int x, int y) {
//		T temp = list.get(x);
//		list.set(x, list.get(y));
//		list.set(y, temp);
//	    l.set(i, l.set(j, l.get(i)))
		list.set(x, list.set(y, list.get(x)));//自己去看
	}
}
/**
 * static <T extends Comparable<T>> void sort(List<T>)
 */