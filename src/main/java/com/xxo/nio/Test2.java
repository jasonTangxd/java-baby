package com.xxo.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 写入文件
 * Created by xiaoxiaomo on 2012/4/15.
 */
public class Test2 {

    public static void main(String[] args) throws IOException{

        //1. 读取文件并获得通道channel
        FileOutputStream writer = new FileOutputStream("file/abc1.txt");
        FileChannel channel = writer.getChannel();

        //2. 创建一个缓存数组
        ByteBuffer buffer = ByteBuffer.allocate(1024) ;

        //3. 写入数据
        buffer.put("hello io!".getBytes());

        buffer.flip();

        channel.write(buffer ) ;

        writer.close();




    }


}
