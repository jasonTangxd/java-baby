package com.xiaoxiaomo.work;

import java.io.*;

/**
 * 应用FileInputStream类，编写应用程序，从磁盘上读取一个Java程序，
 * Created by xiaoxiaomo on 2012/4/12.
 */
public class Test3 {

    public static void main(String[] args) throws IOException {

        //D:\\aa\\c.java
        FileInputStream file = new FileInputStream(new File("D:\\aa\\c.java")) ;
        BufferedReader bf = new BufferedReader(new InputStreamReader(file)) ;

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out)) ;

        String line = null ;
        while ( ( line = bf.readLine() ) != null ){
//            System.out.println(line);
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bf.close();
        bufferedWriter.close();

    }
}
