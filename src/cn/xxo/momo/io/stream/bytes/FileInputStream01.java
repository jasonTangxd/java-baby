package cn.xxo.momo.io.stream.bytes;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节流(InputStream)读（入）
 * 读入写出
 * Created by xiaoxiaomo on 2016/4/7.
 */
public class FileInputStream01 {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("abc.txt") ;

        // 方法一：fis.read() 每次读取一个字节
        // 如果读取中文（两个字节）就会出现乱码
//        int ch =  0 ;
//        while ( ( ch = (fis.read() ) ) != -1 ){
//            System.out.println((char)ch);
//        }

        // 方法二：fis.read(byte[] buf) 可以一次读取多个字节
        // 如果byte[n],n比较大就不会乱码，大概大于3左右就不会乱码（这个和编码有关）
        byte[] buf = new byte[1024] ; //建议1024的倍数
        int len = 0 ;
        while ( ( len = fis.read(buf) ) != -1 ){
            System.out.println(new String( buf , 0 ,len ));
        }


        fis.close();

    }
}
