package cn.xxo.momo.util;

import java.util.HashMap;

/**
 * javap Demo
 * Created by xiaoxiaomo on 2016/3/31.
 */
public class JavapDemo {
    private int num = 10 ;//私有全局变量
    public static String name = "momo" ;//共有全局变量
    protected Double height = 175.0 ;//protected
    private HashMap map ;

    private JavapDemo() {}
    public JavapDemo(int num) {
        this.num = num;
    }

    public static void main(String[] args) {
        String a = name ;
        String b = "abc" ;
        String c = a+b ;
        System.out.println(c);
    }
}
