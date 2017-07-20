package com.xiaoxiaomo.io.stream.chars;

import java.io.FileReader;
import java.io.IOException;

/**
 * 自定义一个BufferReader
 * Created by xiaoxiaomo on 2012/4/6.
 */
public class MyBufferReader {


    private FileReader fileReader ;
    MyBufferReader(FileReader fileReader){ //构造器接受外部的FileReader
        this.fileReader = fileReader ;
    }

    char[] buf = new char[2] ;//自定义一个缓冲数组

    private int count ; //用于记录每次传入的数据长度

    private int pox ;//用于读取当前数据的指针
    /**
     * 读取数据
     * 有一个容器，
     * @return
     */
    public int myRead() throws IOException {


        int result = -1 ;
        //如果count等于0就说明两个问题
        //1、要么没有初始化
        //2、要么确实已经读取结束了==返回-1
        if( count == 0 ){
            count = fileReader.read(buf) ; //重新去读取
        }
        if( count == -1 )
            return -1 ; //没有数据啦
        result = buf[pox] ;
        pox ++ ; //指针每次移动一个
        count -- ; //数据在减少
        return result ;
    }


    public String myReadLine() throws IOException {

        StringBuffer sb = new StringBuffer() ;
        int c = 0 ;
        while (  ( c = myRead() ) != -1 ){
            if( c == '\r' ){
                continue;
            }

            if( c == '\t' ){
                return sb.toString() ;
            }

            sb.append((char)c) ;
        }

        if( sb.length() != 0 ){
            return sb.toString() ;
        }

        return null ;
    }

}

class MyBufferReaderTest{
    public static void main(String[] args) throws IOException {
        MyBufferReader reader = new MyBufferReader(new FileReader("file/abc.txt"));

//        int c = -1 ;
//        while ( ( c = reader.myRead() ) != -1 ){
//            System.out.print((char)c);
//        }

        String line = null ;
        while ( (line =reader.myReadLine()) != null ){
            System.out.println(line);
        }
    }
}












