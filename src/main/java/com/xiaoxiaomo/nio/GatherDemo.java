package com.xiaoxiaomo.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Gather 聚合
 * Created by xiaoxiaomo on 2012/4/23.
 */
public class GatherDemo {

    public static void main(String[] args) throws IOException {
        final String fileName = "D:/test2.log";
        /**----------Gather------------*/
        //FileChannel#write(java.nio.ByteBuffer[])
        gather(fileName);

        //FileChannel#write(java.nio.ByteBuffer[], int, int)
        gather2(fileName);
    }

    /**
     * gather
     * @param fileName
     * @throws IOException
     */
    private static void gather(String fileName) throws IOException {
        //1. 获取文件通道
        RandomAccessFile accessFile = new RandomAccessFile(fileName, "rw");
        FileChannel channel = accessFile.getChannel();

        //2. 创建两个缓冲区head,body 并写入数据
        ByteBuffer head = ByteBuffer.allocate(5);
        head.put("abcde".getBytes());

        ByteBuffer body = ByteBuffer.allocate(1024);
        body.put("999efghigk12345678".getBytes());

        ByteBuffer[] allBuffers = { head, body };

        head.flip();
        body.flip();

        //将按allBuffers顺序  写入abcde999efghigk12345678
        System.out.println("gather====共写入多少字节:" + channel.write(allBuffers));

        //3. 关闭
        accessFile.close();
        channel.close();
    }

    /**
     * gather2
     * @param fileName
     * @throws IOException
     */
    private static void gather2(String fileName) throws IOException {

        //1. 获取文件通道
        RandomAccessFile accessFile = new RandomAccessFile(fileName, "rw");
        FileChannel channel = accessFile.getChannel();

        //2. 创建四个缓冲区
        ByteBuffer head = ByteBuffer.allocate(5);
        ByteBuffer body1 = ByteBuffer.allocate(3);
        ByteBuffer body2 = ByteBuffer.allocate(5);
        ByteBuffer body3 = ByteBuffer.allocate(20);

        head.put("abcde".getBytes());
        body1.put("999".getBytes());
        body2.put("efghi".getBytes());
        body3.put("gk12345678".getBytes());

        ByteBuffer[] allBuffers = new ByteBuffer[]{
            head, body1, body2, body3};

        head.flip();
        body1.flip();
        body2.flip();
        body3.flip();

        //将按allBuffers数组顺序使用两个缓冲区
        //0从哪开始
        //2使用几个
        //当前使用head  body1
        //最终写入abcdefg
        long n = channel.write(allBuffers, 0, 2);

        //应该返回8个字节
        System.out.println("gather2====共写入多少字节:" + n);

        accessFile.close();
        channel.close();
    }
}
//运行结果
//gather====共写入多少字节:23
//gather2====共写入多少字节:8