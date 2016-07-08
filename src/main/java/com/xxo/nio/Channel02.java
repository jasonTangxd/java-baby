package com.xxo.nio;

import java.nio.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by xiaoxiaomo on 2012/4/23.
 */
public class Channel02 {

    public static void main(String []args) throws Exception{
        ReadableByteChannel readChannel = Channels.newChannel(System.in);
        WritableByteChannel writeChannel = Channels.newChannel(System.out);

        new Channel02().copyChannel(readChannel, writeChannel);
        readChannel.close();
        writeChannel.close();
    }

    public void copyChannel(ReadableByteChannel from ,WritableByteChannel to)
            throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while ( from.read(buffer) != -1 ) {
            buffer.flip();
            to.write(buffer);
            buffer.compact();
        }

        while (buffer.hasRemaining()) {
            System.out.println("结束程序后--------");
            to.write(buffer);
        }
    }
}
