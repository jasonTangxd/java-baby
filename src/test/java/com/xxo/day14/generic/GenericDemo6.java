package com.xxo.day14.generic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class GenericDemo6 {

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
		sos(treeSet);
		System.out.println("--------------------");
		Set<Integer> ts = new TreeSet<Integer>();
		ts.add(1234);
		ts.add(12345);
		ts.add(12346);
		sos(ts);
	}
	
	public static <T> void sop(Collection<T> col) {
		Iterator<T> it = col.iterator();
		while(it.hasNext()) {
			T t = it.next();
			System.out.println(t);
		}
	}

	/**
	 * 我们也可以使用？（通配符）来完成上面方法sop的功能，
	 * 不同之处在于我们无法使用？来接收it.next()的返回值
	 * 而且也不用在static方法上面进行<T>声明了，这种方式的书写要比上面简便一点
	 * ？在那种场合下会使用的多一些呢？
	 * 	在我们的泛型限定中经常来使用？通配符
	 * @param col
	 */
	public static void sos(Collection<?> col) {
		Iterator<?> it = col.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
