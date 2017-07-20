package com.xiaoxiaomo.io.file;

import java.io.File;

/**
 * 过滤文件名
 * Created by xiaoxiaomo on 2012/4/8.
 */
public class FileList {

    public static void main(String[] args) {
        File file = new File( "d:\\dev\\idea\\xxo_java01" ) ;
//        String[] list = file.list();
//        for (String s : list) {
//            if( s.endsWith(".txt") )
//            System.out.println(s);
//        }

        //通过自定义的过滤器
        //通过文件名
        String[] list = file.list(new MyFilenameFilter(".txt"));
        for (String s : list) {
            System.out.println(s);
        }
    }
}


