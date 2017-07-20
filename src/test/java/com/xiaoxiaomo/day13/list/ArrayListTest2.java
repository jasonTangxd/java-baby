package com.xiaoxiaomo.day13.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 要求：
 * 	去重ArrayList中重复的自定义对象Person（有name和age两个属性）
 * 说明：当两个Person的name和age的值相等的时候，就认为两个Person相同
 * 
 *  new Person("zhangsan", 13);
 *  new Person("lisi", 14);
 *  new Person("zhangsan", 13);
 *  从我们的实验中我们看到了，ArrayList比较两个元素相等，实际上比较的是元素的equals方法
 *  remove/contains都比较的是equals
 *
 */
public class ArrayListTest2 {

	public static void main(String[] args) {
		//去重自定义对象的案例
//		singleElementTest();
		listEquals();
	}
	
	/**
	 * 说明ArrayList内部contains和remove方法比较时调用的底层方法
	 */
	public static void listEquals() {
		List list = new ArrayList();
		list.add(new Person("00", 13));
		list.add(new Person("01", 14));
		list.add(new Person("02", 15));
//		list.add(new Person("00", 13));
		
		//contains底层调用的是元素的equals方法
//		System.out.println(list.contains(new Person("00", 13)));
		
		System.out.println(list.remove(new Person("00", 14)));
		sop(list);
	}
	
	public static void singleElementTest() {
		List list = new ArrayList();
		list.add(new Person("00", 13));
		list.add(new Person("01", 14));
		list.add(new Person("02", 15));
		list.add(new Person("00", 13));
		
		list = singleElement(list);
		sop(list);
	}
	
	public static List singleElement(List oldList) {
		List newList = new ArrayList();
		Iterator it = oldList.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			if(!newList.contains(obj)) {
				newList.add(obj);
			}
		}
		return newList;
	}
	public static void sop(List list) {
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

class Person {
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
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Person)) {
			return false;
		}
		Person p = (Person)obj;
		//第一种比较方式：
//		if(this.name.equals(p.name)) {
//			if(this.age == p.age) {
//				return true;
//			}
//		}
//		return false;
		System.out.println(this.name + "---equals---" + p.name);
		return this.name.equalsIgnoreCase(p.name) && this.age == p.age;
	}
	

	@Override
	public String toString() {
		return name/* + ", age=" + age*/;
	}
	
}



