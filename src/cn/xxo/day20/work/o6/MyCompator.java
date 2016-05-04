package cn.xxo.day20.work.o6;

import java.util.Comparator;

public class MyCompator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		int num = s1.getScore()-s2.getScore();
		if(num==0){//分数相等
			num = s1.getAge()-s2.getAge();
			if(num==0){//年龄相等
				num = s1.getName().compareTo(s2.getName());
			}
		}
		return num;
	}

}
