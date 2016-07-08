package com.xxo.day19;

import java.io.Serializable;

/**
 * 实体类
 * @author xiaoxiaomo
 *
 */
public class Person implements Serializable {
	
	private static final long serialVersionUID = 12312312L;
	
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
