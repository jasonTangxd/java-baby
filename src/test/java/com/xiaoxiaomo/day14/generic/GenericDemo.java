package com.xiaoxiaomo.day14.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericDemo {

	public static void main(String[] args) {
		
		/**
		 * JDK1.5提供了一个新技术来帮助我们解决这种集合类型转化遇到的错误。
		 * 用一对儿<>写入我们要规范，或者说规定要往我们的集合中存入元素的类型
		 * new ArrayList<Person>()这句话的意思是说我创建了一个只能存入Person及其子类的集合
		 * 这种技术就叫做泛型：广泛的类型
		 * 这样做的好处？
		 * 	1、我们的可能会发生的异常有运行阶段，转移到了编译阶段，这样的话就可以提早通知我们coder
		 * 来解决问题，减少了程序在运行阶段会出现的异常
		 *  2、避免了我们需要对元素进行强制类型转化
		 * 为什么要这样做呢？我们的jdk为什么要这样升级呢？
		 * 我们的泛型要解决的问题是安全问题
		 */
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("abcb");
		list.add("abcde");
		list.add("abcdef");
//		list.add(4);//list.add(new Integer(4));自动装箱
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str + "的长度是：" + str.length());
		}
	}
	
	public static void method1() {
		
		int[] array = new int[3];
		array[0] = 5;
//		array[1] = 6.5;//精度损失
		
		List list = new ArrayList();
		list.add("abc");
		list.add("abcb");
		list.add("abcde");
		list.add("abcdef");
		/**
		 * 在编译的时候没有出现异常，在运行的时候产生了ClassCastException: Integer cannot be cast to String
		 * 是因为我们的集合中存在多种数据类型的元素，而我们都按照了String的api来操作，报了类型转化异常
		 * 参考数组的定义，如果我们的集合在定义的时候也想数组一样指定了要存入元素的数据类型，就可以避免这种ClassCastException
		 * 那么我们的jdk，在1.5的时候就帮我们来解决了这个问题，什么问题呢？
		 * 
		 */
		list.add(4);//list.add(new Integer(4));自动装箱
		Iterator it = list.iterator();
		while(it.hasNext()) {
			String str = (String)it.next();
			System.out.println(str + "的长度是：" + str.length());
		}
	}
}
