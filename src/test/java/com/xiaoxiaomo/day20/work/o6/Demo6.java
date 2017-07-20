package com.xiaoxiaomo.day20.work.o6;

import java.util.TreeSet;

public class Demo6 {
	
	public static void main(String[] args) {
		TreeSet<Student> treeSet = new TreeSet<Student>(new MyCompator());
		treeSet.add(new Student("张1", 18, 80));
		treeSet.add(new Student("张2", 28, 90));
		treeSet.add(new Student("张3", 19, 76));
		treeSet.add(new Student("张4", 30, 59));
		treeSet.add(new Student("张5", 18, 80));
		
		
		for (Student student : treeSet) {
			System.out.println(student.toString());
		}
	}

}
