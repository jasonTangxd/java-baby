package com.xxo.day21;

public class Demo6 {
	
	public static void main(String[] args) throws Exception {
		//获取对应类的字节码对象
		//1：通过对象获取
		Student student =  new Student();
		Class clazz1 = student.getClass();
		Student student2 = new Student();
		Class clazz2 = student2.getClass();
		System.out.println(clazz1==clazz2);
		
		//2:通过类名直接获取
		Class  clazz3 = Student.class;
		System.out.println(clazz1==clazz3);
		
		
		//3：通过class.forName(...);
		Class clazz4 = Class.forName("cn.xxo.day21.Student");
		System.out.println(clazz1==clazz4);
		
	}

}
