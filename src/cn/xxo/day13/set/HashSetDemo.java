package cn.xxo.day13.set;


import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

	public static void main(String[] args) {
//		System.out.println(new Person2("01", 12));
//		System.out.println(new Person2("02", 12));
		Set set = new HashSet();
		set.add(new BeautifulGirl("01", 12));
		set.add(new BeautifulGirl("02", 12));
		set.add(new BeautifulGirl("03", 12));
		SetDemo.sop(set);
	}
}
class Person2 {
	private String name;
	private int age;
	public Person2() {
	}
	public Person2(String name, int age) {
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
//	@Override
//	public int hashCode() {//hashCode值定义为相同的值
//		return 60;
//	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return name;
	}
}
