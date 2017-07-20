package com.xiaoxiaomo.io.file;

import java.io.File;

/**
 * 递归文件
 * 深度遍历
 * Created by xiaoxiaomo on 2012/4/8.
 */
public class RecursionFile {
    public static void main(String[] args) {
        recursion(new File("D://abc") , 0 );
    }


    /**
     * 递归
     * @param file
     * @param count
     */
    public static void recursion( File file , int count ) {

        System.out.println(addSpace(count) + file.getName());
        count++ ;
        //1. 遍历
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {

            //2. 如果是目录
            if( files[i].isDirectory() ){
                recursion(files[i] , count );
            }

            //3. 文件
            else{
                System.out.println(addSpace(count) + files[i].getName());
            }
        }

    }

    /**
     * 添加缩进
     * @param count
     * @return
     */
    private static String addSpace( int count ) {

        StringBuffer sb = new StringBuffer() ;
        for (int i = 0; i <= count; i++) {
            sb.append("|---") ;
        }
        return sb.toString();
    }
}
