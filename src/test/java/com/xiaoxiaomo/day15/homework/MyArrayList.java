package com.xiaoxiaomo.day15.homework;

import java.util.Collection;

public class MyArrayList<E> {
	
	private Object[] elements;
	private int size;
	private int length;
	public MyArrayList() {
		elements = new Object[4];
		length = elements.length;
	}

	public boolean add(E e) {
		boolean flag = false;
		if(size < length) {
			elements[size++] = e;
			flag = true;
		} else {
			Object[] newElements = new Object[length + (length/2)];
			System.arraycopy(elements, 0, newElements, 0, length);
			elements = newElements;
			elements[size++] = e;
			length = elements.length;
			flag = true;
		}
		
		return flag;
	}
	
	public boolean addAll(Collection<E> col) {
		return false;
	}
	
	public E get(int index) {
		return (E)elements[index];
	}
	
	public E remove(int index) {
		if(index > size || index < 0) {
			throw new RuntimeException("数组角标越界  size:" + size + ", index:" + index);
		}
		E oldValue = get(index);
		System.arraycopy(elements, index + 1, elements, index, size - index - 1);
		elements[--size] = null;
		return oldValue;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int x = 0; x < size; x++) {
			if(x == 0) {
				sb.append("[" + elements[x] + ",");
			} else if(x == size - 1) {
				sb.append(elements[x] + "]");
			} else {
				sb.append(elements[x] + ",");
			}
		}
		return sb.toString();
	}
}
