package com.xxo.day14.generic;

/**
 * 在接口上定义泛型
 *
 */
public class GenericDemo4 {

	public static void main(String[] args) {
		new FruitFactory().show(new Fruit());
		Factory f = new Java<String>();
	}
}

class Java<T> extends JavaTool<T>{

	@Override
	public void print(T t) {
		
	}

	@Override
	public void show(T t) {
		
	}
}

abstract class JavaTool<T> implements ToolUtils<T> {
	
	
}


interface ToolUtils<T> extends Factory<T> {
	void print(T t);
}



///////////////////////接口泛型的第一种使用方式///////////////////////////////////////
class Fruit{
	
}

class FruitFactory implements Factory<Fruit> {

	@Override
	public void show(Fruit t) {
		System.out.println("produce : 榴莲");
	}
	
}

interface Factory<T> {
	void show(T t);
}