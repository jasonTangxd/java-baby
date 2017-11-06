package com.xiaoxiaomo.io.stream.bytes;

import java.io.File;
import java.util.*;

/**
 * Created by TangXD on 2017/11/6.
 */
public class FileDirSize {



    public static LinkedHashMap<Integer, ArrayList<String>>  getDirSize2(File file) {
        LinkedHashMap<Integer, ArrayList<String>> linkedHashMap = new LinkedHashMap<>();
        if ( file.exists() && file.isDirectory()) {
            //如果是目录则递归计算其内容的总大小
            File[] children = file.listFiles();
            int key = 0 ;
            long size = 0;
            ArrayList<String> paths = new ArrayList<>();
            for (File f : children != null ? children : new File[0]) {

                if ( f.length() >= 128*1024*1024 ){
                    ArrayList<String> path = new ArrayList<>();
                    path.add(f.getPath()) ;
                    linkedHashMap.put(key++ ,path) ;
                    continue;
                }

                if( size + f.length() >= 128*1024*1024 ){
                    size = f.length() ;
                    linkedHashMap.put(key++ , paths) ;
                    paths = new ArrayList<>();
                } else{
                    size += f.length() ;
                }
                paths.add(f.getPath()) ;
            }

            if(0 < paths.size()){
                linkedHashMap.put(key++ , paths) ;
            }
        }
        return linkedHashMap ;
    }


    public static long getDirSize(File file) {
        if (file.exists()) {
            //如果是目录则递归计算其内容的总大小
            if (file.isDirectory()) {
                File[] children = file.listFiles();
                long size = 0;
                for (File f : children) {
                    size += getDirSize(f);
                }
                return size;
            }
            //如果是文件则直接返回其大小
            else {

                return file.length();
            }
        } else {
            System.out.println("文件或者文件夹不存在，请检查路径是否正确！");
            return 0;
        }
    }


    public static void main(String[] args) {
        LinkedHashMap<Integer, ArrayList<String>> dirSize2 = getDirSize2(new File("D:\\迅雷下载"));
        for (Integer integer : dirSize2.keySet()) {
            ArrayList<String> strings = dirSize2.get(integer);
            for (String string : strings) {

                System.out.println(integer+ " " +string);
            }
        }
    }
}
