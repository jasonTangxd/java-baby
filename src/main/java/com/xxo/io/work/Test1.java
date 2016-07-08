package com.xxo.io.work;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 获取指定目录下，指定扩展名的文件，获取文件绝对路径并按关键只过滤，
 * 并存入一个UTF-8格式的文件中
 * Created by xiaoxiaomo on 2012/4/11.
 */
public class Test1 {

    public static void main(String[] args) {


        //1. 定义一个数组容器接收，获取的文件绝对路径
        ArrayList<String> list = new ArrayList<>();

        //2. 获取指定目录下，指定扩展文件/扩展名的文件，
        fintFile( new File("d://aa")  , new MyFileNameFilter("cc" ,".java") , list ) ;

        //3. 保存文件
        writerFile( list , "d://a.txt" );


    }

    /**
     * 写入文件
     * @param list
     * @param path
     */
    public static void writerFile(ArrayList<String> list , String path) {
        if ( list.size() != 0 ){
            BufferedWriter writer = null ;
            try {
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path),"UTF-8")); //写入目标源

                //保存数据信息
                for (String s : list) {
                    writer.write(s);
                    writer.newLine(); //换行
                }
            } catch (IOException e) {
                //TODO 自己处理异常
                e.printStackTrace();
            } finally {
                //关闭流
                if( writer != null ){
                    try {
                        writer.close();
                    } catch (IOException e) {
                        //TODO 自己处理异常
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    /**
     * 获取文件
     * @param file 文件
     * @param filter 拦截器
     * @param list 保存绝对路径
     */
    private static void fintFile( File file, FilenameFilter filter, List<String> list) {
        //1. 判断文件是否存在
        if( !file.exists()){
            throw new RuntimeException("不是一个文件") ;
        }

        //获取目录下所用文件
        File[] files = file.listFiles();
        //遍历
        for (int i = 0; files != null && i < files.length; i++) {

            //目录 -- 继续遍历
            if( files[i].isDirectory() ){
                fintFile(files[i] , filter ,list);
            }

            //文件 -- 过滤并保存数据
            else {
                //过滤
                if ( filter.accept( files[i] , files[i].getName() ) ){
                    list.add(files[i].getAbsolutePath()); //保存文件绝对路径
                }
            }
        }

    }


    /**
     * 文件夹和文件后缀过滤
     */
    static class MyFileNameFilter implements FilenameFilter{

        private String dirFix ;
        private String nameFix ;

        /**
         * 文件夹和文件后缀过滤
         * @param dirFix 文件夹后缀
         * @param nameFix 文件后缀
         */
        public MyFileNameFilter(String dirFix, String nameFix) {
            this.dirFix = dirFix;
            this.nameFix = nameFix;
        }

        @Override
        public boolean accept(File dir, String name) {
            if( !dir.getAbsolutePath().contains(dirFix) ){
                return false ;
            }
            return name.endsWith(nameFix);
        }
    }

}
