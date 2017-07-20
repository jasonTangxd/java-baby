package com.xiaoxiaomo.io.stream.bytes;

import java.io.IOException;
import java.io.InputStream;

/**
 * 把用户输入的信息打印到控制台并转为大写，quit退出
 * Created by xiaoxiaomo on 2012/4/7.
 */
public class SystemIn2UpCase {

    public static void main(String[] args) throws IOException {

        StringBuffer sb = new StringBuffer() ;
        //1. 获取用户的输入信息
        InputStream in = System.in;
        int ch = 0 ;
        //2. 输出
        while ( ( ch =in.read() ) != -1 ){

            //继续
            if( ch == '\r' ){
                continue;
            }
            if( ch == '\n' ){
                String temp = sb.toString() ;
                if( "quit".equals( temp ) ){
                    //退出程序
                    break;
                }
                //打印出信息
                System.out.println(temp.toUpperCase());
                //清空sb
                sb.delete(0,temp.length()) ;
            } else {
                sb.append((char)ch) ;
            }
        }
    }
}
