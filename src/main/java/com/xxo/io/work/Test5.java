package com.xxo.io.work;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/**
 * 合并
 * Created by xiaoxiaomo on 2012/4/11.
 */
public class Test5 {

    public static void main(String[] args) throws IOException {
        binFile() ;
    }

    private static void binFile() throws IOException {

        //写入源
        FileOutputStream outPut = new FileOutputStream("d://a1.txt") ;

        //元数据
        FileInputStream file1 = new FileInputStream("D://0.part") ;
        FileInputStream file2 = new FileInputStream("D://1.part") ;
        FileInputStream file3 = new FileInputStream("D://2.part") ;
        FileInputStream file8 = new FileInputStream("D://8.part") ;

        //放入集合，然后存入一个枚举中
        ArrayList<FileInputStream> inputStreams = new ArrayList<FileInputStream>() ;
        inputStreams.add( file1 ) ;
        inputStreams.add( file2 ) ;
        inputStreams.add( file3 ) ;
        inputStreams.add(file8) ;

        Enumeration<FileInputStream> enumeration = Collections.enumeration(inputStreams);

        //放入SequenceInputStream
        SequenceInputStream stream = new SequenceInputStream( enumeration ) ;

        //读取数据，合并
        byte[] bytes = new byte[1024] ;
        int len = 0 ;
        while ( ( len = stream.read( bytes ) ) != -1  ){
            outPut.write( bytes , 0 , len );
        }

        outPut.close();
        stream.close();

    }
}
