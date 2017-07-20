package com.xiaoxiaomo.day21;

public class Student {
	
	private String name;
	public int age;
	
	public Student(){}
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void show1(){
		System.out.println("show111111111111111"+this.name+"---"+this.age);
	}
	
	public void show2(String string){
		System.out.println("show2222222222222"+string);
	}
	
	private void show3(){
		System.out.println("show3333333333333333");
	}
	

}
