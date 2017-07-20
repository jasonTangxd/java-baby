package com.xiaoxiaomo.day14.treeset;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *要求：给定一堆字符串，按照字符串的长度进行排序（升序）
 *	如果长度相同，按照自然顺序进行排序
 *Collecion 
 *	|--List：可以重复且有序
 *		|--ArrayList:数组；查询快，增删慢；线程不安全，jdk1.2
 *		|--LinkedList：链表，查询慢，增删快；线程不安全；jdk1.2
 *		|--vector：数组，查询慢，增删慢；线程安全，jdk1.0
 *	|--Set：元素无序且不重复
 *		|--HashSet：hash表；如果判断元素的唯一性：
 *				比较它的hashCode，如果hashCode值相等，
 *				==》equals，是否返回true
 *				true？==》认为是同一个元素，不存
 *				false？==》不是同一个元素，存入
 *		|--TreeSet：二叉树，是一个有序的set，这个顺序默认是自然顺序
 *			有两种比较的方式：
 *				元素具备比较性，需要实现Comparable接口，复写compareTo（obj）方法
 *				集合具备比较性：需要再集成创建的时候，指定相应的比较器
 *				推荐大家使用第二种的前提下，看我们的具体的业务需求
 *				执行顺序：当集合和其中的元素都具备比较性的时候，会优先使用集合的比较器。
 *	 
 */
public class TreeSetTest {

	public static void main(String[] args) {
		TreeSet ts = new TreeSet(new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				String s1 = (String)o1;
				String s2 = (String)o2;
				int result = s1.length() - s2.length();
//				if(result == 0) {
//					result = s1.compareTo(s2);
//				}
//				return result;
				return result == 0 ? s1.compareTo(s2) : result;
			}
		});
		ts.add("asdf");
		ts.add("asdhe");
		ts.add("atdffff");
		ts.add("Asdf");
		ts.add("bsd");
//		TreeSetDemo.sop(ts);
		
		//LinkedHashSet
		Set set = new LinkedHashSet();
		set.add("asdf");
		set.add("asdhe");
		set.add("atdffff");
		set.add("Asdf");
		set.add("bsd");
		TreeSetDemo.sop(set);
	}
}
