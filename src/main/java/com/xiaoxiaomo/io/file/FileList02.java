package com.xiaoxiaomo.io.file;

import java.io.File;

/**
 * 过滤文件
 * Created by xiaoxiaomo on 2012/4/8.
 */
public class FileList02 {

    public static void main(String[] args) {
        File file = new File("d://");
        //listFiles,可以传入文件过滤器
        File[] files = file.listFiles(new MyFileFilter(".txt"));
        for (File file1 : files) {
            System.out.println(file1.getName());
        }

    }
}

