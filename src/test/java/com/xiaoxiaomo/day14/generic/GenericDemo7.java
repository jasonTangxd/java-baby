package com.xiaoxiaomo.day14.generic;


public class GenericDemo7 {

	public static void main(String[] args) {
//		List<Person> list = new ArrayList<Person>();
		
//		list.add(new Person("孔威振", 15));
//		list.add(new Person("陶崔晨", 19));
//		list.add(new Person("唐选东", 38));
//		list.add(new Student(12));
//		Integer[] arr = {2,1,8,4,5};
		String[] arr = {"aaa","bbb","aba","abc","bbc"};
		sort(arr);
//		GenericDemo6.sos(list);
		for(int x = 0; x < arr.length; x++) {
			System.out.print(arr[x] + " ");
		}
	}
	
	public static <T extends Comparable<T>> void sort(T[] t) {
		for(int x = 0; x < t.length - 1; x++) {
			for(int y = x + 1; y < t.length; y++) {
				if(t[x].compareTo(t[y]) > 0) {
					swap(t, x, y);
				}
			}
		}
	}

	private static <T> void swap(T[] arr, int x, int y) {
		T temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}

class Student extends Person {
	
	private int stuNo;

	public Student(String name, int age) {
		super(name, age);
	}
	public Student(int stuNo) {
		this.stuNo = stuNo;
	}

	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	
	public String toString() {
		return stuNo + "";
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