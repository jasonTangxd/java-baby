package cn.xxo.day15.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 集合转变为数组
 *
 */
public class Collection2ArrayTest {
	public static void main(String[] args) {
		/**
		 * 集合2数组的时候需要注意指定的数组长度：
		 * 如果指定的数组长度比集合的size小，在内部重新创建了一个size大小的数组，把元素放到了数组里面，并且返回
		 * 如果指定的数组长度比集合的size大，不会再创建一个数组，超过size范围的数组元素置为null
		 * 以上都对空间有点浪费
		 * 建议大家以后指定的时候，对数组的大小设置为：集合的size，刚刚好
		 * 
		 * 为什么要让集合转变为数组：
		 * 	  主要是为了防止对我们集合进行增删
		 */
		List<String> list = new ArrayList<String>();
		list.add("zhangsan");
		list.add("lisi");
		list.add("langwang");
		list.add("zhaoliu");
		String[] strArr = list.toArray(new String[list.size()]);
//		for (int i = 0; i < strArr.length; i++) {
//			System.out.print(strArr[i] + "\t");
//		}
		System.out.println(Arrays.toString(strArr));
	}
}
