package com.xiaoxiaomo.day15.map.demo;

/**
 * Comparable和Comparator区别：
 *  在jdk的位置：
 *  Comparable是在java.lang包下的一个接口
 *  Comparator是在java.util包下的一个接口
 * 	在哪里使用？
 * 	  如果要让我们的对象（集合元素）具备一个比较性，这个时候就需要用到了Comparable接口
 *   如果要让我们的集合能够比较集合中的元素，这时就需要使用Comparator
 *   ===》Comparable在我们的元素身上实现，Comparator在我们集合定义的时候作为比较器参数传入
 *  要复写的方法？
 *  	实现Comparable接口，只需要复写其中的int compareTo(T t)即可
 *  	使用Comparator接口，只需要复习其中的int compare(T t1, T t2)即可
 */
public class CompareTest {

	public static void main(String[] args) {

	}
}
