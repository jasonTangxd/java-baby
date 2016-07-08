package com.xxo.day14.generic;

/**
 * 在我们的类的方法上定义泛型
 *
 */
public class GenericDemo3 {

	public static void main(String[] args) {
		Tool<String> tool = new Tool<String>();
		tool.print("希望大家都能找到20k的工作~");
		tool.show("希望大家早日出任CEO，迎娶白富美，走向人生巅峰，一直在巅峰~");
		tool.show("希望大家的银行存款：" + 1234567890 + "$");
		System.out.println(tool.show1("不积跬步无以至千里，不积小流，无以至江海；敢问路在何方？在脚下~"));
	}
}

/**
 * 
 * 在我们类中方法上定义泛型
 * 1、如果类上面定义了泛型，可以直接使用类上面定义的泛型
 * 2、如果方法有返回值，而且返回值不确定是什么类型，我们也可以使用泛型来作为方法的返回值
 * 	   返回值的类型不一定和我们类上面的泛型一直
 * 3、如果方法是静态方法的时候，那么就需要在static和返回值中间指定要使用的泛型
 * 我们发现，泛型也是有局限性的：一旦指定类上的泛型之后，在方法调用的时候就只能使用指定类型
 * @param <T>
 */
class Tool<T>{
	
	public void print(T t){
		System.out.println("print :" + t);
	} 
	
	/**
	 * 方法的泛型，避免了和类上面定义的泛型的一致，做到了调用的灵活性
	 * @param <E>
	 * @param e
	 */
	public <E> void show(E e){
		System.out.println("show :" + e);
	} 
	
	/**
	 * 定义了有返回值的方向方法
	 * @param <E>
	 * @param e
	 * @return
	 */
	public <E> E show1(E e){
		return e;
	} 
	
	/**
	 * 如何在没有返回值的静态方法上定义泛型
	 * @param <T>
	 * @param t
	 */
	public static <T> void show2(T t) {
		System.out.println("show2 :" + t);
	}

	/**
	 * 如何在静态有返回值的方法上定义泛型
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> T show3(T t) {
//		System.out.println("show2 :" + t);
		return t;
	}
	
	
}

