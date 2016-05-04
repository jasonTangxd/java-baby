package cn.xxo.momo.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Socket编程 demo1
 * Created by xiaoxiaomo on 2016/4/12.
 */
public class UdpSendDemo {

    public static void main(String[] args) throws IOException {

        //1. 获取Socket对象
        DatagramSocket ds = new DatagramSocket() ;

        //2. 封包
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in )) ;

        String line ;
        String ip = "192.168.1.{IP}" ;
        while ( ( line = br.readLine() ) != null){
            byte[] bytes = line.getBytes();
            for (int i = 2; i < 254 ; i++) {
                DatagramPacket p = new DatagramPacket(
                        bytes,bytes.length , InetAddress.getByName( ip.replace("{IP}", i+"" ) ) ,3000 ) ;
                ds.send(p);
            }
        }
        ds.close();
    }
}
