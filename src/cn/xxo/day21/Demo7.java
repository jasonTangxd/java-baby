package cn.xxo.day21;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 获取类名对应的字节码对象，然后操作字段、方法、构造函数
 * @author lenovo
 *
 */
public class Demo7 {
	
	public static void main(String[] args) throws Exception {
		//获取字段
		Class clazz = Class.forName("cn.crxy.day21.Student");
		Field[] fields = clazz.getFields();//获取当前类及父类中的所有公有字段
		Field[] declaredFields = clazz.getDeclaredFields();//获取私有属性(包含公有)
		for (Field field : declaredFields) {
			//System.out.println(field);
		}
		
		
		//获取方法
		Method[] methods = clazz.getMethods();//获取当前类及父类中所有公有的方法
		Method[] declaredMethods = clazz.getDeclaredMethods();//获取当前类中的所有私有方法(包含公有)
		for (Method method : declaredMethods) {
			//System.out.println(method);
		}
		
		
		//获取构造函数
		Constructor[] constructors = clazz.getConstructors();//获取公有构造函数
		Constructor[] declaredConstructors = clazz.getDeclaredConstructors();//获取私有构造函数
		for (Constructor constructor : constructors) {
			//System.out.println(constructor);
		}
		
		
		
		
	}

}
