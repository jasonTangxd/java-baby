package com.xiaoxiaomo.io.file;

import java.io.File;

/**
 * File类的用法
 * Created by xiaoxiaomo on 2012/4/8.
 */
public class FileDemo01 {

    public static void main(String[] args) {

        //实例化时不会产生对象
        //1. 可以是文件或文件名
        File file = new File("d://abc1.txt") ;

//        //2. 目录和文件分开
//        File file1 = new File("D://" , "abc.txt") ;
//
//        //3.
//        File file2 = new File(new File("D://") , "abc.txt") ;

        System.out.println(file.getName() );
    }
}
