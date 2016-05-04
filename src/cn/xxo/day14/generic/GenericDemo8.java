package cn.xxo.day14.generic;


import java.util.Comparator;
import java.util.TreeSet;

public class GenericDemo8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeSet<Person> al1 = new TreeSet<Person>(new CompByName());
		
		al1.add(new Person("abc4",34));
		al1.add(new Person("abc1",30));
		al1.add(new Person("abc2",38));

		TreeSet<Student> al2 = new TreeSet<Student>(new CompByName());

		al2.add(new Student("stu1",11));
		al2.add(new Student("stu7",20));
		al2.add(new Student("stu2",22));
		
	}

}


class CompByName implements Comparator<Person>{
	@Override
	public int compare(Person o1, Person o2) {
		int temp = o1.getName().compareTo(o2.getName());
		return temp==0? o1.getAge()-o2.getAge():temp;
	}
	
}

class CompByStuName implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		int temp = o1.getName().compareTo(o2.getName());
		return temp==0? o1.getAge()-o2.getAge():temp;
	}
	
}

