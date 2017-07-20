package com.xiaoxiaomo.day15.jdknew;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * jdk1.5之后出现的新特性——高级for循环，增强for循环
 * foreach语句的书写格式：
 * for(数据类型 变量名 : 要进行遍历的(Collection)集合或者数组) {
 *    获取变量，然后进行操作 
 * }
 * 要能够使用foreach，对象需要实现Iterable接口
 * 实际上foreach底层就是使用iterator来做的，只不过简化了我们的书写
 * foreach和我们的迭代器有啥区别？
 * 	实际上foreach底层就是迭代器来做的，只不过是为了简化书写
 * foreach和我们普通for循环有啥区别？
 * 	foreach无法操作角标，
 *  普通for循环是可以进行操作角标，
 *  如果在遍历的过程中需要用到角标或者需要++/--的操作，那么建议使用普通的for循环；反之，能用foreach就用foreach
 */
public class ForeachDemo {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "zs");
		map.put(2, "lisi");
		map.put(3, "zs007");
		map.put(4, "lisi110");
		Set<Integer> keySet = map.keySet();
//		Iterator<Integer> it = keySet.iterator();
//		while(it.hasNext()) {
//			Integer key = it.next();
//			String value = map.get(key);
//			System.out.println(key + ":" + value);
//		}
		//使用foreach替代上述
		for(Integer key : keySet) {
			System.out.println(key + ":" + map.get(key));
		}
		System.out.println("--------------");
		for(Integer key : map.keySet()) {
			System.out.println(key + ":" + map.get(key));
		}
		System.out.println("=======entrySet的foreach=======");
		for(Map.Entry<Integer, String> me : map.entrySet()) {//以后就用这种遍历方式
			Integer key = me.getKey();
			String value = me.getValue();
			System.out.println(key + ":" + value);
		}
	}
	
	public static void method_foreach() {
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("abcd");
		list.add("abcde");
		list.add("abce");
		list.add("abcdd");
//		Iterator<String> it = list.iterator();
//		while(it.hasNext()) {
////			String str = it.next();
//			String str = "aaaqa";
//			System.out.println(str);
//		}
//		System.out.println("-------------");
//		for(String str : list) {
//			str = "adfasdf";
////			System.out.println(str);
//		}
		System.out.println(list);
		int[] a = {1, 3, 4};
		for(int arr : a) {
			System.out.println(arr);
		}
	}
}