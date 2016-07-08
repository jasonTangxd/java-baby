package com.xxo.util;

/**
 * Created by xiaoxiaomo on 2012/4/2.
 */
public class ControlStatement {

    public int mex(int a , int b) {
        int max = a ;
        if( b > a ){
            max = b ;
        }
        return max ;
    }

    public static void formatPrint( int[] arr ){
        System.out.print("[");
        for (int i = 0 ; i < arr.length ; i++ ){
            System.out.print(arr[i]);

            if( i < arr.length -1 ){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}
