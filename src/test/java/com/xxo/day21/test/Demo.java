package com.xxo.day21.test;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class Demo {
	
	public static void main(String[] args) throws Exception {
		/*Inter oldInterImple = new OldInterImple();
		oldInterImple.show();*/
		
		Properties properties = new Properties();
		properties.load(new FileInputStream(new File("a.properties")));
		
		String value = properties.getProperty("className");
		if("".equals(value)){
			Inter oldInterImple = new OldInterImple();
			oldInterImple.show();
		}else{
			Class clazz = Class.forName(value);
			Object newInstance = clazz.newInstance();
			Method method = clazz.getMethod("show");
			method.invoke(newInstance);
			
		}
		
		
		
		
		
		
	}

}
