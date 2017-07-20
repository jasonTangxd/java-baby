package com.xiaoxiaomo.day13.set;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * set：set集合中的数据没有顺序（存入的顺序和取出后的顺序没有关系），没有重复的元素
 * 		只能使用Iterator的方式来遍历其中的元素
 *  |--HashSet：底层是有哈希表hash表来维护，
 *  |--TreeSet：
 */
public class SetDemo {

	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("java01");
		set.add("java02");
		set.add("java02");
		set.add("java03");
		set.add("java04");
		set.add("java04");
		
		sop(set);
	}
	
	public static void sop(Collection col) {
		Iterator it = col.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
