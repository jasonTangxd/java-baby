package com.xxo.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * nio 复制一个文件
 * Created by xiaoxiaomo on 2012/4/15.
 */
public class Test3 {

    public static void main(String[] args) throws IOException {

        //1. 读取一个文件并获得管道channel
        FileInputStream stream = new FileInputStream("abc.txt");
        FileChannel fc1 = stream.getChannel();

        //2. 写入源
        FileOutputStream outputStream = new FileOutputStream("abc2.txt");
        FileChannel fc2 = outputStream.getChannel();


        //2. 创建一个缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //3. 读取并写入文件
        while ( true ){

            buffer.clear() ; //重设缓冲区

            int read = fc1.read(buffer);//读取文件
            if( read == -1 ){
                break;
            }

            //
            buffer.flip() ;//让缓冲区可以将新读入的数据写入另一个通道
            fc2.read( buffer ) ;//写入文件

        }
    }
}
