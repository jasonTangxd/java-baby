package com.xiaoxiaomo.day14.treeset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


/**
 *Set:是一个无序的元素不可重复的集合 (存入的顺序和取出的顺序，不一定一致)
 *	|--HashSet：底层采用的数据结构是哈希表，如何判断其中元素唯一性呢？
 *				是不是通过元素本身的hashCode返回值，如果hashCode返回值相等？
 *				就要判断元素本身的equals是否返回为true？
 *					true--->不存
 *					false-->存
 *	|--TreeSet：可以对我们Set集合进行排序。
 *			用String做例子，我们发现，这种排序是对字符串进行的自然排序
 *
 */
public class TreeSetDemo2 {

	public static void main(String[] args) {
//		method_comparator();
		TreeSet tst = new TreeSet(new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				Person p1 = (Person)o1;
				Person p2 = (Person)o2;
				int result = p1.getName().compareTo(p2.getName());
				if(result == 0) {
					result = new Integer(p1.getAge()).compareTo(new Integer(p2.getAge()));
				}
				return result;
			}
		});
		tst.add(new Person("zs06", 18));
		tst.add(new Person("zs02", 38));
		tst.add(new Person("zs02", 28));
		tst.add(new Person("zs03", 48));
		tst.add(new Person("zs01", 18));
		tst.add(new Person("zs01", 18));
		sop(tst);
	}
	
	public static void method_comparator() {
//		method_set_string();
		//treeset存入自定义的对象
		/**
		 * treeSet的第二种比较的方式：
		 * 当我们的元素不具备比较性，或者元素自身的比较性不能满足我们业务需求的时候，
		 * 我们这时就哟采用第二种比较的方式——让我们集合具备比较性。
		 * 要说明一点的是：需要再我们集合创建的时候就要指定相应的自定义的比较器Comparator
		 * 要求：
		 * 按照person的姓名进行比较，当姓名相同的时候再按照person进行比较进行比较。
		 * 
		 * 当我们的主要比较条件无法满足比较（分不出大小的时候），我们就需要按照次要条件进行比较了
		 * 记住：当我们的元素和集合都具备了比较性的时候，优先使用集合提供的比较器
		 */
		TreeSet tst = new TreeSet(new MyComParator());
		tst.add(new Person("zs06", 18));
		tst.add(new Person("zs02", 38));
		tst.add(new Person("zs02", 28));
		tst.add(new Person("zs03", 48));
		tst.add(new Person("zs01", 18));
		tst.add(new Person("zs01", 18));
		/**
		 * zs01 === 18
		 * zs02 === 28
		 * zs02 === 38
		 * zs03 === 48
		 * zs06 === 18
		 */
		sop(tst);
	}
	
	public static void method_set_string() {
		TreeSet treeSet = new TreeSet();
		treeSet.add("Abb");
		treeSet.add("aaa");
		treeSet.add("aba");
		treeSet.add("abdd");
		
		sop(treeSet);
	}
	
	public static void sop(Collection col) {
		Iterator it = col.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}

class Person implements Comparable{
	
	private String name;
	private int age;
	public Person() {
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + "====" + age;
	}
	@Override
	public int compareTo(Object obj) {
		if(obj == null) {
			throw new RuntimeException("没有对象你比较个锤子~");
		}
		if(!(obj instanceof Person)) {
			throw new RuntimeException("不是同一种类型，你比较个鸟啊~");
		}
		Person p = (Person)obj;
		System.out.println(this.name + "------compareTo-----" + p);
//		if(this.age - ybf.age > 0) {
//			return 1;
//		} else if(this.age - ybf.age < 0) {
//			return -1;
//		}
		//先决判断条件
		int num = this.age - p.age;
		//
		if(num == 0) {
			System.out.println(this.name + "------compareTo1-----" + p);
			num = this.name.compareTo(p.name);
		}
		return num;
	}
}

class MyComParator implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
//		Person p1 = (Person)o1;
//		Person p2 = (Person)o2;
//		int result = p1.getName().compareTo(p2.getName());
//		if(result == 0) {
//			result = new Integer(p1.getAge()).compareTo(new Integer(p2.getAge()));
//		}
//		return result;
		return 0;
	}
}
