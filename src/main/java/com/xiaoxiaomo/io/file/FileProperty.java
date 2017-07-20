package com.xiaoxiaomo.io.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * 文件属性
 * Created by xiaoxiaomo on 2012/4/8.
 */
public class FileProperty {

    public static void main(String[] args) throws IOException {
        File file = new File("file/abc.txt") ;

        System.out.println( "getAbsolutePath : " + file.getAbsolutePath() ); //绝对路径
        System.out.println( "getName : " + file.getName() ); //文件名
        System.out.println( "getCanonicalPath : " + file.getCanonicalPath() ); //相对路径的规范形式
        System.out.println( "getPath : " + file.getPath() ); //传入什么就显示什么
        System.out.println( "length : " + file.length()); //文件大小

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        System.out.println( sdf.format( file.lastModified() ) ); //最后修改时间
    }

}
