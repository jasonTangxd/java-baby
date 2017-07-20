package com.xiaoxiaomo.day14.generic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GenericDemo9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Person> ts = new HashSet<Person>();

		ts.add(new Person("孔威振", 15));
		ts.add(new Person("陶崔晨", 19));
		ts.add(new Person("唐选东", 38));
						//HashSet(Collection<? extends E> c) 
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student("lisi01", 15));
		al.add(new Student("lisi03", 19));
		al.add(new Student("lisi02", 38));
		
		ts.addAll(al);
		
		GenericDemo6.sos(ts);
	}	
}
