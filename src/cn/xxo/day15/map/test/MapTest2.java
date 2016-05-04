package cn.xxo.day15.map.test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 需求：对学生对象的年龄进行升序排序。
	提示:因为数据是以键值对形式存在的，所以要使用可以排序的Map——TreeMap。
		按照学生年龄进行排序--->Student实现Comparable接口
    需求更改：要求按照学生的姓名进行排序
	在此基础上按照学生姓名进行排序。---Comparator接口
 *
 */
public class MapTest2 {

	public static void main(String[] args) {
		Map<Student, String> stuMap = new TreeMap<Student, String>(new MyComparator());
		stuMap.put(new Student("chenxin",22), "江苏苏州");
		stuMap.put(new Student("keke",19), "上海");
		stuMap.put(new Student("zhaoxiaoting", 18), "北京");
		stuMap.put(new Student("xuefeng",24), "甘肃酒泉");

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

class MyComparator implements Comparator<Student> {
	@Override
	public int compare(Student stu1, Student stu2) {
		int result = stu2.getName().compareTo(stu1.getName());
		if(result == 0) {
			result = new Integer(stu2.getAge()).compareTo(new Integer(stu1.getAge()));
		}
		return result;
	}
}
