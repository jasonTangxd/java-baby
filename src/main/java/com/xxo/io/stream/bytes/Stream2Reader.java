package com.xxo.io.stream.bytes;

import java.io.*;

/**
 *
 * 使用转换流实现 Test6的打印功能
 * 把用户输入的信息打印出来，并转为大写
 * Created by xiaoxiaomo on 2012/4/7.
 */
public class Stream2Reader {

    public static void main(String[] args) throws IOException {

        //1. 用户输入
        InputStream os = System.in  ;

        //2. 将字节流转换为字符流
        InputStreamReader isr = new InputStreamReader(os) ;

        //高缓存器
        BufferedReader br = new BufferedReader(isr) ;
        //
        String line = null ;
        while ( ( line = br.readLine() ) != null ){
            if( "quit".equals( line ) ){
                break;
            }
            System.out.println(line.toUpperCase());
        }

    }
}
