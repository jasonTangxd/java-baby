package com.xxo.url;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by xiaoxiaomo on 2012/4/13.
 */
public class URLDemo01 {

    static final String URL_ = "http://blog.xiaoxiaomo.com" ;
    static final String param = "" ;
    public static void main(String[] args) throws IOException {
        myGet();
        //myPOST();
    }

    public static void myGet() throws IOException {
        //1. 向指定URL发送GET方法的请求
        URL url = new URL(URL_);

        //2. 打开和URL之间的连接
        URLConnection conn1 = url.openConnection();


        //3. 设置通用的请求属性
        conn1.setRequestProperty("accept", "*/*");
        conn1.setRequestProperty("connection", "Keep-Alive");
        conn1.setRequestProperty("user-agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");

        //4. 建立实际的连接
        conn1.connect();

        //5. 直接从URL读取数据，并输出到标准输出
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = in.readLine()) != null)
            System.out.println(line);

        in.close();
    }

    public static void myPOST() throws IOException {
        //1. 向指定URL发送POST方法的请求
        URL url2 = new URL(URL_);

        //2. 打开和URL之间的连接
        URLConnection conn2 = url2.openConnection();

        //3. 设置通用的请求属性
        conn2.setRequestProperty("accept", "*/*");
        conn2.setRequestProperty("connection", "Keep-Alive");
        conn2.setRequestProperty("user-agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");

        //4. 发送POST请求必须设置如下两行
        conn2.setDoOutput(true);
        conn2.setDoInput(true);

        //5. 获取URLConnection对象对应的输出流
        PrintWriter out = new PrintWriter(conn2.getOutputStream());
        //发送请求参数
        //out.print(param);

        InputStream is = conn2.getInputStream();//得到输入流

        // 另一种得到输入流的方法:通过url直接获取
        // InputStream is = url.openStream();
        byte[] bytes = new byte[1024*10] ;
        int len ;
        while ( ( len = is.read(bytes) ) != -1 ){
            System.out.println(new String(bytes , 0 ,len ));
        }
    }
}
