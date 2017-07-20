package com.xiaoxiaomo.io.stream.chars;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 复制一个文件
 * 通过FileReader读取文本信息
 * 通过FileWriter写入文本信息
 * Created by xiaoxiaomo on 2012/4/6.
 */
public class FileReader02 {
    public static void main(String[] args) {

        FileReader fr = null ;
        FileWriter fw = null ;
        try {
            fr = new FileReader("file/abc.txt") ;
            fw = new FileWriter("abc_copy.txt") ;

            char[] buf = new char[1024] ;
            int len ;
            while ( ( len = fr.read(buf) ) != -1 ){
                fw.write( buf , 0 , len );
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭字符流
            if( fr != null ){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if( fw != null ){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
