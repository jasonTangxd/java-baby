package com.xiaoxiaomo.day13.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Collection
 *  |--List:可以存放有序的对象，并且对象可以重复
 *  	|--ArrayList:底层实现是数组，查询效率要高（因为有索引下标），线程不安全，jdk1.2，增长是50%
 *  	|--vector:底层实现也是数组，线程安全，所以查询效率要比ArrayList要低，jdk1.0出现
 *  		使用ArrayList来对我们的vector进行了升级，所以建议大家使用ArrayList；100%增长
 *  	|--LinkedList:底层实现是链表，查询效率要比ArrayList低
 *  	ArrayList查询快，增删慢
 *  	LinkedList查询慢，增删快
 *  	Vector：两个都慢
 *  一定要清楚ArrayList和LinkedList的底层原理 
 *  |--Set:存放的元素是没有顺序的，元素不能重复
 * 
 *
 */
public class ListDemo {

	/**
	 * 增
	 * void add(index, obj):在index为加入一个obj
	 * boolean addAll(index, Collection)：将collection在index位置加入
	 * 删
	 * Object remove(index):移除列表中指定位置的元素
	 * 改
	 * set(index, obj)将index位置的元素替换为obj
	 * 查
	 * get(index):获取index位置上的元素
	 * listIterator:获取迭代
	 * int indexOf(obj):返回此列表中第一次出现的指定元素的索引；如果此列表不包含该元素，则返回 -1。
	 * lastIndexOf(obj):返回此列表中第后次出现的指定元素的索引；如果此列表不包含该元素，则返回 -1。
	 * List subList(start, end):返回区间[start, end)之间的元素集合
	 */
	public static void main(String[] args) {
		methodIterator();
	}
	/**
	 * NoSuchElementException:没有元素异常
	 * 注意：以后在遍历集合的时候，再循环体内部尽量不要进行多次next,previous操作，
	 * 因为有可能会出现NoSuchElementException
	 */
	public static void methodIterator() {
		List list = new ArrayList();
		list.add("java01");
		list.add("java02");
		list.add("java03");
		list.add("java01");
		list.add("java01");
		Iterator li = list.iterator();
		while(li.hasNext()) {
			System.out.println(li.next());
			System.out.println(li.next());
		}
	}
	
	
	public static void method_listIterator() {
		List list = new ArrayList();
		list.add("java01");
		list.add("java02");
		list.add("java03");
		list.add("java01");
		
		ListIterator li = list.listIterator();
		while (li.hasNext()) {
			int index = li.nextIndex();
			System.out.println(li.next());
			if(index == 2) {
//				li.add("王庆阳");
				/**
				 * 如果使用的next，修改的是修改的是上一个返回的结果
				 * 如果使用的previous，修改的是修改的是后一个返回的结果
				 * 这和我们是否调用了next()或者previous()方法的顺序有关系
				 */
				li.set("讲师");
			}
		}
		System.out.println(list);
		System.out.println("-------------------------");
//		while(li.hasPrevious()) {
//			System.out.println(li.previous());
//		}
			
	}
	
	public static void get() {
		List list = new ArrayList();
		list.add("java01");
		list.add("java02");
		list.add("java03");
		list.add("java01");
		
		List subList = list.subList(1, 3);
		System.out.println(subList);
		/**
		 * 取元素的角标
		 */
//		int index = list.lastIndexOf("java01");
//		System.out.println(index);
		/**
		 * 使用for遍历我们list中的元素
		 */
//		System.out.println(list.get(2));
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		
		
	}
	
	
	
	public static void update() {
		List list = new ArrayList();
		list.add("java01");
		list.add("java02");
		list.add("java03");
		list.add("java01");
		
		System.out.println("修改前的List:" + list);
		list.set(2, "冯尚");
		System.out.println("修改后的List:" + list);
	}
	
	public static void del() {
		List list = new ArrayList();
		list.add("java01");
		list.add("java02");
		list.add("java03");
		list.add("java01");
		Object remove = list.remove(3);
		System.out.println("移除的元素" + remove);
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	/**
	 * //list中的元素是允许重复的，因为他们每一个元素都是找的对应的index
	 * ArrayList的底层数据结构是数组
	 * 自己玩一下addAll(index, collection)
	 */
	public static void add() {
		List list = new ArrayList();
		list.add("java01");
		list.add("java02");
		list.add("java03");
		list.add("java01");
		
		list.add(2, "java04");
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
}
