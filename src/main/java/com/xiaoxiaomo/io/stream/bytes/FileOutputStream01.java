package com.xiaoxiaomo.io.stream.bytes;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 写出
 * Created by xiaoxiaomo on 2012/4/7.
 */
public class FileOutputStream01 {
    public static void main(String[] args) throws IOException {

        FileOutputStream fos = new FileOutputStream("d:\\1abc.txt") ;
        fos.write('v');
        fos.write('b');
        fos.write('b');
        fos.write('b');

        fos.write(97); //这里是一个阿克斯码==等于a

        fos.write("abc".getBytes()); //byte数组
        byte[] bytes = "abc".getBytes();

        //字节码
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }

        System.out.println();
        fos.close();

    }
}
