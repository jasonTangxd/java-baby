package com.xiaoxiaomo.day21;

import java.lang.reflect.Method;

public class Demo8 {
	
	public static void main(String[] args) throws Exception {
		//执行类中的方法
		//1:执行的是类中的空参的函数
		Class clazz = Class.forName("cn.xxo.day21.Student");
		Object newInstance = clazz.newInstance();//这个代码就类似于执行new Student();
		Method method = clazz.getMethod("show1");
		//method.invoke(newInstance);
		//2：执行类中有参的函数
		Method method2 = clazz.getMethod("show2", String.class);
		//method2.invoke(newInstance, "hahahahah");
		
		//3：执行类中私有函数
		Method method3 = clazz.getDeclaredMethod("show3");
		
		method3.setAccessible(true);//实现暴力访问，针对私有的方法
		method3.invoke(newInstance);
	}

}
