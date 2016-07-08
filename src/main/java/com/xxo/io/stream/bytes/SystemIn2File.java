package com.xxo.io.stream.bytes;

import java.io.*;

/**
 * Created by xiaoxiaomo on 2012/4/7.
 * 把用户输入的信息保存到文件中
 */
public class SystemIn2File {

    public static void main(String[] args) throws IOException {

        //1. 写入源
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\A.txt")) ;

        InputStream in = System.in ; //输入流
        BufferedInputStream bis = new BufferedInputStream(in) ;

        int ch = 0 ;
        while ( ( ch = bis.read() ) != -1 ){
            System.out.println(ch);
            bos.write(ch);
            bos.flush();

        }

        //bos.close();

    }
}
