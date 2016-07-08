package com.xxo.io.stream.bytes;

import java.io.*;

/**
 * 将文本文件中的内容打印到控制台上
 * Created by xiaoxiaomo on 2012/4/7.
 */
public class SystemOutForFile {

    public static void main(String[] args) throws IOException {

        //1. 文件源
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("d://test.txt")) ;

        //2. 输出流
        OutputStream os = System.out ;

        byte[] bytes = new byte[1024] ;

        int len = 0 ;
        while ( ( len = bis.read(bytes) ) != -1 ){
            os.write( bytes , 0 ,len );
        }

    }
}
