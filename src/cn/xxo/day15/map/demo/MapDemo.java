package cn.xxo.day15.map.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 	Collection<E>
	--->是一个单列的集合
	------------------------
 * Map<K, V>
	map中需要存放两个元素
	一个是K：Key-->键
	一个是V：Value--->Value
	----->map是一个双列的集合
	每一个K和V之间存在着关系：映射关系
	Map的特点：
		map的每一个对元素都是以键值对儿的形式存在的。map中的键是唯一的，只能通过键来唯一的获取值。
	Map中的常用的方法：
		1、增
			put(K key, V value) 
			putAll(Map<? extends K,? extends V> m) 
		2、删
			clear();
			V remove(Object key):移除掉Key对应的键值对，返回Key对应的Value 
		3、改
			put(K key, V value) 
		4、查
			get(Object key) 
			int size()；
			values();
			--------------
			entrySet() *****
			keySet() *****
		5、判断：
			containsKey(Object key) 
			containsValue(Object value)
		 	isEmpty() 
		常用的子类
		----HashTable:底层的数据结构是哈希表，K-V不可以存在null值，Hashtable是同步的 ，效率低，jdk1.0
		----HashMap:底层的数据结构是哈希表，K-V可以存在null值，HashMap是不同步的 ，效率高，jdk1.2
		----TreeMap:底层的数据结构是二叉树，如果要对我们的map进行排序，就是使用treemap，是按照我们的映射关系中的key来进行排序
 *
 */
public class MapDemo {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		//添加元素
		/**
		 * put的返回值为老版本K对应的V，如果是第一次存入，那么返回值为null
		 */
		System.out.println("1返回值=" + map.put(1, "zs"));
		System.out.println("2返回值=" + map.put(1, "zs007"));
		System.out.println("3返回值=" + map.put(2, "lisi"));
		System.out.println("4返回值=" + map.put(2, "lisi110"));
		map.put(3, "wangwu");
		map.put(4, "zhaoliu");
		
		//打印map集合 打印格式为{K1=V1, K2=V2,...Kn=Vn}
		System.out.println(map);
		//通过get(key)来获取key对应的value 当我们的key对应的值不存在，那么也就是说map当中没有这个KV对儿，返回为null
		String v1 = map.get(5);
		System.out.println("v1=" + v1);
		//判断containsXxx() 判断K或者V中是否存在对应的键或者值，返回值为true|false
		System.out.println(map.containsKey(2));
		System.out.println(map.containsKey(6));
		System.out.println(map.containsValue("wangwu"));
		System.out.println(map.containsValue("zhouqi"));
		//删除元素 remove 删除的时候返回值为K对应的V，如果K不在map中，不会抛异常，返回值为null
		String removed = map.remove(5);
		System.out.println("removed =" + removed);
		
		//获取所有的值values(); 值的注意的是values的返回值类型为Collection<V>
		Collection<String> col = map.values();
		System.out.println(col);
		
	}
}
