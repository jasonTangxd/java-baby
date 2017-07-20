package com.xiaoxiaomo.day15.map.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**进行视频补录
 *  每一个超人学院的学生（Student）都有自己的籍贯
	有属性：姓名name，年龄age
	注意：姓名和年龄相同则视为同一个学生，需要保证学生的唯一性。
	提示：
		1°、如何描述学生
		2°、定义map容器。将学生作为键，籍贯作为值。存入。
		3°、获取map集合中的元素。要求使用map的两种获取元素的方式来获取
 *  map
 */
public class MapTest5 {
	public static void main(String[] args) {
		Map<Student1, String> map = new HashMap<Student1, String>();
		map.put(new Student1("赵小婷", 18), "北京");
		map.put(new Student1("可可",19), "上海");
		map.put(new Student1("陈昕",22), "江苏苏州");
		map.put(new Student1("薛峰",24), "甘肃酒泉");
		//使用第一种方式keySet
		Set<Student1> keySet = map.keySet();
		Iterator<Student1> it = keySet.iterator();
		while(it.hasNext()) {
			Student1 stu = it.next();
			String value = map.get(stu);
			System.out.println(stu + ", 籍贯是：" + value);
		}
		System.out.println("----------------");
		//第二种方式entrySet
		Set<Map.Entry<Student1,String>> entrySet = map.entrySet();
		Iterator<Map.Entry<Student1, String>> it1 = entrySet.iterator();
		while(it1.hasNext()) {
			Map.Entry<Student1, String> me = it1.next();
			Student1 stu = me.getKey();
			String value = me.getValue();
			System.out.println(stu + ", 籍贯是：" + value);
		}
	}
}

class Student1 {
	private String name;
	private int age;
	public Student1(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Student1() {
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
	public int hashCode() {
		return name.hashCode() + age * 31;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			throw new RuntimeException("对象为空，无法进行比较");
		}
		if(!(obj instanceof Student1)) {
			throw new RuntimeException("不是同一类型，无法进行比较");
		}
		Student1 stu = (Student1)obj;
		return this.name.equals(stu.name) && this.age == stu.age;
	}
	@Override
	public String toString() {
		return "name=" + name + ", age=" + age;
	}
}
