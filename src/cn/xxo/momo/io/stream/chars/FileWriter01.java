package cn.xxo.momo.io.stream.chars;

import java.io.FileWriter;
import java.io.IOException;

/**
 * File 字符流
 * 字符写入流
 * Created by xiaoxiaomo on 2016/4/6.
 */
public class FileWriter01 {

    //获取系统级别的换行符
    private static final String LINESEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) throws IOException {

        //打开一个字符写入流
        FileWriter fw = new FileWriter("abc.txt") ;

        //写入文件
        fw.write("abcf"+LINESEPARATOR+"sdfs");

        //刷新文件流
        //fw.flush();
        fw.close();

    }
}
