package com.xxo.io.file;

import java.io.File;

/**
 * 递归删除文件
 * Created by xiaoxiaomo on 2012/4/8.
 */
public class RecursionFile02 {


    public static void main(String[] args) {
        File f = new File("D://abc - 副本");

        deleteFile(f) ;
    }

    /**
     * 递归删除是否是目录
     * @param f
     */
    private static void deleteFile(File f) {
        File[] files = f.listFiles();
        for (int i = 0; i < files.length ; i++) {
            //1. 如果是目录
            if( files[i].isDirectory() ){

                deleteFile( files[i] );
            }
            //2. 是文件或者是目录都去删除
            files[i].delete() ;
        }

        //删除顶级目录
        f.delete() ;
    }
}
