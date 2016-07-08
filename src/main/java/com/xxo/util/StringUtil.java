package com.xxo.util;

/**
 * Created by xiaoxiaomo on 2012/3/30.
 */
public class StringUtil {


    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "a";
        String s3 = "bc";

        //System.out.println(s3.intern()) ;

        String s4 = s2+s3;
        String s5 = "a"+"bc";
        boolean f1 = s1==s4 ;
        boolean f2 = s1==s5 ;
        System.out.println(f1);
        System.out.println(f2);

        new String("abc") ;

    }
}
