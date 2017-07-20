package com.xiaoxiaomo.nio;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;

/**
 * Created by xiaoxiaomo on 2012/4/25.
 */
public class Channel04 {
    public static void main (String [] argv) throws IOException {
        //1. 创建一个临时文件和获取一个通道
        File temp = File.createTempFile("xiaoxiaomo", null);
        FileChannel channel = new RandomAccessFile(temp, "rw").getChannel();

        //2. 创建一个缓冲区并存入数据
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect (100);
        putData (0, byteBuffer, channel);//position=0
        putData (10, byteBuffer, channel);//position=10
        putData (20, byteBuffer, channel);//position=20

        // 文件中有两个洞，大小为26
        System.out.println ("temp file '" + temp.getPath( )
                + "', size=" + channel.size( ));
        channel.close();
    }

    //写入数据
    private static void putData(
            int position, ByteBuffer buffer, FileChannel channel)throws IOException{
        String string = "xiao" + position;//待写入字符串
        buffer.clear();
        buffer.put (string.getBytes ("US-ASCII"));
        buffer.flip();

        channel.position(position);//设置position
        channel.write(buffer);//写入数据
    }
}
//输出结果
//temp file 'C:\Users\xiaoxiaomo\AppData\Local\Temp\xiaoxiaomo*******.tmp', size=26