package com.xxo.day15.utils;

import java.util.Arrays;
import java.util.List;

public class Array2CollectionTest {

	public static void main(String[] args) {
		/**
		 * 使用引用数据类的数组转换成为一个list集合
		 */
//		String[] arr = {"zhangsan", "lisi","wangwu"};
//		System.out.println(Arrays.toString(arr));//以后数组打印使用Arrays.toString()方法
//		List<String> list = Arrays.asList(arr);
//		System.out.println(list);
		/**
		 * 基本数据类型的数组转换为成list,eg.int[]
		 * 泛型要使用相应的基本数据类型数组,eg.List<int[]>
		 * 所以大家在要操作数组转集合的时候尽量使用引用行数据类型的数组
		 * 需要大家注意的是：数组转集合的时候，不能对集合进行增删操作，因为UnsupportedOperationException
		 */
		int[] arr1 = {1, 2, 3};
		List<int[]> list1 = Arrays.asList(arr1);
		System.out.println(list1);//[I@33abb81e
		Integer[] a = {1, 2, 3};
//		System.out.println(Arrays.asList(a));
		List<Integer> iList = Arrays.asList(a);
		iList.add(12);//UnsupportedOperationException
		System.out.println(iList);
	}
}
