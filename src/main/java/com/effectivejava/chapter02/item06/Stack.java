// Can you spot the "memory leak"?
package com.effectivejava.chapter02.item06;

import java.util.Arrays;

/**
 * 消除过期的对象引用
 * <p>
 * 那么哪里引起的内存泄漏呢？
 * 如果一个栈先是增长，然后再收缩，那么从栈中弹出来的对象讲不会被当做垃圾回收，即使使用的栈程序不再引用这些对象。
 * 这是因为，栈内部维护着对这些对象的过期引用（obsolete reference）。过期引用是指，永远也不会再被接触的引用。
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }

    /**
     * Ensure space for at least one more element, roughly doubling the capacity
     * each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
