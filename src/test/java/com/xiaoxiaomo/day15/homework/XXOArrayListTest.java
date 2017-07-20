package com.xiaoxiaomo.day15.homework;

public class XXOArrayListTest {
	public static void main(String[] args) {
		XXOArrayList<String> cal = new XXOArrayList<String>();
		System.out.println("cal初始size：" + cal.size());
		System.out.println("cal是否为空：" + cal.isEmpty());
		cal.add("zhangsan");
		cal.add("lisi");
		cal.add("wangwu");
		cal.add("zhaoliu");
		System.out.println("cal添加元素之后size：" + cal.size());
		System.out.println(cal.get(1));
		System.out.println("cal是否为空：" + cal.isEmpty());
		System.out.println("cal添加后的元素：" + cal);
		System.out.println(cal.remove(1));
		System.out.println("cal删除元素后的size:" + cal.size());
		System.out.println("cal删除后的元素：" + cal);
	}

}
