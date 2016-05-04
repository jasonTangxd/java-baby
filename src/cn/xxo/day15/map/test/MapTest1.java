package cn.xxo.day15.map.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *  每一个超人学院的学生（Student）都有自己的籍贯
	有属性：姓名name，年龄age
	注意：姓名和年龄相同则视为同一个学生，需要保证学生的唯一性。
	提示：
		1°、如何描述学生
		2°、定义map容器。将学生作为键，籍贯作为值。存入。
		3°、获取map集合中的元素。要求使用map的两种获取元素的方式来获取
 *  map
 */
public class MapTest1 {

	public static void main(String[] args) {
		Map<Student, String> stuMap = new HashMap<Student, String>();
		stuMap.put(new Student("赵小婷", 18), "北京");
		stuMap.put(new Student("可可",19), "上海");
		stuMap.put(new Student("陈昕",22), "江苏苏州");
		stuMap.put(new Student("薛峰",24), "甘肃酒泉");
		//第一种方式keyset
		Set<Student> keySet = stuMap.keySet();
		Iterator<Student> it1 = keySet.iterator();
		while(it1.hasNext()) {
			Student stu = it1.next();
			System.out.println(stu + "\t籍贯是：" + stuMap.get(stu));
		}
		System.out.println("------------------------");
		//第二种方式
		Set<Map.Entry<Student, String>> entrySet = stuMap.entrySet();
		Iterator<Map.Entry<Student, String>> it2 = entrySet.iterator();
		while(it2.hasNext()) {
			Map.Entry<Student, String> me = it2.next();
			Student stu = me.getKey();
			String val = me.getValue();
			System.out.println(stu + "\t籍贯是：" + val);
		}
	}
}

class Student implements Comparable<Student> {
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
	@Override
	public int compareTo(Student stu) {
		int result = new Integer(this.age).compareTo(new Integer(stu.age));
		if(result == 0) {
			result = this.name.compareTo(stu.name);
		}
		return result;
	}
}
