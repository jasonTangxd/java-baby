package cn.xxo.momo.work;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 编程实现统计文本文件中某个单词的出现频率，并输出统计结果
 * 用HashMap来解决
 * 假设单词不存在跨行的,每个单词用空格分割
 * Created by xiaoxiaomo on 2016/4/12.
 */
public class Test10 {

    public static void main(String[] args) throws IOException {


        Map<String,Integer> map = new HashMap<String,Integer >() ;

        //1. 读取文本文件
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("abc.txt"))) ;

        String line = null ;
        while ( ( line = br.readLine())  != null ){
            String[] strs = line.split(" ") ;
            for (String str : strs) {
                if (map.get(str) == null) {
                    map.put( str , 1 ) ;
                } else {
                    map.put( str , map.get(str) + 1 ) ;
                }
            }
        }

        for (String s : map.keySet()) {
            System.out.println( s + "  =  " + map.get(s) );
        }




    }

}
