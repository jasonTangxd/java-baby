package com.xiaoxiaomo.day13.set;

import java.util.HashSet;
import java.util.Set;

/**
 * 要求：
 * 	往hashset中存放自定义的对象BeautifulGirl（name， age）
 *  说明：当两个BeautifulGirl的name和age想等的时候，说明两个对象相等
 *  目的：如何将相同的BeautifulGirl存放到Set中
 */
public class HashSetTest {

	public static void main(String[] args) {
		Set set = new HashSet();
		set.add(new BeautifulGirl("王蝶", 18));
		set.add(new BeautifulGirl("陈洁", 18));
		set.add(new BeautifulGirl("郭飞飞", 17));
		set.add(new BeautifulGirl("王莹", 16));
		System.out.println("-------------------");
		//contains方法内部调用了hashcode和equals
		System.out.println(set.contains(new BeautifulGirl("讲师", 16)));
		//remove方法内部也调用haseset元素的hashcode和equals方法
//		System.out.println(set.remove(new BeautifulGirl("郭飞飞", 17)));
//		SetDemo.sop(set);
		
	}
	
	public static void method_hashCode() {
		Set set = new HashSet();
		set.add(new BeautifulGirl("王蝶", 18));
		set.add(new BeautifulGirl("陈洁", 18));
		set.add(new BeautifulGirl("郭飞飞", 17));
		set.add(new BeautifulGirl("王莹", 16));
		set.add(new BeautifulGirl("王蝶", 18));
		SetDemo.sop(set);
	}

}

class BeautifulGirl {
	private String name;
	private int age;
	public BeautifulGirl() {
	}
	public BeautifulGirl(String name, int age) {
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
	public int hashCode() {//hashCode值定义为相同的值
		System.out.println(this.name + "---------");
		return name.hashCode() + age * 31; //5  18
									  	   //18 5
	}
	
//	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof BeautifulGirl)) {
			return false;
		}
		BeautifulGirl mgf = (BeautifulGirl)obj;
		System.out.println(this.name + "----equals-----" + mgf.name);
		return this.name.equals(mgf.name) && this.age == mgf.age;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
