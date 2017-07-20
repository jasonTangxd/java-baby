// Service provider framework sketch - Service provider interface - Page 12
package com.effectivejava.chapter02.item01;

/**
 *
 *  考虑用静态工厂方法代替构造器
 *
 */
public interface Provider {
	Service newService();
}