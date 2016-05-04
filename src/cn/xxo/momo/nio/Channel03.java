package cn.xxo.momo.nio;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.io.RandomAccessFile;
import java.io.IOException;

/**
 * Created by xiaoxiaomo on 2016/4/25.
 */
public class Channel03 {
    public static void main (String [] argv) throws IOException {
        //创建通道
        FileChannel channel = new RandomAccessFile("momo.txt", "rw").getChannel();
        System.out.println("====="+channel.size());
        ByteBuffer buffer = ByteBuffer.allocate(10);

        long position = channel.position();
        System.out.println("当前position: " + position);

        //重新设定位置
        channel.position(position+5);//形成文件空洞
        buffer.clear();
        buffer.put("xiaoxiaomo".getBytes());
        buffer.flip();

        while(buffer.hasRemaining()) {//写文件
            channel.write(buffer);
        }

        //读取数据
        System.out.println("当前position: " + channel.position());
        readFile();//读取数据
        channel.close();
    }


    public static void readFile() throws IOException {
        FileChannel channel = new RandomAccessFile("momo.txt", "rw").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(10);
        //读文件
        while(channel.read(buffer) != -1 ) {
            buffer.flip();
            while(buffer.hasRemaining()) {
                System.out.print((char)buffer.get());
            }
            buffer.clear();
        }
        channel.close();
    }
}
//执行结果：
//=====0
//        当前position: 0
//        当前position: 15
//        xiaoxiaomo