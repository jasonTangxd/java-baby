package com.xxo.io.work;

import com.xxo.io.file.MyFileFilter;

import java.io.*;
import java.util.*;

/**
 * 拆分写入配置文件，合并
 * Created by xiaoxiaomo on 2012/4/11.
 */
public class Test8 {

    public static void main(String[] args) throws Exception {

//        splite_File(new File("d://a.txt") ); //拆分文件
        merge_File( new File( "d://" ) , new File( "f://" ) ) ;

    }

    /**
     * 合并文件
     * @param partFile 合并之前的目录
     * @param mergeFile 合并之后文件目录
     */
    private static void merge_File(File partFile, File mergeFile) throws Exception{

        //1. 获取之前目录文件，并校验

        //1.1 校验目录
        if( !partFile.exists() || !mergeFile.exists() ){
            throw new InvalidClassException("不存在该目录") ;//校验目录
        }

        File[] listFiles = partFile.listFiles(new MyFileFilter(".part"));//获取块文件
        File[] propFiles = partFile.listFiles(new MyFileFilter(".properties"));//获取配置文件
        Properties properties = null ;
        //1.2 校验元数据配置
        if( propFiles == null || propFiles.length != 1 ){
            throw new InvalidClassException("元数据，配置文件必须为一个！") ;
        }

        //加载配置文件
        else {
            properties = new Properties() ;
            properties.load(new FileInputStream( propFiles[0]) );
        }

        //1.3 校验元数据
        if( listFiles == null || listFiles.length != Integer.valueOf(properties.getProperty("filenum")) ){
            throw  new InvalidClassException("元数据，出现丢失现象！") ;
        }

        //2. 把目录文件添加到集合中
        List<FileInputStream> list = new ArrayList<FileInputStream>() ;
        for (File file : listFiles) {
            list.add( new FileInputStream(file) ) ;
        }

        //3. 通过集合工具，添加集合文件

        Enumeration enumeration = Collections.enumeration(list);

        //通关SequenceInputStream合并
        SequenceInputStream sequence = new SequenceInputStream(enumeration);


        //4. 读取文件，以及写入信息
        FileOutputStream output = new FileOutputStream(
                new File(mergeFile , properties.getProperty("filename"))) ; //写入流
        byte[] bytes = new byte[1024] ;
        int len  ;
        while ( ( len = sequence.read( bytes ) ) != -1 ){
            output.write(bytes,0,len);
        }

        //5. 关闭
        output.close();
        sequence.close();

    }

    /**
     * 拆分文件
     * @param file
     */
    private static void splite_File(File file) throws IOException {

        //切分文件
        //1. 获取需要拆分的文件
        FileInputStream inputStream = new FileInputStream(file);

        //2. 读取文件，并拆分保存
        //2.1 定义一个写入流
        FileOutputStream outputStream = null; //写入流
        byte[] bytes = new byte[1024*100] ;
        int len ;
        int count = 0 ;
        while ( ( len = inputStream.read(bytes) )  != -1 ){
            outputStream = new FileOutputStream(new File(file.getParentFile(),count+++".part")) ;//实例化写入流

            outputStream.write(bytes, 0, len);
            outputStream.close();
        }

        //3. 拆分信息保存到配置文件
        Properties properties = new Properties() ; //实例化配置对象
        properties.setProperty("filename",file.getName()) ; //赋值
        properties.setProperty("filenum", count + "") ; //赋值
        properties.store(new FileOutputStream(new File(file.getParent(), "properties.properties")), "properties" );//存储数据


        //4. 关闭
        inputStream.close();
    }





}
