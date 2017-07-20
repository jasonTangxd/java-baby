package com.xiaoxiaomo.day13.list;

import java.util.LinkedList;

/**
 * 要求，使用LinkedList来实现堆栈和队列
 * 堆栈：先进后出---First In Last Out| FILO
 * 队列：先进先出---First In First Out| FIFO
 * 
 * 作业：实现队列的数据结构
 *何永松
 *项科霖
 *李辉
 *
 */
public class LinkedListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		myStack.myPush("何永松");
		myStack.myPush("项科霖");
		myStack.myPush("李辉");
		
//		System.out.println(myStack.myPop());
//		System.out.println(myStack.myPop());
//		System.out.println(myStack.myPop());
		while(!myStack.isNull()) {
			System.out.println(myStack.myPop());
		}
	}
	
}
/**
 * 自定义的堆栈结构
 */
class MyStack {
	private LinkedList list;
	
	public MyStack() {
		list = new LinkedList();
	}

	public void myPush(Object obj) {
		list.addLast(obj);
	}
	
	public Object myPop() {
		return list.removeLast();
	}
	
	public boolean isNull() {
		return list.isEmpty();
	}
	
}