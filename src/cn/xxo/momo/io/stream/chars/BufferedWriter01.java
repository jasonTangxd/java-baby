package cn.xxo.momo.io.stream.chars;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * BufferedWriter高效写入数据
 * Created by xiaoxiaomo on 2016/4/6.
 */
public class BufferedWriter01 {

    public static void main(String[] args) {

        BufferedWriter bfr = null ;
        try {
            //BufferedWriter需要传入一个Writer这里我们传入Writer的实现类FileWriter
            bfr = new BufferedWriter(new FileWriter("abc.txt" , true)) ;
            bfr.write("fsfsdfsfsa"); //写入
            bfr.write("ab"); //不断写入
            bfr.newLine();  //换行
            bfr.write("cd"); //继续写入

            bfr.flush(); //最好是自己手动去刷新
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if( bfr != null  )
                try {
                    bfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }


    }
}
