package com.xiaoxiaomo.day21;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 使用有参构造函数创建对象，执行功能
 * @author xiaoxiaomo
 *
 */
public class Demo9 {
	
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("cn.xxo.day21.Student");
		//获取对应的构造函数对象
		Constructor constructor = clazz.getConstructor(String.class,int.class);
		//使用有参的构造函数创建对象
		Object newInstance = constructor.newInstance("zs",10);
		
		Method method = clazz.getMethod("show1");
		method.invoke(newInstance);
		
		
		
	}

}
