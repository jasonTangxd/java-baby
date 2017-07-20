// Can you spot the "memory leak"?
package com.effectivejava.chapter02.item06;

import java.util.Arrays;

/**
 * 消除过期的对象引用
 *
 * 消除过期引用
 *
 * 一般而言，只要类是自己管理内存，程序员就因该警惕内存泄漏的问题
 * 内存泄漏的另一个常见来源就是缓存，可以使用WeakHashMap代表缓存，或者添加新条目的时候进行清理
 * 内存泄漏的还有一个常见来源就是监听器和其他回调，
 *
 */
public class StackSaveMemory {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackSaveMemory() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[--size] = null ;//消除引用
        return result;
    }

    /**
     * 数组扩容
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
