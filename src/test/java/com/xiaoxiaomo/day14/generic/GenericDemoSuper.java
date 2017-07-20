package com.xiaoxiaomo.day14.generic;

import java.util.Comparator;
import java.util.TreeSet;

public class GenericDemoSuper {

	/**
	 * 要求：有两类对象Employee,Coder
	 * 将我们Coder存入到自定一个TreeSet集合，保证集合中元素按照年龄排序，如果年龄相等就按照姓名排序
	 * 改变需求，我还想再使用我们自定义MyComp比较器，在别的对象身上进行调用，比如说Employee
	 */
	public static void main(String[] args) {

		TreeSet<Coder> ts = new TreeSet<Coder>(new MyComp());
		ts.add(new Coder("lisi01", 13));
		ts.add(new Coder("lisi02", 15));
		ts.add(new Coder("lisi03", 11));
		GenericDemo6.sop(ts);

		TreeSet<Employee> ets = new TreeSet<Employee>(new MyComp());
		ets.add(new Employee("elisi01", 13));
		ets.add(new Employee("elisi02", 15));
		ets.add(new Employee("elisi03", 11));
		GenericDemo6.sop(ets);
	}
}


class Employee {
	private String name;
	private int age;
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
	public Employee() {
	}
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return name + "-----" + age;
	}
}

/**
 * @author xiaoxiaomo
 *
 */
class Coder extends Employee {

	public Coder() {
		super();
	}

	public Coder(String name, int age) {
		super(name, age);
	}
}

class Manager extends Employee {

	public Manager() {
		super();
	}

	public Manager(String name, int age) {
		super(name, age);
	}
}

class MyComp implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {//Coder o1 = new Employee(); error
		int result = new Integer(o1.getAge()).compareTo(new Integer(o2.getAge()));
		if(result ==0) {
			result = o1.getName().compareTo(o2.getName());
		}
		return result;
	}
}



class MyComp1 implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		int result = new Integer(o1.getAge()).compareTo(new Integer(o2.getAge()));
		if(result ==0) {
			result = o1.getName().compareTo(o2.getName());
		}
		return result;
	}
}

