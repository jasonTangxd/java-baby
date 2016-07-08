package com.xxo.day14.generic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class GenericDemo5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		method_set_string();
	}
	public static void method_set_string() {
		Set<String> treeSet = new TreeSet<String>();
		treeSet.add("Abb");
		treeSet.add("aaa");
		treeSet.add("aba");
		treeSet.add("abdd");
		sop(treeSet);
		System.out.println("--------------------");
		Set<Integer> ts = new TreeSet<Integer>();
		ts.add(1234);
		ts.add(12345);
		ts.add(12346);
		sop(ts);
	}
	
	public static <T> void sop(Collection<T> col) {
		Iterator<T> it = col.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
