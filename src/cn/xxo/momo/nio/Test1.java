package cn.xxo.momo.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * nio读取数据
 * Created by xiaoxiaomo on 2016/4/15.
 */
public class Test1 {

    public static void main(String[] args) throws IOException {
        //1. 从FileInputStream中获取通道channel
        FileInputStream inputStream = new FileInputStream("abc.txt");
        FileChannel channel = inputStream.getChannel();

        //2. 创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //3. 将数据从channel中读取到buffer中
        int read = channel.read(buffer);


    }

}
