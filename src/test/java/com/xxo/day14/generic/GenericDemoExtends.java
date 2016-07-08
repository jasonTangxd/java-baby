package com.xxo.day14.generic;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class GenericDemoExtends {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		method_set_string();
	}
	public static void method_set_string() {
		List<Student> sList = new ArrayList<Student>();
		sList.add(new Student("slisi01", 14));
		sList.add(new Student("slisi02", 15));
		sList.add(new Student("slisi03", 16));
		sop(sList);
		
		System.out.println("--------------------");
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("plisi1", 13));
		list.add(new Person("plisi2", 14));
		list.add(new Person("plisi3", 15));
		sop(list);
	}
	/**
	 * 必须记住：泛型要求两边的类型必须一致
	 * 采用我们的向上限定来实现
	 * ? extends E:接收E类型或者E的子类型，向上限定
	 * ? super E：接收E类型或E的超（父|基）类， 向下限定
	 * @param col
	 */
	public static void sop(List<? extends Person> col) {//List<Student> col = new ArrayList<Person>(); error
		Iterator<? extends Person> it = col.iterator();//List<Person> list = new ArrayList<Student>(); error
		while(it.hasNext()) {//Person p = new Student();
			Person student = it.next();
			System.out.println(student.getName());
		}
	}

//	public static void sop1(List<? super Student> col) {//List<Student> col = new ArrayList<Person>();
//		Iterator<? super Student> it = col.iterator();//List<Person> list = new ArrayList<Student>();
//		while(it.hasNext()) { //? a = new Student();不可以
//			Object next = it.next();
//			System.out.println(student.getName());
//		}
//	}

	
	
	/**
	 * 有局限性，无法获取元素T身上的方法或属性
	 * @param <T>
	 * @param col
	 */
	public static <T> void sos(Collection<T> col) {
		Iterator<T> it = col.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
