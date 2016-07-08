package com.xxo.io.stream.bytes;

import java.io.*;

/**
 * 读取window创建的文件--其中有中文字符
 * 1. 通过字节流FileInputStream读取文件（当然这里可以直接写入，但是会乱码）
 * 2. 由于是中文，然后我们就通过InputStreamReader把字节流转为字符流，并转码
 * 3. 然后放入高效读取区
 * Created by xiaoxiaomo on 2012/4/7.
 */
public class FileforWindows {

    public static void main(String[] args) throws IOException {

        //1. 通过字节流读取信息
        FileInputStream fis = new FileInputStream("d:\\aaaa.txt") ;

//        //2. 通过InputStreamReader转码然后放入高效缓存区
//        BufferedReader br = new BufferedReader( new InputStreamReader(fis ,"gbk" )  ) ;

        //3. 打印出来
        //3.1 通过readLine() ;
//        String line = null ;
//        while( ( line = br.readLine() ) != null ){
//            System.out.println(line);
//        }

        //不放入缓存区
        //通过自定义缓存区char[]
        InputStreamReader gbk = new InputStreamReader(fis, "gbk");
        char[] chars = new char[1024] ;
        int len = 0 ;
        while( ( len = gbk.read(chars) ) != -1){
            System.out.println(new String(chars,0,len));
        }

    }
}
