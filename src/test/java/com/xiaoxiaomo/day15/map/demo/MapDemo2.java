package com.xiaoxiaomo.day15.map.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map中的两种取出元素的方式
 * ---- Set<K> keySet:
 * 		获取map中的所有的key组成一个集合Set，通过我们Set来进行操作，得到Iterator，迭代每一个元素(Key),然后在通过
 * 		map.get(Key)获得对应的value
 * ----Set<Map.Entry<K,V>> entrySet:获取map中所有的k-v的映射关系==》Set,通过我们Set来进行操作，
 * 	得到Iterator，迭代器的每一个元素都是一个映射关系的实例，通过实例提供的api（getKey,getValue）来获取我们map
 * 	中的每一对儿键值对儿
 *
 */
public class MapDemo2 {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		//添加元素
		map.put(1, "zs1");
		map.put(2, "lisi");
		map.put(3, "wangwu");
		map.put(4, "zhaoliu");
		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<Integer, String>> it = entrySet.iterator();
		while(it.hasNext()) {
			Map.Entry<Integer, String> me = it.next();
			Integer key = me.getKey();
			String value = me.getValue();
			System.out.println("key=" + key + ", value=" + value);
		}
	}
	
	/**
	 * 第一种取出所有元素的方式
	 */
	public static void methodKeySet(Map<Integer, String> map) {
	
		//step1、获取key对应的一个集合
		Set<Integer> keySet = map.keySet();
		//step2、获得keySet对应的迭代器
		Iterator<Integer> it = keySet.iterator();
		//step3、迭代每一个元素
		while(it.hasNext()) {//判断是否有下一个元素
			//3.1、获取每一个key
			Integer key = it.next();
			String value = map.get(key);
			System.out.println("key=" + key + ", value=" + value);
		}
	}
}

/**Map.Entry说明
public interface Map<K, V> {
	public static interface Entry<K, V> {
		K getKey();
		V getValue();
	}
}

public class HashMap<K, V> {
	static class Entry<K, V> {
		public K getKey() {
			.....
		}
		public V getValue() {
			.....
		}
	}
}
*/