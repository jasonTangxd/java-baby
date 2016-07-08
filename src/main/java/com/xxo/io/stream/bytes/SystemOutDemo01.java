package com.xxo.io.stream.bytes;

import java.io.IOException;
import java.io.PrintStream;

/**
 * 一个打印程序
 * Created by xiaoxiaomo on 2012/4/7.
 */
public class SystemOutDemo01 {

    public static void main(String[] args) throws IOException {

        PrintStream out = System.out; //默认打印到控制台
        out.write("fasfs".getBytes());
    }
}
