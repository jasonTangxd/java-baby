package com.xxo.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 读/写数据
 * Created by xiaoxiaomo on 2012/4/14.
 */
public class Channel01 {

    public static void main(String[] args) throws IOException {
        //1. 定义通道
        FileChannel inChannel = new RandomAccessFile("file/abc.txt", "rw").getChannel();

        //2. 缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //3. 读写数据
        int bytesRead ;
        while ( (bytesRead = inChannel.read(buf)) != -1) {
            System.out.println("=====Read " + bytesRead);

            //读模式下，可以读取之前写入到buffer的所有数据
            buf.flip(); //反转此缓冲区。将Buffer从写模式切换到读模式

            while(buf.hasRemaining()){ //告知在当前位置和限制之间是否有元素。
                System.out.print((char) buf.get());
            }

            buf.clear(); //清除此缓冲区。
        }

        //4. 关闭流
        inChannel.close();
    }
}
