package com.xxo.io.work;

import java.io.*;

/**
 * 切割
 * Created by xiaoxiaomo on 2012/4/11.
 */
public class Test6 {

    public static void main(String[] args) throws IOException{

        cuteFile() ;

    }

    private static void cuteFile() throws IOException {

        //1. 读取文件
        File file = new File("d://a.txt");
        FileInputStream fis = new FileInputStream(file) ;

        //切割大小
        byte[] bytes = new byte[102400] ; //100KB

        FileOutputStream fos = null ;
        int len = 0 ;
        int count = 0;
        while ( (len = fis.read(bytes)) != -1 ){
//            fos = new FileOutputStream("d://abc_"+ count++ +".txt") ;
            fos = new FileOutputStream(new File(file.getParent() +count+++".part") ) ;
            fos.write( bytes , 0, len );
            fos.close();
        }

        fis.close();



    }
}
