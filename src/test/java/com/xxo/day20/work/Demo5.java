package com.xxo.day20.work;

public class Demo5 {
	private Demo5(){}
	private static Demo5 demo5 = null;
	
	public static synchronized Demo5 getInstance(){
		if(demo5==null){
			demo5 = new Demo5();
		}
		return demo5;
	}
}
