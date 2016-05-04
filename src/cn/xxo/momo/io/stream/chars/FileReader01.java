package cn.xxo.momo.io.stream.chars;

import java.io.FileReader;
import java.io.IOException;

/**
 * 读取字符流
 * Created by xiaoxiaomo on 2016/4/6.
 */
public class FileReader01 {
    public static void main(String[] args) {

        FileReader fr = null ;
        try {
            fr = new FileReader("abc.txt") ;
//            int read = fr.read();
//            System.out.println(read);
//            int read2 = fr.read();
//            System.out.println(read2);
//            int read3 = fr.read();
//            System.out.println(read3);
            /**
             * 单个字符读取
             */
//            int red = 0 ;
//            while( (red = fr.read()) != -1 ){
//                System.out.print((char)red);
//            }


            char[] buf = new char[3] ;
            int len = 0 ;
            //int i = 0 ;
            while ( (len = fr.read(buf)) != -1 ){
               // System.out.println(++i);
                System.out.println(new String(buf,0,len));
            }
            System.out.println(new String(buf));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭字符流
            if( fr != null ){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
