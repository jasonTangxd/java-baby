package com.xxo.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 *
 * 通道
 * Created by xiaoxiaomo on 2012/4/23.
 */
public class ChannelTest01 {

    public static void main(String[] args) throws IOException {

        //1. 创建通道
        ReadableByteChannel rbyc = Channels.newChannel(System.in);
        WritableByteChannel wbyc = Channels.newChannel(System.out);

        detailChnnel(rbyc, wbyc);
        //detailChnnel2(rbyc, wbyc);//第二种方法

        //4. 关闭
        rbyc.close();
        wbyc.close();

    }

    public static void detailChnnel(
            ReadableByteChannel rbyc, WritableByteChannel wbyc) throws IOException {
        //2. 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //3. 处理数据-输入并打印到控制台
        while ( rbyc.read( buffer ) != -1 ){//读入数据到缓冲区

            //翻转-准备读出缓冲区的数据
            buffer.flip() ;

            wbyc.write( buffer ) ;//从缓冲区写出到控制台

            //压缩-把已经读过的数据抛弃，使用后面的数据覆盖（移动至索引0）
            buffer.compact() ;
        }

        System.out.println("结束程序后--------");
        while ( buffer.hasRemaining() ){//告知在当前位置和限制之间是否有元素。
            wbyc.write( buffer ) ;//
        }
    }

    public static void detailChnnel2(
            ReadableByteChannel rbyc, WritableByteChannel wbyc) throws IOException {

        //2. 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (rbyc.read(buffer) != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                wbyc.write(buffer);//从缓冲区写出到控制台
            }
            //重设缓冲区以便接收更多的字节
            buffer.compact();
            //buffer.clear();
        }
    }

}
