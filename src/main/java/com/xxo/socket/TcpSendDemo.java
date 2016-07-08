package com.xxo.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by xiaoxiaomo on 2012/4/12.
 */
public class TcpSendDemo {

    public static void main(String[] args) throws IOException {
        //1. 获取Socket对象
        Socket socket = null ;
        OutputStream outputStream = null;

        BufferedReader br = new BufferedReader(new InputStreamReader( System.in )) ;
        String line ;
        String ip = "192.168.3.{IP}" ;
        while ( ( line = br.readLine() ) != null) {
            for (int i = 84; i < 86; i++) {
                try {
                    socket = new Socket("192.168.3.254",4000) ;
                    socket.setSoTimeout(1000);
                    outputStream = socket.getOutputStream() ;
                    outputStream.write(line.getBytes());

                } catch (IOException e) {
                    System.out.println(i);
                } finally {
                    if( socket != null ){
                        socket.close();
                    }
                    if( outputStream != null ){
                        outputStream.close();
                    }
                }

            }
        }
        br.close();
    }
}
