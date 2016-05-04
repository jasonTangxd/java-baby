package cn.xxo.momo.io.stream.bytes;

import java.io.*;

/**
 * 字节流高效复制一个图片
 * Created by xiaoxiaomo on 2016/4/7.
 */
public class FileCopy02 {

    public static void main(String[] args) {

        //1. 读取源
        BufferedInputStream bis = null ;
        //1.1写入源
        BufferedOutputStream bos = null ;
        try {
            bis = new BufferedInputStream(new FileInputStream( "d:\\favicon.ico" )) ;
            bos = new BufferedOutputStream(new FileOutputStream("d:\\3.ico")) ;

            //2 . 读取数据
            //2.1 单个读取
//            int ch = 0 ;
//            while ( ( ch = bis.read() )  != -1){
//                bos.write(ch);
//            }

            //2.2 通过数组缓冲
            byte[] chs = new byte[1024] ; //1KB
            int len = 0 ;
            while ( ( len = bis.read( chs ) ) != -1 ) {
                bos.write( chs , 0 ,len );
            }

            //2.3 读取一行 无，因为没有行的概念



        } catch (IOException e) {
            //处理异常信息
            e.printStackTrace();
        } finally {

            //关闭流
            if (bis != null) {
                try {
                    bis.close() ;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bos != null) {
                try {
                    bos.close() ;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
