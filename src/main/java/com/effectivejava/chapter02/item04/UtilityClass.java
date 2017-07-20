// Noninstantiable utility class
package com.effectivejava.chapter02.item04;

/**
 *
 * 私有化构造器：常用于工具类
 *
 */
public class UtilityClass {
	// Suppress default constructor for noninstantiability
	private UtilityClass() {
		throw new AssertionError();
	}
}
