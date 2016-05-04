package cn.xxo.momo.io.stream.bytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 通过字节流可以拷贝非字符文件
 * 比如mp3,图片视频等
 * Created by xiaoxiaomo on 2016/4/7.
 */
public class FileCopy01 {

    public static void main(String[] args) throws IOException {

        //1. FileInputStream读取文件源
        FileInputStream fis = new FileInputStream("D:\\favicon.ico") ;

        //1.1. FileOutputStream写入文件源
        FileOutputStream fos = new FileOutputStream("D:/1.ico") ;

        //2. 一边读取一边写入
        //2.1 第一种读取方法，读取一个后就写入
//        int ch = 0 ;
//        while ( ( ch = fis.read() ) != -1 ){
//            fos.write(ch);
//        }

        //2.2 第二种读取方式，读取一个byte[]
        byte[] bytes = new byte[1024] ;//建议1024的倍数,这里是1KB
        int len = 0 ;
        while ( ( len = fis.read( bytes ) ) != -1 ){
            System.out.println(len);
            fos.write( bytes , 0 ,len );
        }

        //3. 关闭流
        fis.close();
        fis.close();

    }
}
