package com.xiaoxiaomo.day15.map.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 泛型嵌套
 * 	超人学院有线上班和线下班，每个班有很多学生，打印出每个班级的学生
	打印格式：
		线上班
			张三	23
			李四	24
		线下班
			王五	25
			赵六	26
	Map<String, List<Student>>
 *
 */
public class MapTest3 {

	public static void main(String[] args) {
		Map<String, List<Student>> map = new HashMap<String, List<Student>>();
		List<Student> onlineList = new ArrayList<Student>();
		onlineList.add(new Student("o-chenxin",22));
		onlineList.add(new Student("o-keke",19));
		onlineList.add(new Student("o-zhaoxiaoting", 18));
		onlineList.add(new Student("o-xuefeng",24));
		map.put("xxo-online", onlineList);
		List<Student> sublineList = new ArrayList<Student>();
		sublineList.add(new Student("s-chenxin",22));
		sublineList.add(new Student("s-keke",19));
		sublineList.add(new Student("s-zhaoxiaoting", 18));
		sublineList.add(new Student("s-xuefeng",24));
		map.put("xxo-subline", sublineList);
		
		Set<Map.Entry<String, List<Student>>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, List<Student>>> it = entrySet.iterator();
		while(it.hasNext()) {
			Map.Entry<String, List<Student>> me = it.next();
			String className = me.getKey();
			List<Student> stuList = me.getValue();
			System.out.println("班级名称：" + className);
			Iterator<Student> it1 = stuList.iterator();
			while(it1.hasNext()) {
				System.out.println("\t" + it1.next());
			}
		}
		
	}
}
