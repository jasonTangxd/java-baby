package com.xiaoxiaomo.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * scatter 分散
 * Created by xiaoxiaomo on 2012/4/23.
 */
public class ScatterDemo {

    private static Charset charset = Charset.forName("GBK");

    public static void main(String[] args) throws IOException {
        final String fileName = "D:/test.log";
        //写入数据
        writeData(fileName, "abcde999efghigk12345678");

        /**----------Scatter------------*/
        //read(java.nio.ByteBuffer[])
        scatter(fileName);

        //read(java.nio.ByteBuffer[], int, int)
        scatter2(fileName);
    }

    /**
     * Scatter 分散
     * @param fileName
     * @throws IOException
     */
    private static void scatter(final String fileName) throws IOException {
        
        //1. 获取文件通道
        RandomAccessFile accessFile = new RandomAccessFile(fileName, "r");
        FileChannel channel = accessFile.getChannel();
        
        //2. 创建两个缓冲区
        ByteBuffer head = ByteBuffer.allocate(5);
        ByteBuffer body = ByteBuffer.allocate(1024);

        //3. 缓冲区数组
        ByteBuffer[] buffers = {head, body};
        // channel读取的信息分散到head和body缓冲区中
        // head 前5个字节 |  body 剩下的
        System.out.println("scatter====共读到多少字节:" + channel.read(buffers));

        //head缓冲区中的数据:abcde
        head.flip();
        System.out.println("head缓冲区中的数据:" + charset.decode(head));

        //body缓冲区中的数据:999efghigk12345678
        body.flip();
        System.out.println("body缓冲区中的数据:" + charset.decode(body));

        //4. 关闭通道
        accessFile.close();
        channel.close();
    }

    /**
     * scatter2
     * @param fileName
     * @throws IOException
     */
    private static void scatter2(final String fileName) throws IOException {

        //1. 获取文件通道
        RandomAccessFile accessFile = new RandomAccessFile(fileName, "r");
        FileChannel channel = accessFile.getChannel();

        //2. 创建一个四个缓冲区
        ByteBuffer head = ByteBuffer.allocate(5);
        ByteBuffer body1 = ByteBuffer.allocate(3);
        ByteBuffer body2 = ByteBuffer.allocate(5);
        ByteBuffer body3 = ByteBuffer.allocate(2);

        ByteBuffer[] buffers = new ByteBuffer[]{ head, body1, body2, body3};
        //0从那个缓冲区开始被使用，使用3个缓冲区即head,body1,body2
        System.out.println("scatter2====共读到多少字节:" + channel.read(buffers, 0, 3));

        //head缓冲区中的数据:abcde
        head.flip();
        System.out.println("head缓冲区中的数据:" + charset.decode(head));

        //body1缓冲区中的数据:999
        body1.flip();
        System.out.println("body1缓冲区中的数据:" + charset.decode(body1));

        //body2缓冲区中的数据:efghi
        body2.flip();
        System.out.println("body2缓冲区中的数据:" + charset.decode(body2));

        //body3，没有数据
        body3.flip();
        System.out.println("body3缓冲区中的数据:" + charset.decode(body3));

        //4. 关闭流
        accessFile.close();
        channel.close();
    }

    /**
     * 写入数据
     * writeData
     * @param fileName
     * @param data
     * @throws IOException
     */
    private static void writeData(final String fileName, String data) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile(fileName, "rw");
        accessFile.writeBytes(data);
        accessFile.close();
    }
}

//scatter====共读到多少字节:23
//head缓冲区中的数据:abcde
//body缓冲区中的数据:999efghigk12345678
//scatter2====共读到多少字节:13
//head缓冲区中的数据:abcde
//body1缓冲区中的数据:999
//body2缓冲区中的数据:efghi
//body3缓冲区中的数据:

