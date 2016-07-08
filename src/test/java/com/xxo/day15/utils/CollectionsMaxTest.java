package com.xxo.day15.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * static <T extends Comparable<T>> T max(Collection<? extends T> coll);
 *
 */
public class CollectionsMaxTest {

	public static void main(String[] args) {
//		method_max();//没有指定比较器，需要集合中元素具备比较性
		method_max_comparator();//手工指定了比较器，所以元素不一定要实现Comparable接口
	}
	
	public static void method_max_comparator() {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("chenxin",22));
		list.add(new Student("keke",19));
		list.add(new Student("zhaoxiaoting", 18));
		list.add(new Student("xuefeng",24));
		System.out.println("集合元素：" + list);
		Student maxStu = Collections.max(list, new MyComp());
		Collections.sort(list, new MyComp());
		System.out.println("排序后的集合：" + list);
		System.out.println("最大元素：" + maxStu);
	}
	
	public static void method_max() {
		List<String> list = new ArrayList<String>();
		list.add("zhangsan");
		list.add("lisi");
		list.add("langwang");
		list.add("zhaoliu");
		list.add("zhouqi");
		System.out.println("集合元素：" + list);
		String max = Collections.max(list);
//		CollectionsSortTest.mySort(list);
		Collections.sort(list);
		System.out.println("排序后的list为：" + list);
		System.out.println("list中的最大元素是:" + max);
	}
}

class MyComp implements Comparator<Student> {
	@Override
	public int compare(Student stu1, Student stu2) {
		int result = stu1.getName().compareTo(stu2.getName());
		if(result == 0) {
			result = new Integer(stu1.getAge()).compareTo(new Integer(stu2.getAge()));
		}
		return result;
	}
	
}

class Student {
	private String name;
	private int age;
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Student() {
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
	
	public int hashCode() {
		return name.hashCode() + age * 31;
	}
	@Override
	public boolean equals(Object obj) {
		if (null == obj) {
			throw new RuntimeException("元素为空，不能存进去");
		}
		if (!(obj instanceof Student)) {
			throw new RuntimeException("元素不是Student类型的，不能存进去");
		}
		Student stu = (Student)obj;
		return this.name.equals(stu.name) && this.age == stu.age;
	}
	
	@Override
	public String toString() {
		return "name="+ name + ", age=" + age;
	}
}
