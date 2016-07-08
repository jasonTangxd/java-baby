package com.xxo.jvm;

/**
 * 内存溢出测试
 * Created by xiaoxiaomo on 2012/7/6.
 */
public class MemoryTest {

    public static void main(String[] args) {
        newObject(0) ;
    }

    public  static void newObject( int i ){
        i++ ;
        System.out.println(i);
        newObject(i) ;
    }
}
