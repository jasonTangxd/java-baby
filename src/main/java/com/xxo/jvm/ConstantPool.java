package com.xxo.jvm;

/**
 * Created by xiaoxiaomo on 2012/7/6.
 */
public class ConstantPool {

    public static void main(String[] args) {

        String str1=new String("hello");
        String str2=new String("hello");

       // Thread.sleep(10000);

        //堆中的两个对象
        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));

        System.out.println(str1.toString()==str2.toString());
        String str3="hello";
        String str4="hello";

        //常量池的同一个对象
        System.out.println(str3==str4);

        //str3.intern();
    }

}
