package com.xxo.day16;

/**
 * 
 * @author xiaoxiaomo
 *
 */
public class Test13 {
	public static void main(String[] args) {
		Person p = new Person();
//		p.chifan();
		NewPerson p1 = new NewPerson(p);
//		p1.chifan();
		NewPerson2 p2 = new NewPerson2();
		p2.chifan();
	}
}

class Person{
	void chifan(){
		System.out.println("吃饭");
	}
}

class NewPerson{
	Person p;
	NewPerson(Person p){
		this.p = p;
	}
	void chifan(){
		System.out.println("来一杯哈啤");
		p.chifan();
		System.out.println("水果");
		System.out.println("散步");
	}
}

class NewPerson2 extends Person{
	void chifan(){
		System.out.println("来一杯哈啤");
		super.chifan();
		System.out.println("来一根雪茄");
	}
}

