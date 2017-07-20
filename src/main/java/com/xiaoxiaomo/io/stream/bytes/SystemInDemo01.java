package com.xiaoxiaomo.io.stream.bytes;

import java.io.IOException;
import java.io.InputStream;

/**
 * 把用户输入的信息打印到控制台
 * Created by xiaoxiaomo on 2012/4/7.
 */
public class SystemInDemo01 {

    public static void main(String[] args) throws IOException {

        //1. 获取用户的输入信息
        InputStream in = System.in;
        int ch = 0 ;
        //2. 输出
        while ( ( ch =in.read() ) != -1 ){
            System.out.print((char)ch);
        }
    }
}
