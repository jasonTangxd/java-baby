package com.effectivejava.chapter02.item05;


/**
 *
 * 自动装箱（autoboxing）：
 * 		将sum的生命从Long改为long，运行速度提成了7倍。
 */
public class Sum {
	// Hideously slow program! Can you spot the object creation?
	public static void main(String[] args) {
		Long sum = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
