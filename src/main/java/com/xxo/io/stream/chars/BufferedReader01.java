package com.xxo.io.stream.chars;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 2012/4/6
 * BufferedReader高效读取数据
 * Created by xiaoxiaomo on 2012/4/6.
 */
public class BufferedReader01 {

    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new FileReader("file/abc.txt")) ;

        //读取数据第一种方式
        String line = null ;
        //int i = 0 ;
        while ( ( line = bfr.readLine()) != null ){
            //System.out.println(++i);
            System.out.println(line);
        }

        //读取数据第二种方式
//        char[] buf = new char[1024] ;
//        int len = 0 ;
//        while ( ( len = bfr.read(buf) ) != -1 ){
////            System.out.println(++i);
//            System.out.println(new String( buf , 0 ,len ));
//        }

        bfr.close();
    }

}
