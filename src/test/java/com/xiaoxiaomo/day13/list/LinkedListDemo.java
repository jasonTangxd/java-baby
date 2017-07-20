package com.xiaoxiaomo.day13.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList底层实现方式是列表。注意，LinkedList线程不安全。
 * addFirst：插入元素到集合的0号角标位置
 * addLast：插入元素到集合末尾
 * 
 * removeFirst：移除集合的第一个元素,同时获得该元素
 * removeLast：移除集合的最后一个元素,同时获得该元素
 * 
 * getFirst ：获取集合的第一个元素,但没有将该元素移除集合外
 * getLast：获取集合的最后一个元素,但没有将该元素移除集合外
 * 
 * -----------------------------
 * offerFirst
 * offerLast
 * 
 * pollFirst
 * pollLast 
 * 
 * pull
 * pop
 * push
 * peekFirst
 * peekLast
 * 
 * 
 *
 */
public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addFirst("张飞翔");
		ll.addFirst("蒋海龙");
		ll.addFirst("刘城桥");
		
		Object obj = ll.getFirst();
		System.out.println(obj);
		System.out.println("---------------");
		sop(ll);
	}
	
	
	public static void del() {
		LinkedList ll = new LinkedList();
		ll.addFirst("张飞翔");
		ll.addFirst("蒋海龙");
		ll.addFirst("刘城桥");
		
		Object obj = ll.removeLast();
		System.out.println(obj);
		System.out.println("-------------");
		sop(ll);
	}
	public static void add() {
		LinkedList ll = new LinkedList();
		ll.addFirst("张飞翔");
		ll.addFirst("蒋海龙");
		ll.addFirst("刘城桥");
//		ll.addFirst("王鹏飞");

//		ll.addLast("张飞翔");
//		ll.addLast("蒋海龙");
//		ll.addLast("刘城桥");
//		ll.addFirst("王鹏飞");
		
		Iterator it = ll.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public static void sop(List list) {
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
