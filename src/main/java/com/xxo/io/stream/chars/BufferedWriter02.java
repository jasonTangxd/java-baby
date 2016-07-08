package com.xxo.io.stream.chars;

import java.io.*;

/**
 * 通过高效写入和高效读取复制文本文件
 * Created by xiaoxiaomo on 2012/4/6.
 */
public class BufferedWriter02 {

    public static void main(String[] args) {

        BufferedWriter bfw = null ;
        BufferedReader bfr = null ;
        try {
            bfr = new BufferedReader(new FileReader("abc.txt")) ;
            bfw = new BufferedWriter(new FileWriter("abc_copy2.txd")) ;

            //通过数组缓冲
//            char[] buf = new char[1024] ;
//            int len = 0 ;
//            if( ( len = bfr.read(buf) )  != -1 ){
//                bfw.write(buf,0,len);
//            }

            //读写行
            String line = null ;
            while ( ( line = bfr.readLine() ) != null  ){
                bfw.write(line);
                bfw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //注意关闭的时候，判断一下是否为空
            //不然会空指针异常哦
            if( bfr != null  )
                try {
                    bfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            if( bfw != null  )
                try {
                    bfw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }


    }
}
