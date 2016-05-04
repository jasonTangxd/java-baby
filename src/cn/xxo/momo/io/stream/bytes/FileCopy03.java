package cn.xxo.momo.io.stream.bytes;

import java.io.*;

/**
 * 复制一个文件
 * Created by xiaoxiaomo on 2016/4/7.
 */
public class FileCopy03 {

    public static void main(String[] args) throws IOException {

        //读取源文件
        //转换并指定编码进行读取
        //高效读取
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("d:\\test.txt")));

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:\\test2.txt")));

        String line = null ;
        while ( ( line = reader.readLine() ) != null  ){
            writer.write(line);
            writer.newLine();
            writer.flush();
        }

        reader.close();
        writer.close();

    }
}
