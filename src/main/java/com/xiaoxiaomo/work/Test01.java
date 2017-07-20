package com.xiaoxiaomo.work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 从键盘上输入10个整数，并将其放入一个一维数组中，然后将其前5个元素与后5个元素对换，
 * Created by xiaoxiaomo on 2012/4/12.
 */
public class Test01 {

    public static void main(String[] args) throws IOException {

        //1. 数组
        int size = 10 ;
        int[] ints = new int[size] ;
        BufferedReader bf;
        InputStream in = System.in;
        bf = new BufferedReader(new InputStreamReader(in)) ;
        String line  ;
        int i = 0 ;
        while ( ( line = bf.readLine() ) != null ){

            try {
                ints[i] = Integer.valueOf( line ) ;
                i++ ;
            } catch ( NumberFormatException e ){
                continue;
            }

            if( i > size-1 ){
                in.close();
                bf.close();
                break;
            }

        }


        //
        changeArray( ints ) ;

        for (int anInt : ints) {
            System.out.print(anInt + " " );
        }
    }

    private static void changeArray(int[] ints) {
        int size = ints.length ;
        for (int i = 0; i < size/2 ; i++) {
            int j = ints[i] ;
            ints[i] = ints[size-i-1] ;
            ints[size-i-1] =j ;
        }
    }


}
