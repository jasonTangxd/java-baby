package com.xiaoxiaomo.io.stream.bytes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 向磁盘上写入一个文件
 * Created by xiaoxiaomo on 2012/4/7.
 */
public class Sream2Windows {

    public static void main(String[] args) throws IOException {

        //1.指定文件源
        FileOutputStream fos = new FileOutputStream("d://qq.txt" ) ;
        //fos.write("无法写入中文"); //直接写入中文失败，因为是字符流
        OutputStreamWriter writer = new OutputStreamWriter(fos, "gbk"); //这里可以指定编码
        writer.write("可以写入中文"); ;

        writer.close();

    }
}
